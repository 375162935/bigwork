package cn.yyn.bigwork.dao;

import cn.yyn.bigwork.bean.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 杨以诺
 * by 2020-06-28 12:35
 */
@Repository
public interface SupplierDao {
    List<Supplier> findAllSupplier();

    Supplier findSupplierById(Integer supplierId);

    Integer addSupplier(Supplier supplier);

    Integer updSupplier(Supplier supplier);

    Integer delSupplier(Integer supplierId);
}
