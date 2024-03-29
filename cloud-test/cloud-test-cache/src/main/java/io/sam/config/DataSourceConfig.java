package io.sam.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.sam.Intercepts.ParameterIntercept;
import io.sam.Intercepts.ResultSetIntercept;
import io.sam.Intercepts.StatementIntercept;
import io.sam.Intercepts.TableNameIntercept;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@ConditionalOnProperty(value = "spring.datasource.enable",havingValue = "true")
public class DataSourceConfig {

    //会依赖注入Spring容器中所有的mybatis的Interceptor拦截器
    @Autowired(required = false)
    private Interceptor[] interceptors;

    @Bean
    public TableNameIntercept tableNameIntercept(){
        return new TableNameIntercept();
    }

    @Bean
    public ParameterIntercept parameterIntercept(){
        return new ParameterIntercept();
    }

    @Bean
    public ResultSetIntercept resultSetIntercept(){
        return new ResultSetIntercept();
    }

    @Bean
    public StatementIntercept statementIntercept(){
        return new StatementIntercept();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

/*    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPlugins(interceptors);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
            .getResources("classpath:mapper/*.xml"));
        return factoryBean.getObject();
    }*/
}
