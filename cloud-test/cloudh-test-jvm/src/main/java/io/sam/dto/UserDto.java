package io.sam.dto;

import lombok.Data;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/6 14:28
 */
@Data
public class UserDto {
    private char c;
    private String name;
    private Integer age;
    private SonDto sonDto;
}
