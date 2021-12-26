package io.sam.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhuweimu
 * @classname OderType
 * @description
 * @date 2021/1/28 15:52
 */
@Getter
@AllArgsConstructor
public enum OderType {
    ONE("1","1");
    private String code;
    private String value;
}
