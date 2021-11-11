package io.sam.cache;

import lombok.Getter;

/**
 * 定义redis cache名称、超时时长
 */
@Getter
public enum RedisCaches {

	OrderDetail,Acount, DispatcherDetail;

	public int ttl = 360; // 过期时间（秒）

	RedisCaches() {
	}

	RedisCaches(int ttl) {
		this.ttl = ttl;
	}
}
