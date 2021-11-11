package io.sam.aspect;

import com.alibaba.fastjson.JSON;
import io.sam.annotation.OperateLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhuweimu
 * @description
 * @date 2020/9/21 16:20
 */
@Component
@Aspect
@SuppressWarnings("rawtypes")
public class OperateLogInterceptor {
    Logger log = LoggerFactory.getLogger(OperateLogInterceptor.class);

    @Around("execution(* *(..)) && @annotation(io.sam.annotation.OperateLog)")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        boolean isSuccess = true;
        Object record;
        try {
            Object result = pjp.proceed();
            if (true){
                throw new Exception("test");
            }
            return result;
        }catch (Throwable e){
            isSuccess = false;
            throw e;
        }finally {
            OperateLog logLock = null;
            try {
                MethodSignature signature = (MethodSignature) pjp.getSignature();
                Method method = signature.getMethod();
                logLock = AnnotationUtils.findAnnotation(method, OperateLog.class);
                //生成请求参数
                record = generateRecord(pjp,method,logLock);
                log.info("保存日志,record = {}",record);
                if (isSuccess) {
                    log.info("记录成功日志,logOpt = {},logBizDesc = {},record = {}",logLock.logOpt(),logLock.logBizDesc(), JSON.toJSONString(record));
                }else {
                    log.info("记录失败日志,logOpt = {},logBizDesc = {},record = {}",logLock.logOpt(),logLock.logBizDesc(), JSON.toJSONString(record));
                }
            }catch (Exception e){
                log.error("日志埋点记录异常,logLock = {}",JSON.toJSONString(logLock),e);
            }

        }
    }

    public Object generateRecord(ProceedingJoinPoint joinPoint, Method targetMethod, OperateLog logLock) {
        Object target = joinPoint.getTarget();
        Object[] arguments = joinPoint.getArgs();
        String spel = null;
        if (logLock != null) {
            spel = logLock.record();
        }
        return parse(target, spel, targetMethod, arguments);
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
    public static Object parse(Object rootObject, String spel, Method method, Object[] args) {
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
        return parser.parseExpression(spel).getValue(context, Object.class);
    }
}
