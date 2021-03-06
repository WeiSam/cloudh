package model;

import eunms.EnumPaymentType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: zhuweimu
 * @Date: 2020/3/28 11:13
 * @Description:
 */
@Data
@Builder
public class Payment implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 流水号
     */
    private String serial;

    /**
     * 类型 {@link EnumPaymentType}
     */
    EnumPaymentType type;

}