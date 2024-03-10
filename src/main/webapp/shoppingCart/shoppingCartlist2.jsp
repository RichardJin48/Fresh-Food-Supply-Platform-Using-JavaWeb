<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopping Cart Management</title>
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">
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
            <h3>Shopping Cart Management</h3>
            <table class="table table-striped table-bordered">
                <tr>
                    <th>Product</th>
                    <th>Number of Products</th>
                    <th>Total Price</th>
                    <th>Addition Time</th>
                    <th>
                        <a href="/order?opt=toBuy&userName=${user.username}" class="btn btn-primary btn-sm">Purchase</a>
                    </th>
                </tr>
                <%--                用jstl标签进行数据的遍历--%>
                <c:forEach items="${shoppingCarts}" var="shoppingCart">
                    <tr>
                        <td>${shoppingCart.product}</td>
                        <td>${shoppingCart.productAmount}</td>
                        <td>${shoppingCart.price}</td>
                        <td>${shoppingCart.addTime}</td>
                        <td>
                            <a href="/shoppingCart?opt=toDelete2&cartId=${shoppingCart.cartId}&userName=${user.username}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>
    </div>
</div>
</body>
</html>
