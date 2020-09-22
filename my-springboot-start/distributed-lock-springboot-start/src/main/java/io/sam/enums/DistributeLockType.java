package io.sam.enums;

/**
 * @author zhuweimu
 * @classname DistributeLockType
 * @description
 * @date 2020/9/22 9:13
 */
public enum DistributeLockType {
    REDISSON_LOCK("REDISSON_LOCK","redisson实现分布式锁"),
    ZOOKEEPER_LOCK("ZOOKEEPER_LOCK","zookeeper实现分布式锁");

    private String value;
    private String name;

    DistributeLockType(String value, String name) {
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
