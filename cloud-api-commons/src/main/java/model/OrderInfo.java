package model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhuweimu
 * @description
 * @date 2022/1/19 15:05
 */
@Data
@Builder
public class OrderInfo implements Serializable {
    private Long id;
    private String name;
}
