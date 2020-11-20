package io.sam.db.domain;

import lombok.Data;

import java.util.Date;

/**
 * @classname Order
 * @description 
 * @date 2020/11/13 15:11
 * @author zhuweimu
 */
@Data
public class Order {
    private String id;

    private String name;

    private String amount;

    private String money;

    private Date createTime;

    private Date updateTime;
}