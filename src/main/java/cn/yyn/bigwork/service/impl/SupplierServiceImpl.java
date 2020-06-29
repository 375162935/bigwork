package cn.yyn.bigwork.service.impl;

import cn.yyn.bigwork.bean.Supplier;
import cn.yyn.bigwork.dao.SupplierDao;
import cn.yyn.bigwork.service.SupplierService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨以诺
 * by 2020-06-28 12:36
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;

    @Override
    public List<Supplier> findAllSupplier(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return supplierDao.findAllSupplier();
    }

    @Override
    public List<Supplier> findAllSupplier() {
        return supplierDao.findAllSupplier();
    }

    @Override
    public Supplier findSupplierById(Integer supplierId) {
        return supplierDao.findSupplierById(supplierId);
    }

    @Override
    public Integer addSupplier(Supplier supplier) {
        return supplierDao.addSupplier(supplier);
    }

    @Override
    public Integer updSupplier(Supplier supplier) {
        return supplierDao.updSupplier(supplier);
    }

    @Override
    public Integer delSupplier(Integer supplierId) {
        return supplierDao.delSupplier(supplierId);
    }
}
