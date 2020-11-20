package io.sam.cache;

import io.sam.service.ValueFuntional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author zhuweimu
 * @classname TokenCache
 * @description
 * @date 2020/10/13 14:17
 */
public class TokenCache<K,V> {

    private final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private final Map<K, V> cache = new HashMap<>();
    private final ReadLock readLock = cacheLock.readLock();
    private final WriteLock writeLock = cacheLock.writeLock();

    public V get(K key) {
        V value;
        // 尝试读取缓存
        readLock.lock();
        try {
            value = cache.get(key);
        } finally {
            readLock.unlock();
        }
        return value;
    }

    /**
     * 放入缓存
     * @param key 键
     * @param value 值
     * @return 值
     */
    public V put(K key, ValueFuntional<V> value){
        V v;
        writeLock.lock();
        try {
            v = value.value();
            cache.put(key, v);
        } finally {
            writeLock.unlock();
        }
        return v;
    }

    public Map<K, V> getCache() {
        return cache;
    }
}
