package com.cdut.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;

public class Order {
    private Long orderId;
    private String orderSn;
    private Integer customerId;
    private Long productId;
    private String shippingUser;
    private String phone;
    private String address;
    private BigDecimal orderMoney;
    private Integer productAmount;
    private Timestamp createTime;
    private Timestamp shippingTime;
    private Timestamp receiveTime;
    private Byte orderStatus;
    private String product;
    private String pic;

    public Order(Long orderId, String orderSn, Integer customerId, Long productId, String shippingUser, String phone, String address, BigDecimal orderMoney, Integer productAmount, Timestamp createTime, Timestamp shippingTime, Timestamp receiveTime, Byte orderStatus) {
        this.orderId = orderId;
        this.orderSn = orderSn;
        this.customerId = customerId;
        this.productId = productId;
        this.shippingUser = shippingUser;
        this.phone = phone;
        this.address = address;
        this.orderMoney = orderMoney;
        this.productAmount = productAmount;
        this.createTime = createTime;
        this.shippingTime = shippingTime;
        this.receiveTime = receiveTime;
        this.orderStatus = orderStatus;
    }

    public Order(Long orderId, String orderSn, Integer customerId, Long productId, String shippingUser, String phone, String address, BigDecimal orderMoney, Integer productAmount, Timestamp createTime, Timestamp shippingTime, Timestamp receiveTime, Byte orderStatus, String product, String pic) {
        this.orderId = orderId;
        this.orderSn = orderSn;
        this.customerId = customerId;
        this.productId = productId;
        this.shippingUser = shippingUser;
        this.phone = phone;
        this.address = address;
        this.orderMoney = orderMoney;
        this.productAmount = productAmount;
        this.createTime = createTime;
        this.shippingTime = shippingTime;
        this.receiveTime = receiveTime;
        this.orderStatus = orderStatus;
        this.product = product;
        this.pic = pic;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
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

    public String getShippingUser() {
        return shippingUser;
    }

    public void setShippingUser(String shippingUser) {
        this.shippingUser = shippingUser;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Timestamp shippingTime) {
        this.shippingTime = shippingTime;
    }

    public Timestamp getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Timestamp receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
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
        return "Order{" +
                "orderId=" + orderId +
                ", orderSn='" + orderSn + '\'' +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", shippingUser='" + shippingUser + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", orderMoney=" + orderMoney +
                ", productAmount=" + productAmount +
                ", createTime=" + createTime +
                ", shippingTime=" + shippingTime +
                ", receiveTime=" + receiveTime +
                ", orderStatus=" + orderStatus +
                ", product='" + product + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
