package cn.yyn.bigwork.service.impl;

import cn.yyn.bigwork.bean.Order;
import cn.yyn.bigwork.dao.OrderDao;
import cn.yyn.bigwork.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨以诺
 * by 2020-06-28 12:36
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findAllOrder(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return orderDao.findAllOrder();
    }

    @Override
    public List<Order> findAllOrder() {
        return orderDao.findAllOrder();
    }

    @Override
    public Order findOrderById(Integer orderId) {
        return orderDao.findOrderById(orderId);
    }

    @Override
    public Integer addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public Integer updOrder(Order order) {
        return orderDao.updOrder(order);
    }

    @Override
    public Integer delOrder(Integer orderId) {
        return orderDao.delOrder(orderId);
    }
}
