package io.sam.db.domain;

import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhuweimu
 * @description
 * @date 2021/8/30 9:18
 */
@Data
@Accessors(chain = true)
public class Userinfo {
    private Integer id;

    private String name;

    private String password;

    private Integer age;

    private Integer num;

    private Date createTime;

    private Date updateTime;
}