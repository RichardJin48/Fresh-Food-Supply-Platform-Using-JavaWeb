<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit the Return Order</title>
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" action="${url1}" method="post">
                <h3>${title}</h3>
                <input type="hidden" name="orderId" value="${order.orderId}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Return Order Sn</label>
                    <div class="col-sm-10">
                        <h5>${order.orderSn}</h5>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Consignor Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="shippingUser" placeholder="Consignor Name" value="${order.shippingUser}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Phone Number</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="phone" placeholder="Phone Number" value="${order.phone}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Delivery Address</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="address" placeholder="Address" value="${order.address}">
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
