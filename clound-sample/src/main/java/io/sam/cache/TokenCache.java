package io.sam.cache;

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
        // 尝试读取缓存
        readLock.lock();
        V value;
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
    public V put(K key, V value){
        writeLock.lock();
        try {
            cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
        return value;
    }

    public Map<K, V> getCache() {
        return cache;
    }
}
