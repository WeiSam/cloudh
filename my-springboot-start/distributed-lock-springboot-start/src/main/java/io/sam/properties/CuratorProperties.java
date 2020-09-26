package io.sam.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhuweimu
 * @classname CuratorProperties
 * @description
 * @date 2020/9/23 19:15
 */
@ConfigurationProperties(prefix = "curator.zoo")
public class CuratorProperties {

    private boolean enabled;
    private String connectString;
    /**
     * 初始重试时间
     */
    private int baseSleepTimeMs;
    /**
     * 最多重试次数
     */
    private int maxRetries;

    private int connectionTimeoutMs;

    private int sessionTimeoutMs;
    private String namespace;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public int getBaseSleepTimeMs() {
        return baseSleepTimeMs;
    }

    public void setBaseSleepTimeMs(int baseSleepTimeMs) {
        this.baseSleepTimeMs = baseSleepTimeMs;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public int getConnectionTimeoutMs() {
        return connectionTimeoutMs;
    }

    public void setConnectionTimeoutMs(int connectionTimeoutMs) {
        this.connectionTimeoutMs = connectionTimeoutMs;
    }

    public int getSessionTimeoutMs() {
        return sessionTimeoutMs;
    }

    public void setSessionTimeoutMs(int sessionTimeoutMs) {
        this.sessionTimeoutMs = sessionTimeoutMs;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
