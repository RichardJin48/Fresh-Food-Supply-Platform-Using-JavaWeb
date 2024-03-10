<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Favorites Management</title>
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
            <h3>Favorites Management</h3>
            <table class="table table-striped table-bordered">
                <tr>
                    <th>Favorite Product</th>
                    <th>Product Image</th>
                    <th>Collect Time</th>
                </tr>
<%--                用jstl标签进行数据的遍历--%>
                <c:forEach items="${behs}" var="beh">
                    <tr>
                        <td>${beh.product}</td>
                        <td>
                            <img src="${beh.pic}" alt="" width="70" height="70">
                        </td>
                        <td>${beh.behTime}</td>
                        <td>
                            <a href="/product?opt=show&productId=${beh.productId}&userName=${user.username}" class="btn btn-info btn-sm">Information</a>
                            <a href="/col?opt=toDelete2&behId=${beh.behId}&userName=${user.username}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>
    </div>
</div>
</body>
</html>
