package io.sam.enums;

import io.sam.constant.Constants;

/**
 * @author zhuweimu
 * @classname DistributeLockType
 * @description
 * @date 2020/9/22 9:13
 */
public enum LockServiceType {
    REDISSON(Constants.REDISSON_LOCK_SERVICE,"redisson实现分布式锁服务类"),
    CURATOR(Constants.CURATOR_LOCK_SERVICE,"zookeeper实现分布式锁服务类");

    private String value;
    private String name;

    LockServiceType(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
