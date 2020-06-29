package cn.yyn.bigwork.controller;

import cn.yyn.bigwork.bean.Commodity;
import cn.yyn.bigwork.bean.Order;
import cn.yyn.bigwork.bean.UserInfo;
import cn.yyn.bigwork.service.CommodityService;
import cn.yyn.bigwork.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author 杨以诺
 * by 2020-06-28 10:52
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CommodityService commodityService;

    //订单表
    @RequestMapping("/order_table")
    public ModelAndView order_table(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "6") Integer size) {
        ModelAndView mv = new ModelAndView();
        List<Order> orderList = orderService.findAllOrder(page, size);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        System.out.println(orderList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("emp/order/order_table");
        return mv;
    }

    //订单添加页
    @RequestMapping("/order_add_pages")
    public ModelAndView order_add_pages() {
        ModelAndView mv = new ModelAndView();
        List<Commodity> commodityList = commodityService.findAllCommodity();
        System.out.println(commodityList);
        mv.addObject("commodityList", commodityList);
        mv.setViewName("order_add");
        return mv;
    }

    //账单添加
    @RequestMapping("/order_add")
    public String order_add(Integer commodityId,
                            Integer commodityNumber,
                            HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        Order order = new Order();
        order.setCommodityId(commodityId);
        order.setCommodityNumber(commodityNumber);
        order.setCreateUserId(userInfo.getUserId());
        order.setCreateTime(new Date());
        order.setUpdateUserId(userInfo.getUserId());
        order.setUpdateTime(new Date());
        System.out.println(order);
        Integer i = orderService.addOrder(order);
        if (i > 0) {
            System.out.println("添加成功");
            return "redirect:/order/order_table";
        } else {
            System.out.println("添加失败");
            return "redirect:/order/order_add_pages";
        }
    }

    //账单修改页
    @RequestMapping("/order_upd_pages")
    public ModelAndView order_upd_pages(Integer orderId) {
        List<Commodity> commodityList = commodityService.findAllCommodity();
        Order order = orderService.findOrderById(orderId);
        System.out.println(commodityList);
        System.out.println(order);
        ModelAndView mv = new ModelAndView();
        mv.addObject("commodityList", commodityList);
        mv.addObject("order", order);
        mv.setViewName("emp/order/order_update");
        return mv;
    }

    //账单修改
    @RequestMapping("/order_upd")
    public String order_upd(Integer orderId,
                            Integer commodityId,
                            Integer commodityNumber,
                            HttpSession session) {
        Order order = orderService.findOrderById(orderId);
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        boolean flag = false;
        if (!order.getCommodityId().equals(commodityId)) {
            order.setCommodityId(commodityId);
            flag = true;
        }
        if (!order.getCommodityNumber().equals(commodityNumber)) {
            order.setCommodityNumber(commodityNumber);
            flag = true;
        }
        if (flag) {
            order.setUpdateTime(new Date());
            order.setUpdateUserId(userInfo.getUserId());
            Integer i = orderService.updOrder(order);
            if (i > 0) {
                System.out.println("修改成功");
                return "redirect:/order/order_table";
            } else {
                System.out.println("修改失败");
                return "redirect:/order/order_upd_pages?orderId=" + orderId;
            }
        } else {
            System.out.println("未修改");
            return "redirect:/order/order_upd_pages?orderId=" + orderId;
        }
    }

    //删除订单
    @RequestMapping("/order_del")
    public String order_del(Integer orderId) {
        Integer i = orderService.delOrder(orderId);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        return "redirect:/order/order_table";
    }
}
