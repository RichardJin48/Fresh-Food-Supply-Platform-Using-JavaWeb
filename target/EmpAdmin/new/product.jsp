<%@ page language="java"  contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../static/css/base.css">
    <link rel="stylesheet" href="../static/css/common.css">
    <link rel="stylesheet" href="../static/css/product.css">
</head>
<body>
<div class="shortcut">
    <div class="wrapper">
        <a href="/cus?opt=main&userName=${user.username}" class="logo">Community Fresh Food Supply Platform</a>
        <ul>
            <li><a href="/order?opt=list2&userName=${user.username}">My Orders</a></li>
            <li><a href="/return?opt=list2&userName=${user.username}">My Returns</a></li>
            <li><a href="/col?opt=list2&userName=${user.username}">My Favorites</a></li>
            <li><a href="/cus?opt=show&userName=${user.username}">Welcome! User: ${user.username}</a></li>
            <li><a href="/cus?opt=toLogin">Log Out</a></li>
        </ul>
    </div>
</div>

    <div class="header wrapper">
        <!-- cart -->
        <a href="/shoppingCart?opt=list2&userName=${user.username}">
            <div class="cart">
<!--                <span>2</span>-->
            </div>
        </a>
        <!-- search bar -->
        <form action="/product?opt=search&userName=${user.username}" method="post">
            <div class="search">
                <input type="text" name="keyword" placeholder="Please enter the product name"/><button type="submit">Search</button>
                <span></span>
            </div>
        </form>
    </div>

    <div class="product">
        <div class="wrapper">
            <div class="pic"><img src="${product.pic}" alt=""></div>
            <div class="content">
                <h5>${product.productName}</h5>
                <div class="dt">Price</div> 
                <div class="dd"><b>£ </b><span>${product.price}</span></div>
                <br>
                <div class="dt">Weight</div> 
                <div class="dd"><span>${product.weight}</span></div>
                <br>
                <div class="dt">Date of Manufacture</div> 
                <div class="dd"><span>${product.productionDate}</span></div>
                <br>
                <div class="dt">Inventory</div> 
                <div class="dd"><span>${product.stock}</span></div>
                <br>
                <div class="dt">Sales Volume:</div> 
                <div class="dd"><span>${product.salesVolume}</span></div>
                <br>
                <div class="dt">Description</div> 
                <div class="dd"><span>${product.descript}</span></div>
                <div class="button">
                    <a href="/order?opt=toBuy2&productId=${product.productId}&userName=${user.username}">Purchase Now</a>
                    <a href="/shoppingCart?opt=toAdd2&productId=${product.productId}&userName=${user.username}">Add to Cart</a>
                    <a href="/col?opt=addBeh2&productId=${product.productId}&userName=${user.username}">Favorite</a>
                </div>
            </div>
        </div>

    </div>

    <div class="footer">
        <div class="wrapper">
            <div class="top">
                <ul>
                    <li>Low Price</li>
                    <li>Fast Delivery</li>
                    <li>Fresh Ingredients</li>
                </ul>
            </div>

        </div>
    </div>
</body>
</html>