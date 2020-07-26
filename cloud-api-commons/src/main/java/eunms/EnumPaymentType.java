package eunms;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: zhuweimu
 * @Date: 2020/7/12 13:13
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum EnumPaymentType {

    /**
     * 支付类型枚举
     */
    PAYPAL(1,"paypal");

    private Integer type;
    private String name;
}
