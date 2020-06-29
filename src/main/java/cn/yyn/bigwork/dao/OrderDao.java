package cn.yyn.bigwork.dao;

import cn.yyn.bigwork.bean.Order;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 杨以诺
 * by 2020-06-28 12:35
 */
@Repository
public interface OrderDao {
    List<Order> findAllOrder();

    Order findOrderById(Integer orderId);

    Integer addOrder(Order order);

    Integer updOrder(Order order);

    Integer delOrder(Integer orderId);
}
