package cn.yyn.bigwork.dao;

import cn.yyn.bigwork.bean.Commodity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 杨以诺
 * by 2020-06-28 12:34
 */
@Repository
public interface CommodityDao {
    List<Commodity> findAllCommodity();

    Commodity findCommodityById(Integer commodityId);

    Integer addCommodity(Commodity commodity);

    Integer updCommodity(Commodity commodity);

    Integer delCommodity(Integer commodityId);
}
