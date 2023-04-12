package io.sam.Intercepts;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/11 11:07
 */
@Slf4j
@Intercepts(
        {
                @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        }
)
public class StatementIntercept implements Interceptor {
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
