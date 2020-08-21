package io.sam.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderTbl {
    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;
}