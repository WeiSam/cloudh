package io.sam.service.impl;

import io.sam.annotation.DisLock;
import io.sam.service.RedisKeyGenerator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
public class DefaultRedisKeyGenerator implements RedisKeyGenerator {

	@Override
	public String generate(ProceedingJoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method targetMethod = methodSignature.getMethod();
		Object target = joinPoint.getTarget();
		Object[] arguments = joinPoint.getArgs();
		DisLock redisLock = AnnotationUtils.findAnnotation(targetMethod, DisLock.class);
		StringBuilder key = new StringBuilder();
		String spel = null;
		if (redisLock != null) {
			spel = redisLock.key();
		}
		return key.append("LOCK:").append(redisLock.prefix()).append(redisLock.delimiter()).append(parse(target, spel, targetMethod, arguments)).toString();
	}

	/**
	 * 支持 #p0 参数索引的表达式解析
	 *
	 * @param rootObject
	 *            根对象,method 所在的对象
	 * @param spel
	 *            表达式
	 * @param method
	 *            ，目标方法
	 * @param args
	 *            方法入参
	 * @return 解析后的字符串
	 */
	public static String parse(Object rootObject, String spel, Method method, Object[] args) {
		// 获取被拦截方法参数名列表(使用Spring支持类库)
		LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
		String[] paraNameArr = u.getParameterNames(method);
		// 使用SPEL进行key的解析
		ExpressionParser parser = new SpelExpressionParser();
		// SPEL上下文
		StandardEvaluationContext context = new MethodBasedEvaluationContext(rootObject, method, args, u);
		// 把方法参数放入SPEL上下文中
		for (int i = 0; i < paraNameArr.length; i++) {
			context.setVariable(paraNameArr[i], args[i]);
		}
		return parser.parseExpression(spel).getValue(context, String.class);
	}

}