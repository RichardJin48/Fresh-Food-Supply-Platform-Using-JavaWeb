<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Information</title>
    <!--引入bootstrap核心样式-->
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <h2 class="text-center" style="margin-top:40px;margin-bottom:20px">Product Information</h2>
        </div>
    </div>
    <div class="col-sm-6 col-sm-offset-1">
        <a href="/cus?opt=main&userName=${user.username}" class="btn btn-success btn-sm col-sm-offset-1">Back</a>
    </div>
    <div class="row">
        <div class="col-sm-6 col-sm-offset-4">
            <h4 style="margin-top:30px">Product Name: ${product.productName}</h4>
            <h4 style="margin-top:30px">Price: ${product.price}</h4>
            <h4 style="margin-top:30px">Weight (g): ${product.weight}</h4>
            <h4 style="margin-top:30px">Date of Manufacture: ${product.productionDate}</h4>
            <h4 style="margin-top:30px">Description: ${product.descript}</h4>
            <h4 style="margin-top:30px">Inventory: ${product.stock}</h4>
            <h4 style="margin-top:30px">Sales Volume: ${product.salesVolume}</h4>
        </div>
        <div class="col-sm-6 col-sm-offset-4" style="line-height:8">
            <a href="/col?opt=addBeh2&productId=${product.productId}&userName=${user.username}" class="btn btn-warning btn-sm-12">Favorite</a>
            <a href="/shoppingCart?opt=toAdd2&productId=${product.productId}&userName=${user.username}" class="btn btn-info btn-sm-12 col-sm-offset-1">Add to Cart</a>
            <a href="/order?opt=toBuy2&productId=${product.productId}&userName=${user.username}" class="btn btn-danger btn-sm-12 col-sm-offset-1">Purchase Now</a>
        </div>
    </div>
</div>
</body>
</html>
