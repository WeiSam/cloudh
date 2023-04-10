package model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 
 * @date 2022/3/6 11:10
 * @author zhuweimu
 */
@Data
@NoArgsConstructor
public class UserInfo implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private Date createTime;
}