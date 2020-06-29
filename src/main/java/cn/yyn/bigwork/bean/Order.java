package cn.yyn.bigwork.bean;

import java.util.Date;

/**
 * @author 杨以诺
 * by 2020-06-27 21:10
 */
public class Order {
    private Integer orderId;        //账单id
    private Integer commodityId;    //商品id
    private Commodity commodity;    //商品对象
    private Integer commodityNumber;//商品数量
    private Date createTime;        //订单创建时间
    private Integer createUserId;   //订单创建用户id
    private UserInfo createUser;    //创建用户对象
    private Date updateTime;        //订单修改时间
    private Integer updateUserId;   //订单修改用户id
    private UserInfo updateUser;    //修改用户对象

    public Order() {
    }

    public Order(Integer orderId, Integer commodityId, Commodity commodity, Integer commodityNumber, Date createTime, Integer createUserId, UserInfo createUser, Date updateTime, Integer updateUserId, UserInfo updateUser) {
        this.orderId = orderId;
        this.commodityId = commodityId;
        this.commodity = commodity;
        this.commodityNumber = commodityNumber;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", commodityId=" + commodityId +
                ", commodity=" + commodity +
                ", commodityNumber=" + commodityNumber +
                ", createTime=" + createTime +
                ", createUserId=" + createUserId +
                ", createUser=" + createUser +
                ", updateTime=" + updateTime +
                ", updateUserId=" + updateUserId +
                ", updateUser=" + updateUser +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Integer getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(Integer commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public UserInfo getCreateUser() {
        return createUser;
    }

    public void setCreateUser(UserInfo createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public UserInfo getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(UserInfo updateUser) {
        this.updateUser = updateUser;
    }
}
