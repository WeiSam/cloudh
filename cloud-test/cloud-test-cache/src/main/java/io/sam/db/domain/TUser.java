package io.sam.db.domain;

import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/10 12:37
 */
@Data
@Accessors(chain = true)
public class TUser {
    private Integer id;

    private String name;

    private Integer age;

    private Byte gender;

    private String className;

    private String idCard;

    private Date createTime;
}