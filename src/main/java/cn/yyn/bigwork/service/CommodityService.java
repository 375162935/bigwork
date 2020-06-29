package cn.yyn.bigwork.service;

import cn.yyn.bigwork.bean.Commodity;

import java.util.List;

/**
 * @author 杨以诺
 * by 2020-06-28 12:34
 */
public interface CommodityService {
    List<Commodity> findAllCommodity(Integer page, Integer size);

    List<Commodity> findAllCommodity();

    Commodity findCommodityById(Integer commodityId);

    Integer addCommodity(Commodity commodity);

    Integer updCommodity(Commodity commodity);

    Integer delCommodity(Integer commodityId);
}
