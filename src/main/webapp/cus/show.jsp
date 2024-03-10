<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Personal Information</title>
    <!--引入bootstrap核心样式-->
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <h2 class="text-center" style="margin-top:40px;margin-bottom:20px">Personal Information</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 col-sm-offset-5">
            <h4 style="margin-top:30px">Username: ${user.username}</h4>
            <h4 style="margin-top:30px">Nickname: ${user.nickname}</h4>
            <h4 style="margin-top:30px">Gender: ${user.gender}</h4>
            <h4 style="margin-top:30px">Phone Number: ${user.phone}</h4>
            <h4 style="margin-top:30px">Delivery Address: ${user.addr}</h4>
            <h4 style="margin-top:30px">Personal Signature: ${user.sign}</h4>
        </div>
        <div class="col-sm-6 col-sm-offset-5" style="line-height:8">
            <a href="/cus?opt=main&userName=${user.username}" class="btn btn-warning btn-sm-12">Back</a>
            <a href="/cus?opt=toEdit&customerId=${user.customerId}&userName=${user.username}&mode=2" class="btn btn-info btn-sm-12 col-sm-offset-1">Edit</a>
        </div>
    </div>
</div>
</body>
</html>
