package io.sam.db.domain;

import lombok.Data;

/**
 * @classname AccountTbl
 * @description 
 * @date 2020/10/27 14:32
 * @author zhuweimu
 */
@Data
public class AccountTbl {
    private Integer id;

    private String userId;

    private Integer money;
}