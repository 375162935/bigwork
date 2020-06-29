package cn.yyn.bigwork.controller;

import cn.yyn.bigwork.bean.Supplier;
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
 * by 2020-06-28 10:58
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    //供应商表
    @RequestMapping("/supplier_table")
    public ModelAndView supplier_table(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "6") Integer size) {
        ModelAndView mv = new ModelAndView();
        List<Supplier> supplierList = supplierService.findAllSupplier(page, size);
        PageInfo<Supplier> pageInfo = new PageInfo<>(supplierList);
        System.out.println(supplierList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("emp/supplier/supplier_table");
        return mv;
    }

    //供应商添加
    @RequestMapping("/supplier_add")
    public String supplier_add(String supplierName,
                               String supplierAddress,
                               String supplierCountry,
                               String supplierCEO) {
        Supplier supplier = new Supplier();
        supplier.setSupplierName(supplierName);
        supplier.setSupplierAddress(supplierAddress);
        supplier.setSupplierCountry(supplierCountry);
        supplier.setSupplierCEO(supplierCEO);
        supplier.setCreateTime(new Date());
        Integer i = supplierService.addSupplier(supplier);
        if (i > 0) {
            System.out.println("添加成功");
            return "redirect:/supplier/supplier_table";
        } else {
            System.out.println("添加失败");
            return "emp/supplier/supplier_add";
        }
    }

    @RequestMapping("/supplier_upd_pages")
    public ModelAndView supplier_upd_pages(Integer supplierId) {
        Supplier supplier = supplierService.findSupplierById(supplierId);
        System.out.println(supplier);
        ModelAndView mv = new ModelAndView();
        mv.addObject("supplier", supplier);
        mv.setViewName("emp/supplier/supplier_update");
        return mv;
    }

    @RequestMapping("/supplier_upd")
    public String supplier_upd(Integer supplierId,
                               String supplierName,
                               String supplierAddress,
                               String supplierCountry,
                               String supplierCEO) {
        Supplier supplier = supplierService.findSupplierById(supplierId);
        boolean flag = false;
        if (!supplierName.equals(supplier.getSupplierName())) {
            supplier.setSupplierName(supplierName);
            flag = true;
        }
        if (!supplierAddress.equals(supplier.getSupplierAddress())) {
            supplier.setSupplierAddress(supplierAddress);
            flag = true;
        }
        if (!supplierCountry.equals(supplier.getSupplierCountry())) {
            supplier.setSupplierCountry(supplierCountry);
            flag = true;
        }
        if (!supplierCEO.equals(supplier.getSupplierCEO())) {
            supplier.setSupplierCEO(supplierCEO);
            flag = true;
        }
        if (flag) {
            Integer i = supplierService.updSupplier(supplier);
            if (i > 0) {
                System.out.println("修改成功");
                return "redirect:/supplier/supplier_table";
            } else {
                System.out.println("修改失败");
                return "redirect:/supplier/supplier_upd_pages?supplierId=" + supplierId;
            }
        } else {
            System.out.println("未修改数据");
            return "redirect:/supplier/supplier_upd_pages?supplierId=" + supplierId;
        }
    }

    @RequestMapping("/supplier_del")
    public String supplier_del(Integer supplierId) {
        Integer i = supplierService.delSupplier(supplierId);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        return "redirect:/supplier/supplier_table";
    }
}
