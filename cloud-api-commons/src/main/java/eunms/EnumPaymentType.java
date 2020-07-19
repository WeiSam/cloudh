package eunms;

import lombok.Getter;

/**
 * @Auther: zhuweimu
 * @Date: 2020/7/12 13:13
 * @Description:
 */
@Getter
public enum EnumPaymentType {
    PAYPAL(1,"paypal");
    private Integer type;
    private String name;

    EnumPaymentType(Integer type, String name) {
        this.type = type;
        this.name = name;
    }
}
