<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order Management</title>
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">
    <script language="javascript">
        function confReceive() {
            if (!confirm("Receive this product?")) {
                window.event.returnValue = false;
            }
        }
        function confCancel() {
            if (!confirm("Cancel this order?")) {
                window.event.returnValue = false;
            }
        }
        function confReturn() {
            if (!confirm("Return this product?")) {
                window.event.returnValue = false;
            }
        }
        function confRebuy() {
            if (!confirm("Rebuy this product?")) {
                window.event.returnValue = false;
            }
        }
    </script>
</head>
<body>
<div class="col-sm-6 col-sm-offset-3">
    <h3 style="color:#00a5fe" class="text-center">Community Fresh Food Supply Platform</h3>
</div>
<div class="col-sm-6 col-sm-offset-9">
    <h5 class="col-sm-offset-1">Welcome! User: ${user.nickname}</h5>
    <a href="/cus?opt=show&userName=${user.username}" class="btn btn-info btn-sm col-sm-offset-1">Personal Information</a>
    <a href="/cus?opt=toLogin" class="btn btn-warning btn-sm">Log Out</a>
</div>
<div class="col-sm-6 col-sm-offset-1">
    <a href="/cus?opt=main&userName=${user.username}" class="btn btn-success btn-sm col-sm-offset-1">Back</a>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h3>Order Management</h3>
            <h3 class="text-center" style="color:orange;margin-top:30px;margin-bottom:10px">In Progress</h3>
            <table class="table table-striped table-bordered">
                <tr>
                    <th>Order Sn</th>
                    <th>Product</th>
                    <th>Product Image</th>
                    <th>Consignee Name</th>
                    <th>Phone Number</th>
                    <th>Delivery Address</th>
                    <th>Order Price</th>
                    <th>Product Amount</th>
                    <th>Create Time</th>
                    <th>Shipping Time</th>
                    <th>Receive Time</th>
                    <th>
                    </th>
                </tr>
<%--                用jstl标签进行数据的遍历--%>
                <c:forEach items="${orders}" var="order">
                    <c:if test="${order.orderStatus=='1'}">
                    <tr>
                        <td>${order.orderSn}</td>
                        <td>${order.product}</td>
                        <td>
                            <img src="${order.pic}" alt="" width="70" height="70">
                        </td>
                        <td>${order.shippingUser}</td>
                        <td>${order.phone}</td>
                        <td>${order.address}</td>
                        <td>${order.orderMoney}</td>
                        <td>${order.productAmount}</td>
                        <td>${order.createTime}</td>
                        <td>${order.shippingTime}</td>
                        <td>${order.receiveTime}</td>
                        <td>
                            <a href="/order?opt=toEdit2&orderId=${order.orderId}&userName=${user.username}" class="btn btn-info btn-sm">Edit</a>
                            <a href="/order?opt=receive&orderId=${order.orderId}&userName=${user.username}" class="btn btn-warning btn-sm" onClick="confReceive()">Receive</a>
                            <a href="/order?opt=cancel&orderId=${order.orderId}&userName=${user.username}" class="btn btn-danger btn-sm" onClick="confCancel()">Cancel</a>
                        </td>
                    </tr>
                    </c:if>
                </c:forEach>

            </table>
        </div>
        <div class="col-md-12">
            <h3 class="text-center" style="color:green;margin-top:30px;margin-bottom:10px">Completed</h3>
            <table class="table table-striped table-bordered">
                <tr>
                    <th>Order Sn</th>
                    <th>Product</th>
                    <th>Product Image</th>
                    <th>Consignee Name</th>
                    <th>Phone Number</th>
                    <th>Delivery Address</th>
                    <th>Order Price</th>
                    <th>Product Amount</th>
                    <th>Create Time</th>
                    <th>Shipping Time</th>
                    <th>Receive Time</th>
                    <th>
                    </th>
                </tr>
                <%--                用jstl标签进行数据的遍历--%>
                <c:forEach items="${orders}" var="order">
                    <c:if test="${order.orderStatus=='2'}">
                    <tr>
                        <td>${order.orderSn}</td>
                        <td>${order.product}</td>
                        <td>
                            <img src="${order.pic}" alt="" width="70" height="70">
                        </td>
                        <td>${order.shippingUser}</td>
                        <td>${order.phone}</td>
                        <td>${order.address}</td>
                        <td>${order.orderMoney}</td>
                        <td>${order.productAmount}</td>
                        <td>${order.createTime}</td>
                        <td>${order.shippingTime}</td>
                        <td>${order.receiveTime}</td>
                        <td>
                            <a href="/order?opt=toBuy2&productId=${order.productId}&userName=${user.username}" class="btn btn-info btn-sm">Rebuy</a>
                            <a href="/return?opt=addOrder2&orderId=${order.orderId}&userName=${user.username}" class="btn btn-warning btn-sm" onClick="confReturn()">Return</a>
                            <a href="/order?opt=toDelete2&orderId=${order.orderId}&userName=${user.username}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                    </c:if>
                </c:forEach>

            </table>
        </div>
        <div class="col-md-12">
            <h3 class="text-center" style="color:red;margin-top:30px;margin-bottom:10px">Canceled</h3>
            <table class="table table-striped table-bordered">
                <tr>
                    <th>Order Sn</th>
                    <th>Product</th>
                    <th>Product Image</th>
                    <th>Consignee Name</th>
                    <th>Phone Number</th>
                    <th>Delivery Address</th>
                    <th>Order Price</th>
                    <th>Product Amount</th>
                    <th>Create Time</th>
                    <th>Shipping Time</th>
                    <th>Receive Time</th>
                    <th>
                    </th>
                </tr>
                <%--                用jstl标签进行数据的遍历--%>
                <c:forEach items="${orders}" var="order">
                    <c:if test="${order.orderStatus=='0'}">
                    <tr>
                        <td>${order.orderSn}</td>
                        <td>${order.product}</td>
                        <td>
                            <img src="${order.pic}" alt="" width="70" height="70">
                        </td>
                        <td>${order.shippingUser}</td>
                        <td>${order.phone}</td>
                        <td>${order.address}</td>
                        <td>${order.orderMoney}</td>
                        <td>${order.productAmount}</td>
                        <td>${order.createTime}</td>
                        <td>${order.shippingTime}</td>
                        <td>${order.receiveTime}</td>
                        <td>
                            <a href="/order?opt=rebuy&orderId=${order.orderId}&userName=${user.username}" class="btn btn-info btn-sm" onClick="confRebuy()">Rebuy</a>
                            <a href="/order?opt=toDelete2&orderId=${order.orderId}&userName=${user.username}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                    </c:if>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
</body>
</html>
