package io.sam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zhuweimu
 * @Classname HuJianConfig
 * @Description
 * @Date 2020/8/6 17:12
 */
@Configuration
@PropertySource(value = "classpath:application.properties",encoding = "UTF-8")
@EnableConfigurationProperties({UserInfoProperties.class, OrgInfoProperties.class})
public class FuJianConfig {

    /**
     * 访问服务的地址
     */
    @Value("${fujian.sync.url:http://10.130.104.86:8081/ServiceBus/webService/unifyConnector}")
    private String url;
    /**
     * AccessKey
     */
    @Value("${fujian.sync.ak:1df491ee71f347928bd15e1f02f45a97}")
    private String ak;
    /**
     * SecretKey
     */
    @Value("${fujian.sync.sk:d512c5584bee4460ac1226f3c9596420}")
    private String sk;

    /**
     * 同步频率
     */
    @Value("${fujian.sync.interval:0/10 * * * * ?}")
    private String interval;

    /**
     * 其他接口调用方法
     */
    @Value("${fujian.sync.otherApiName:savetysjrk_test}")
    private String otherApiName;

    /**
     * 服务版本号
     */
    @Value("${fujian.sync.version:1.0}")
    private String version = "1.0";
    /**
     * 初始化同步开始时间
     */
    @Value("${fujian.sync.startTime:2020-08-25 00:00:00}")
    private String startTime;

    @Value("${fujian.sync.caseCenterCode}")
    private String caseCenterCode;

    /**
     * 接口调用民警是否指定
     */
    @Value("${fujian.sync.isFixedPolice:false}")
    private Boolean isFixedPolice;

    /**
     * 笔录接口调用方法
     */
    @Value("${fujian.sync.blApiName:savetysjrk_test}")
    private String blApiName;

    @Autowired
    UserInfoProperties userInfoProperties;

    @Autowired
    OrgInfoProperties orgInfoProperties;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getOtherApiName() {
        return otherApiName;
    }

    public void setOtherApiName(String otherApiName) {
        this.otherApiName = otherApiName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCaseCenterCode() {
        return caseCenterCode;
    }

    public void setCaseCenterCode(String caseCenterCode) {
        this.caseCenterCode = caseCenterCode;
    }

    public Boolean getFixedPolice() {
        return isFixedPolice;
    }

    public void setFixedPolice(Boolean fixedPolice) {
        isFixedPolice = fixedPolice;
    }

    public String getBlApiName() {
        return blApiName;
    }

    public void setBlApiName(String blApiName) {
        this.blApiName = blApiName;
    }

    public UserInfoProperties getUserInfoProperties() {
        return userInfoProperties;
    }

    public void setUserInfoProperties(UserInfoProperties userInfoProperties) {
        this.userInfoProperties = userInfoProperties;
    }

    public OrgInfoProperties getOrgInfoProperties() {
        return orgInfoProperties;
    }

    public void setOrgInfoProperties(OrgInfoProperties orgInfoProperties) {
        this.orgInfoProperties = orgInfoProperties;
    }

    @Override
    public String toString() {
        return "FuJianConfig{" +
                "url='" + url + '\'' +
                ", ak='" + ak + '\'' +
                ", sk='" + sk + '\'' +
                ", interval='" + interval + '\'' +
                ", otherApiName='" + otherApiName + '\'' +
                ", version='" + version + '\'' +
                ", startTime='" + startTime + '\'' +
                ", caseCenterCode='" + caseCenterCode + '\'' +
                ", isFixedPolice=" + isFixedPolice +
                ", blApiName='" + blApiName + '\'' +
                '}';
    }
}
