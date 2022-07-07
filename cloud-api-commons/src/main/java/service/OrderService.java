package service;

import model.OrderInfo;

/**
 * @author zhuweimu
 * @classname OrderService
 * @description
 * @date 2020/11/25 9:49
 */
public interface OrderService {

    OrderInfo getOrder(Long seconds);
}
