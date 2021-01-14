package io.sam.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuweimu
 * @classname OrgInfoConfig
 * @description
 * @date 2020/12/8 17:37
 */
@PropertySource(value = "classpath:application.properties",encoding = "UTF-8")
@ConfigurationProperties(prefix = "fujian1")
public class OrgInfoProperties implements Serializable{

    List<OrgInfo> orgInfos = new ArrayList<>();

    public List<OrgInfo> getOrgInfos() {
        return orgInfos;
    }

    public void setOrgInfos(List<OrgInfo> orgInfos) {
        this.orgInfos = orgInfos;
    }

}
