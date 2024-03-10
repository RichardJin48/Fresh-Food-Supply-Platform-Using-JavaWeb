package com.cdut.entity;

import java.sql.Timestamp;

//该类同时兼顾Beh、Col、Rec三个模块的功能，依靠behType依次区分
public class Beh {
    private Integer behId;
    private Integer customerId;
    private Long productId;
    private Integer behCount;
    private Timestamp behTime;
    private Integer behType;
    private String product;
    private String pic;

    public Beh(Integer behId, Integer customerId, Long productId, Integer behCount, Timestamp behTime, Integer behType) {
        this.behId = behId;
        this.customerId = customerId;
        this.productId = productId;
        this.behCount = behCount;
        this.behTime = behTime;
        this.behType = behType;
    }

    public Beh(Integer behId, Integer customerId, Long productId, Integer behCount, Timestamp behTime, Integer behType, String product, String pic) {
        this.behId = behId;
        this.customerId = customerId;
        this.productId = productId;
        this.behCount = behCount;
        this.behTime = behTime;
        this.behType = behType;
        this.product = product;
        this.pic = pic;
    }

    public Integer getBehId() {
        return behId;
    }

    public void setBehId(Integer behId) {
        this.behId = behId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getBehCount() {
        return behCount;
    }

    public void setBehCount(Integer behCount) {
        this.behCount = behCount;
    }

    public Timestamp getBehTime() {
        return behTime;
    }

    public void setBehTime(Timestamp behTime) {
        this.behTime = behTime;
    }

    public Integer getBehType() {
        return behType;
    }

    public void setBehType(Integer behType) {
        this.behType = behType;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Beh{" +
                "behId=" + behId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", behCount=" + behCount +
                ", behTime=" + behTime +
                ", behType=" + behType +
                ", product='" + product + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
