package io.sam.cache;

import lombok.Getter;

@Getter
public enum CaffeineCaches {
  PaymentConfig, // 支付配置
  BwUser, // 风险黑白名单
  Sysconfig, // 系统配置
  RiskConfig, // 风险配置
  Acount,
  Currency(30 * 60); // 货币信息

  // 默认值
  private int maxSize = 10000; // 最大數量

  private int ttl = 360; // 过期时间（秒）

  CaffeineCaches() {}

  CaffeineCaches(int ttl) {
    this.ttl = ttl;
  }

  CaffeineCaches(int ttl, int maxSize) {
    this.ttl = ttl;
    this.maxSize = maxSize;
  }
}
