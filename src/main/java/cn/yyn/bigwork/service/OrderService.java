package cn.yyn.bigwork.service;

import cn.yyn.bigwork.bean.Order;

import java.util.List;

/**
 * @author 杨以诺
 * by 2020-06-28 12:35
 */
public interface OrderService {
    List<Order> findAllOrder(Integer page, Integer size);

    List<Order> findAllOrder();

    Order findOrderById(Integer orderId);

    Integer addOrder(Order order);

    Integer updOrder(Order order);

    Integer delOrder(Integer orderId);
}
