package cn.yyn.bigwork.controller;

import cn.yyn.bigwork.bean.Commodity;
import cn.yyn.bigwork.bean.Order;
import cn.yyn.bigwork.service.CommodityService;
import cn.yyn.bigwork.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
        ModelAndView mv=new ModelAndView();
        List<Order> orderList =orderService.findAllOrder(page,size);
        PageInfo<Order> pageInfo=new PageInfo<>(orderList);
        System.out.println(orderList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("emp/order/order_table");
        return mv;
    }

    @RequestMapping("/order_add_pages")
    public ModelAndView order_add_pages(){
        ModelAndView mv=new ModelAndView();
        List<Commodity> commodityList=commodityService.findAllCommodity();
        System.out.println(commodityList);
        mv.addObject("commodityList",commodityList);
        mv.setViewName("emp/order/order-add");
        return mv;
    }
}
