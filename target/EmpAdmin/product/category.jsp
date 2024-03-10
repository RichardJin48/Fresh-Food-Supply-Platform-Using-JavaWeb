<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Category Products</title>
    <!--引入bootstrap核心样式-->
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">

</head>
<body>
    <div class="col-sm-6 col-sm-offset-3">
        <h3 style="color:#00a5fe" class="text-center">Community Fresh Food Supply Platform</h3>
    </div>
    <div class="col-sm-6 col-sm-offset-9">
        <h5 class="col-sm-offset-1">Welcome! User: ${user.nickname}</h5>
        <a href="/cus?opt=index&userName=${user.username}" class="btn btn-info btn-sm col-sm-offset-1">Personal Center</a>
        <a href="/cus?opt=toLogin" class="btn btn-warning btn-sm">Log Out</a>
    </div>
    <div class="col-sm-6 col-sm-offset-1">
        <a href="/cus?opt=main&userName=${user.username}" class="btn btn-info btn-sm col-sm-offset-1">Back to Home</a>
    </div>
    <div class="col-sm-6 col-sm-offset-3">
        <form class="form-horizontal" action="/product?opt=search&userName=${user.username}" method="post">
            <input type="text" class="form-control" name="keyword" placeholder="Please enter the product name" value="${keyword}">
            <input type="submit" value="Search" class="btn btn-success">
        </form>
    </div>
    <div class="col-sm-6 col-sm-offset-3">
        <h3 class="text-center" style="color:green;margin-top:30px;margin-bottom:10px">${cateName}</h3>
        <table class="table table-striped table-bordered">
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>Weight (g)</th>
                <th>Date of Manufacture</th>
                <th>Description</th>
                <th>Inventory</th>
                <th>Sales Volume</th>
                <th>
                </th>
            </tr>
            <%--                用jstl标签进行数据的遍历--%>
            <c:forEach items="${p}" var="product">
                <tr>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.weight}</td>
                    <td>${product.productionDate}</td>
                    <td>${product.descript}</td>
                    <td>${product.stock}</td>
                    <td>${product.salesVolume}</td>
                    <td>
                        <a href="/col?opt=addBeh4&productId=${product.productId}&userName=${user.username}&category=${category}" class="btn btn-info btn-sm">Favorite</a>
                        <a href="/shoppingCart?opt=toAdd2&productId=${product.productId}&userName=${user.username}" class="btn btn-warning btn-sm">Add to Cart</a>
                        <a href="/order?opt=toBuy2&productId=${product.productId}&userName=${user.username}" class="btn btn-danger btn-sm">Purchase Now</a>
                    </td>
                </tr>

            </c:forEach>

        </table>
        <h4 class="text-center" style="color:red;margin-top:30px;margin-bottom:10px">${noResult}</h4>
    </div>
</body>
</html>
