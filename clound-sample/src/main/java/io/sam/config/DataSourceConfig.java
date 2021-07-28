package io.sam.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@ConditionalOnProperty(value = "spring.datasource.enable",havingValue = "true")
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
            .getResources("classpath:mapper/*.xml"));
        return factoryBean.getObject();
    }

/*    @Bean("tradePlatformDataSource")
    public DataSource dataSource(@Qualifier("druidDataSource") DataSource ds) throws SQLException {
        return EncryptDataSourceFactory.createDataSource(ds, getEncryptRuleConfiguration(), new Properties());
    }

    public EncryptRuleConfiguration getEncryptRuleConfiguration(){
        Properties props = new Properties();

        //自带aes算法需要
        props.setProperty("aes.key.value", "123456");
        EncryptorRuleConfiguration encryptorConfig = new EncryptorRuleConfiguration("AES", props);

        EncryptRuleConfiguration encryptRuleConfig = new EncryptRuleConfiguration();
        encryptRuleConfig.getEncryptors().put("aes", encryptorConfig);

        //START: card_info 表的脱敏配置
        EncryptColumnRuleConfiguration columnConfig1 = new EncryptColumnRuleConfiguration("", "passeord", "", "aes");
        Map<String, EncryptColumnRuleConfiguration> columnConfigMaps = new HashMap<>();
        columnConfigMaps.put("passeord", columnConfig1);
        EncryptTableRuleConfiguration tableConfig = new EncryptTableRuleConfiguration(columnConfigMaps);
        encryptRuleConfig.getTables().put("t_userinfo", tableConfig);
        return encryptRuleConfig;
    }*/
}
