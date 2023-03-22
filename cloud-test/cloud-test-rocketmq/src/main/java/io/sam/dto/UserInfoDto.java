package io.sam.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhuweimu
 * @description
 * @date 2022/8/2 9:17
 */
@Data
@Builder
public class UserInfoDto implements Serializable {
    private static final long serialVersionUID = -8081193147959577877L;

    private Integer id;
    private String name;
    private String password;
    private Integer age;
}
