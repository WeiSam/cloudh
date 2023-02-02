package io.sam.db.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @classname AccountTbl
 * @description 
 * @date 2020/10/27 14:32
 * @author zhuweimu
 */
@Data
@Accessors(chain = true)
public class AccountTbl {
    private Integer id;

    private String userId;

    private Integer money;
}