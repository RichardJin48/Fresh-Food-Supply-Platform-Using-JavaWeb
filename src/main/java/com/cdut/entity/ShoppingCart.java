package com.cdut.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ShoppingCart {
    private Long cartId;

    private Integer customerId;

    private Long productId;

    private Integer productAmount;

    private BigDecimal price;

    private Timestamp addTime;

    private Timestamp modifiedTime;

    private String product;

    private String pic;

    public ShoppingCart(Long cartId, Integer customerId, Long productId, Integer productAmount, BigDecimal price, Timestamp addTime, Timestamp modifiedTime) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.productId = productId;
        this.productAmount = productAmount;
        this.price = price;
        this.addTime = addTime;
        this.modifiedTime = modifiedTime;
    }

    public ShoppingCart(Long cartId, Integer customerId, Long productId, Integer productAmount, BigDecimal price, Timestamp addTime, Timestamp modifiedTime, String product, String pic) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.productId = productId;
        this.productAmount = productAmount;
        this.price = price;
        this.addTime = addTime;
        this.modifiedTime = modifiedTime;
        this.product = product;
        this.pic = pic;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
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

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
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
        return "ShoppingCart{" +
                "cartId=" + cartId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", productAmount=" + productAmount +
                ", price=" + price +
                ", addTime=" + addTime +
                ", modifiedTime=" + modifiedTime +
                ", product='" + product + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
