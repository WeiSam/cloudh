package io.sam.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zhuweimu
 * @classname UserInfoPro
 * @description
 * @date 2020/10/12 16:28
 */
@PropertySource(value = "classpath:application.properties",encoding = "UTF-8")
@ConfigurationProperties(prefix = "fujian.sync.userinfo")
public class UserInfoProperties {
    private String userName;
    private String userCode;
    private String idCard;
    private String organizeCode;
    private String organizeName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getOrganizeCode() {
        return organizeCode;
    }

    public void setOrganizeCode(String organizeCode) {
        this.organizeCode = organizeCode;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }
}
