package io.sam.Intercepts;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/10 10:41
 */
@Slf4j
@Intercepts(
        {
                @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        }
)
public class TableNameIntercept implements Interceptor {

    public static final List<String> TABLE_NAMES = Arrays.asList("t_user","t_user_detai");

    /**
     * 拦截逻辑处理
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        //获取MappedStatement对象
        MappedStatement ms = (MappedStatement) args[0];
        //获取传入sql语句的参数对象
        Object parameterObject = args[1];
        BoundSql boundSql = ms.getBoundSql(parameterObject);
        //获取到拥有占位符的sql语句
        String sql = boundSql.getSql();
        log.info("拦截前SQL:{}",sql);
        if (!isTable(sql)){
            log.info("非分表不拦截");
            return invocation.proceed();
        }
        //替换表名
        String oldTableName = "t_user";
        String newTableName = getNewTableName(oldTableName,parameterObject);
        sql = replaceTableName(sql,oldTableName,newTableName);
        log.info("拦截后SQL:{}",sql);
        //重新生成一个BoundSql对象
        BoundSql bs = new BoundSql(ms.getConfiguration(),sql,boundSql.getParameterMappings(),parameterObject);
        //重新生成一个MappedStatement对象
        MappedStatement newMs = copyMappedStatement(ms, new BoundSqlSqlSource(bs));
        //赋回给实际执行方法所需的参数中
        args[0] = newMs;
        return invocation.proceed();
    }

    private String replaceTableName(String sql, String oldTableName, String newTableName) {
        return sql.replaceAll(oldTableName,newTableName);
    }

    private String getNewTableName(String oldTableName, Object parameterObject) {
        return oldTableName+"_"+index(parameterObject);
    }

    public static int index(Object obj){
        // 先获取productId的hash值
        int hash = obj.hashCode() ^ (obj.hashCode() >>> 16);
        // 对hash值取模，将hash值路由到指定的内存队列中,
        // 队列大小最好设置为2的幂次方,增加散列度
        int index = (4 - 1) & hash;
        return index+1;
    }

    private boolean isTable(String sql) {
        for (String tableName : TABLE_NAMES) {
            if (sql.contains(tableName)) {
                return true;
            }
        }
        return false;
    }

    private MappedStatement copyMappedStatement (MappedStatement ms, SqlSource newSqlSource) {

        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());

        builder.resource(ms.getResource());

        builder.fetchSize(ms.getFetchSize());

        builder.statementType(ms.getStatementType());

        builder.keyGenerator(ms.getKeyGenerator());

        if (ms.getKeyProperties() != null && ms.getKeyProperties().length > 0) {

            builder.keyProperty(String.join(",",ms.getKeyProperties()));

        }

        builder.timeout(ms.getTimeout());

        builder.parameterMap(ms.getParameterMap());

        builder.resultMaps(ms.getResultMaps());

        builder.resultSetType(ms.getResultSetType());

        builder.cache(ms.getCache());

        builder.flushCacheRequired(ms.isFlushCacheRequired());

        builder.useCache(ms.isUseCache());

        return builder.build();

    }

    /**
     * 重要，返回动态代理对象
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 设置属性值
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }

    public static class BoundSqlSqlSource implements SqlSource {

        private final BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;

        }

        @Override
        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;

        }

    }

}
