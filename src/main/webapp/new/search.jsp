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
    <link rel="stylesheet" href="../static/css/search.css">
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
                <input type="text" name="keyword" placeholder="Please enter the product name" value="${keyword}"/><button type="submit">Search</button>
                <span></span>
            </div>
        </form>
    </div>

    <div class="search">
        <div class="wrapper">
            <div class="hd">
                <h2>Search Result</h2>
            </div>

            <div class="bd clearfix">
                <ul>
                    <c:forEach items="${p}" var="product">
                        <li style="margin-bottom: 10px">
                            <a href="/product?opt=show&productId=${product.productId}&userName=${user.username}">
                                <img src="${product.pic}" alt="">
                                <h3>${product.productName}</h3>
                                <b>£</b>
                                <span>${product.price}</span>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
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