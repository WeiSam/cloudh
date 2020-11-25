package io.sam.db.domain;

import java.util.Date;
import lombok.Data;

/**
 * @classname TOrder1
 * @description 
 * @date 2020/11/20 15:52
 * @author zhuweimu
 */
@Data
public class TOrder1 {
    private String id;

    private String name;

    private String amount;

    private String money;

    private Date createTime;

    private Date updateTime;
}