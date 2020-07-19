package common;

import dto.vo.PaymentVo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BaseResponse01<T> implements Serializable {


    /**
     * 返回数据
     */
    T data;
    /**
     * 测试数据
     */
    PaymentVo paymentVo;

}
