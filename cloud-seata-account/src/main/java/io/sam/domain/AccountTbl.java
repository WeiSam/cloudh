package io.sam.domain;

import lombok.Data;

@Data
public class AccountTbl {
    private Integer id;

    private String userId;

    private Integer money;
}