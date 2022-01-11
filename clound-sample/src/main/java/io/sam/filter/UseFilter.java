package io.sam.filter;


import com.alibaba.fastjson.JSON;
import io.sam.annotation.OperateLog;
import io.sam.db.domain.AccountTbl;
import io.sam.db.mapper.AccountTblMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhuweimu
 * @description
 * @date 2021/4/13 9:55
 */
@Slf4j
@WebFilter
public class UseFilter implements Filter, ApplicationContextAware {

    @Autowired
    AccountTblMapper accountTblMapper;

//    @Qualifier("requestMappingHandlerMapping")
//    @Autowired(required = false)
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    List<RequestMappingHandlerMapping> allRequestMappings;

    ApplicationContext applicationContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init filter");
    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("dofilter");
        WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletRequest.getServletContext());

        log.info("applicationContext == appContext:{}",this.applicationContext == appContext);

        for (HandlerMapping handlerMapping : allRequestMappings) {
            HandlerExecutionChain handler = handlerMapping.getHandler((HttpServletRequest) servletRequest);
            if (handler != null && handler.getHandler() instanceof HandlerMethod) {
                HandlerMethod method = (HandlerMethod)handler.getHandler();
                Object rootBean = method.getBean();
                Method method1 = method.getMethod();
                OperateLog operateLog = AnnotationUtils.findAnnotation(method1, OperateLog.class);
                if (operateLog != null) {
                    Object parse = parse(rootBean, operateLog.record(), method1, method.getMethodParameters());
                    log.info("method1 = {},operateLog.logBizDesc = {},parse = {}",method1.getName(),operateLog.logBizDesc(), JSON.toJSONString(parse));

                }
                break;
            }
        }
        if (requestMappingHandlerMapping != null) {
            HandlerExecutionChain handler = requestMappingHandlerMapping.getHandler((HttpServletRequest) servletRequest);
            HandlerMethod method = (HandlerMethod)handler.getHandler();
            Method method1 = method.getMethod();
            OperateLog operateLog = AnnotationUtils.findAnnotation(method1, OperateLog.class);
            log.info("method1 = {},operateLog.logBizDesc = {}",method1.getName(),operateLog.logBizDesc());
        }
        AccountTbl accountTbl = accountTblMapper.selectByPrimaryKey(1);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        //获取所有的RequestMapping
        Map<String, RequestMappingHandlerMapping> stringHandlerMappingMap = BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext,
                RequestMappingHandlerMapping.class, true, false);
        if (!stringHandlerMappingMap.isEmpty()) {
            this.allRequestMappings = new ArrayList<>(stringHandlerMappingMap.values());
            AnnotationAwareOrderComparator.sort(this.allRequestMappings);
        }
    }

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
