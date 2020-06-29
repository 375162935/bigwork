package cn.yyn.bigwork.bean;

import java.util.Date;

/**
 * @author 杨以诺
 * by 2020-06-27 21:02
 */
public class Supplier {
    private Integer supplierId;         //供应商id
    private String supplierName;        //供应商名称
    private String supplierAddress;     //供应商地址
    private String supplierCountry;     //供应商国家
    private String supplierCEO;         //供应商老板
    private Date createTime;            //供应商创建时间

    public Supplier() {
    }

    public Supplier(Integer supplierId, String supplierName, String supplierAddress, String supplierCountry, String supplierCEO, Date createTime) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierCountry = supplierCountry;
        this.supplierCEO = supplierCEO;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", supplierCountry='" + supplierCountry + '\'' +
                ", supplierCEO='" + supplierCEO + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierCountry() {
        return supplierCountry;
    }

    public void setSupplierCountry(String supplierCountry) {
        this.supplierCountry = supplierCountry;
    }

    public String getSupplierCEO() {
        return supplierCEO;
    }

    public void setSupplierCEO(String supplierCEO) {
        this.supplierCEO = supplierCEO;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
