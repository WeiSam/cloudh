package io.sam.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import model.Payment;

import java.util.Date;
import java.util.List;

/**
 * @author zhuweimu
 * @Classname UserDto
 * @Description
 * @date 2020/9/4 19:46
 */
@Data
@Accessors(chain = true)
@ToString
public class UserDto {
    public static String KEY = "key_";
    public static String TT = KEY+"dhsjdhjs";
    private String name;
    private Integer age = 0;
    private Date birth;
//    private byte [] bb = new byte[1024];
    private List<Payment> payments;
    YanTaiBaseResp yanTaiBaseResp = new YanTaiBaseResp();
}
