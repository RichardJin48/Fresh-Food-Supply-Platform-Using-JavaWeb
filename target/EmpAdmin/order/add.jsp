<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add an Order</title>
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" action="${url1}" method="post">
                <h3>${title}</h3>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Customer ID</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="customerId" placeholder="Customer ID">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Product ID</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="productId" placeholder="Product ID">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Consignee Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="shippingUser" placeholder="Consignee Name">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Phone Number</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="phone" placeholder="Phone Number">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Delivery Address</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="address" placeholder="Delivery Address">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Order Price</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="orderMoney" placeholder="Order Price">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Product Amount</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="productAmount" placeholder="Product Amount">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Shipping Time</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="shippingTime" placeholder="Shipping Time (yyyy-mm-dd)">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Receive Time</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="receiveTime" placeholder="Receive Time (yyyy-mm-dd)">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Order Status</label>
                    <div class="col-sm-10">
                        <div class="form-control">
                            <input type="radio" name="orderStatus" value="1" checked> In Progress
                            <input type="radio" name="orderStatus" value="2"> Completed
                            <input type="radio" name="orderStatus" value="0"> Canceled
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-12" style="text-align: center">
                        <a href="${url2}" class="btn btn-warning btn-sm-12">Cancel</a>
                        <input type="submit" value="Submit" class="btn btn-success">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
