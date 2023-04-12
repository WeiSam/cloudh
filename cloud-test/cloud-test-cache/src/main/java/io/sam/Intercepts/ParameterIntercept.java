package io.sam.Intercepts;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/11 11:08
 */
@Slf4j
@Intercepts(
        {
                @Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class}),
        }
)
public class ParameterIntercept implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("{}拦截",this.getClass().getName());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
