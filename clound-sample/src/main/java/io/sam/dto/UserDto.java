package io.sam.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhuweimu
 * @Classname UserDto
 * @Description
 * @date 2020/9/4 19:46
 */
@Data
@Accessors(chain = true)
public class UserDto {
    private String name;
    private Integer age;
}
