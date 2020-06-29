package cn.yyn.bigwork.bean;

import java.util.Date;

/**
 * @author 杨以诺
 * by 2020-06-27 21:05
 */
public class Commodity {
    private Integer commodityId;    //商品id
    private String commodityName;   //商品名称
    private Double price;           //商品价格
    private Date createTime;        //商品生产日期
    private Integer supplierId;     //供应商id
    private Supplier supplier;      //供应商对象

    public Commodity() {
    }

    public Commodity(Integer commodityId, String commodityName, Double price, Date createTime, Integer supplierId, Supplier supplier) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.price = price;
        this.createTime = createTime;
        this.supplierId = supplierId;
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", supplierId=" + supplierId +
                ", supplier=" + supplier +
                '}';
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
