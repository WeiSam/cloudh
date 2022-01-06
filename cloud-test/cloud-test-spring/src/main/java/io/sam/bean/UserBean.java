package io.sam.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhuweimu
 * @classname UserBean
 * @description
 * @date 2021/3/22 11:10
 */
@Data
@Accessors(chain = true)
public class UserBean {
    private String id;
    private String name;
    private Integer age = 0;
}
