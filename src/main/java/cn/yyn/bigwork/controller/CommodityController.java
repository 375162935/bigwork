package cn.yyn.bigwork.controller;

import cn.yyn.bigwork.bean.Commodity;
import cn.yyn.bigwork.bean.Supplier;
import cn.yyn.bigwork.service.CommodityService;
import cn.yyn.bigwork.service.SupplierService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @author 杨以诺
 * by 2020-06-28 10:56
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private SupplierService supplierService;

    //商品表
    @RequestMapping("/commodity_table")
    public ModelAndView commodity_table(@RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "6") Integer size) {
        ModelAndView mv = new ModelAndView();
        List<Commodity> commodityList = commodityService.findAllCommodity(page, size);
        PageInfo<Commodity> pageInfo = new PageInfo<>(commodityList);
        System.out.println(commodityList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("emp/commodity/commodity_table");
        return mv;
    }

    //供应商添加页面
    @RequestMapping("/commodity_add_pages")
    public ModelAndView commodity_add_pages() {
        List<Supplier> supplierList = supplierService.findAllSupplier();
        System.out.println(supplierList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("supplierList", supplierList);
        mv.setViewName("emp/commodity/commodity_add");
        return mv;
    }

    //供应商添加
    @RequestMapping("/commodity_add")
    public String commodity_add(String commodityName,
                                Double price,
                                Date createTime,
                                Integer supplierId) {
        Commodity commodity = new Commodity();
        commodity.setCommodityName(commodityName);
        commodity.setPrice(price);
        commodity.setCreateTime(createTime);
        commodity.setSupplierId(supplierId);
        Integer i = commodityService.addCommodity(commodity);
        if (i > 0) {
            System.out.println("添加成功");
            return "redirect:/commodity/commodity_table";
        } else {
            System.out.println("添加失败");
            return "redirect:/commodity/commodity_add_pages";
        }
    }

    //商品编辑页
    @RequestMapping("/commodity_upd_pages")
    public ModelAndView commodity_upd_pages(Integer commodityId) {
        Commodity commodity= commodityService.findCommodityById(commodityId);
        List<Supplier> supplierList = supplierService.findAllSupplier();
        ModelAndView mv = new ModelAndView();
        mv.addObject("commodity", commodity);
        mv.addObject("supplierList", supplierList);
        mv.setViewName("emp/commodity/commodity_update");
        return mv;
    }

    //修改商品信息
    @RequestMapping("/commodity_upd")
    public String commodity_upd(Integer commodityId,
                               String commodityName,
                               Double price,
                               Date createTime,
                               Integer supplierId) {
        Commodity commodity = commodityService.findCommodityById(commodityId);
        boolean flag = false;
        if (!commodityName.equals(commodity.getCommodityName())) {
            commodity.setCommodityName(commodityName);
            flag = true;
        }
        if (!price.equals(commodity.getPrice())) {
            commodity.setPrice(price);
            flag = true;
        }
        if (!supplierId.equals(commodity.getSupplierId())) {
            commodity.setSupplierId(supplierId);
            flag = true;
        }
        if (flag) {
            Integer i = commodityService.updCommodity(commodity);
            if (i > 0) {
                System.out.println("修改成功");
                return "redirect:/commodity/commodity_table";
            } else {
                System.out.println("修改失败");
                return "redirect:/commodity/commodity_upd_pages?commodityId=" + commodityId;
            }
        } else {
            System.out.println("未修改数据");
            return "redirect:/commodity/commodity_upd_pages?commodityId=" + commodityId;
        }
    }

    @RequestMapping("/commodity_del")
    public String commodity_del(Integer commodityId) {
        Integer i = commodityService.delCommodity(commodityId);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        return "redirect:/commodity/commodity_table";
    }
}
