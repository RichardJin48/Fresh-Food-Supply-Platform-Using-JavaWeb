<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Personal Center</title>
    <!--引入bootstrap核心样式-->
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
    <div class="col-sm-6 col-sm-offset-3">
        <h2 class="text-center" style="margin-top:30px;margin-bottom:30px">Personal Center</h2>
    </div>
    <div class="col-sm-6 col-sm-offset-4" style="margin-bottom:30px">
        <a href="/cus?opt=show&userName=${user.username}" class="btn btn-primary col-sm-3">Personal Information</a>
        <a href="/shoppingCart?opt=list2&userName=${user.username}" class="btn btn-primary col-sm-3 col-sm-offset-2">Shopping Cart</a>
    </div>
    <div class="col-sm-6 col-sm-offset-4" style="margin-bottom:30px">
        <a href="/order?opt=list2&userName=${user.username}" class="btn btn-primary col-sm-3">Order</a>
        <a href="/return?opt=list2&userName=${user.username}" class="btn btn-primary col-sm-3 col-sm-offset-2">Return</a>
    </div>
    <div class="col-sm-6 col-sm-offset-4" style="margin-bottom:30px">
        <a href="/col?opt=list2&userName=${user.username}" class="btn btn-primary col-sm-3">Favorites</a>
        <a href="/cus?opt=main&userName=${user.username}" class="btn btn-danger col-sm-3 col-sm-offset-2">Back to Marketplace</a>
    </div>
</body>
</html>
