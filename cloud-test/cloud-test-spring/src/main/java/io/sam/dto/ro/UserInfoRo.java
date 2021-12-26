package io.sam.dto.ro;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/21 10:18
 */
@Data
@Accessors(chain = true)
public class UserInfoRo {
    private String nanme;
}
