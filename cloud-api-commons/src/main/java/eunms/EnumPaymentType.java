package eunms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Auther: zhuweimu
 * @Date: 2020/7/12 13:13
 * @Description:
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum EnumPaymentType {
    PAYPAL(1,"paypal");
    private Integer type;
    private String name;
}
