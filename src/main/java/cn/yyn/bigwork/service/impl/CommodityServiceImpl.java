package cn.yyn.bigwork.service.impl;

import cn.yyn.bigwork.bean.Commodity;
import cn.yyn.bigwork.dao.CommodityDao;
import cn.yyn.bigwork.service.CommodityService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨以诺
 * by 2020-06-28 12:36
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;

    @Override
    public List<Commodity> findAllCommodity(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return commodityDao.findAllCommodity();
    }

    @Override
    public List<Commodity> findAllCommodity() {
        return commodityDao.findAllCommodity();
    }

    @Override
    public Commodity findCommodityById(Integer commodityId) {
        return commodityDao.findCommodityById(commodityId);
    }

    @Override
    public Integer addCommodity(Commodity commodity) {
        return commodityDao.addCommodity(commodity);
    }

    @Override
    public Integer updCommodity(Commodity commodity) {
        return commodityDao.updCommodity(commodity);
    }

    @Override
    public Integer delCommodity(Integer commodityId) {
        return commodityDao.delCommodity(commodityId);
    }
}
