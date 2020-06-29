package cn.yyn.bigwork.service;

import cn.yyn.bigwork.bean.Supplier;

import java.util.List;

/**
 * @author 杨以诺
 * by 2020-06-28 12:35
 */
public interface SupplierService {
    List<Supplier> findAllSupplier(Integer page, Integer size);

    List<Supplier> findAllSupplier();

    Supplier findSupplierById(Integer supplierId);

    Integer addSupplier(Supplier supplier);

    Integer updSupplier(Supplier supplier);

    Integer delSupplier(Integer supplierId);
}
