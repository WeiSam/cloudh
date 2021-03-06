package io.sam.db.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author zhuweimu
 * @classname Order
 * @description
 * @date 2020/11/24 10:30
 */
@Data
public class Order {
    private Long id;

    private String name;

    private String amount;

    private String money;

    private Date createTime;

    private Date updateTime;
}