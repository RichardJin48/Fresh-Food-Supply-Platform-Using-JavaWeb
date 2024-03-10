package com.cdut.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Product {
    private Long productId;

    private String productName;

    private Long categoryId;

    private BigDecimal price;

    private Byte publishStatus;

    private Date productionDate;

    private String descript;

    private String recommend;

    private Float weight;

    private Integer stock;

    private Integer salesVolume;

    private Timestamp indate;

    private Timestamp modifiedTime;

    private String pic;

    public Product(Long productId, String productName, Long categoryId, BigDecimal price, Byte publishStatus, Date productionDate, String descript, String recommend, Float weight, Integer stock, Integer salesVolume, Timestamp indate, Timestamp modifiedTime, String pic) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.price = price;
        this.publishStatus = publishStatus;
        this.productionDate = productionDate;
        this.descript = descript;
        this.recommend = recommend;
        this.weight = weight;
        this.stock = stock;
        this.salesVolume = salesVolume;
        this.indate = indate;
        this.modifiedTime = modifiedTime;
        this.pic = pic;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Byte getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Byte publishStatus) {
        this.publishStatus = publishStatus;
    }

    public java.sql.Date getProductionDate() {
        return (java.sql.Date) productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Timestamp getIndate() {
        return indate;
    }

    public void setIndate(Timestamp indate) {
        this.indate = indate;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Product() {

    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", publishStatus=" + publishStatus +
                ", productionDate=" + productionDate +
                ", descript='" + descript + '\'' +
                ", recommend='" + recommend + '\'' +
                ", weight=" + weight +
                ", stock=" + stock +
                ", salesVolume=" + salesVolume +
                ", indate=" + indate +
                ", modifiedTime=" + modifiedTime +
                ", pic='" + pic + '\'' +
                '}';
    }
}
