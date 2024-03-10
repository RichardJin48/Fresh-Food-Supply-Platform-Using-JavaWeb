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
    <link rel="stylesheet" href="../static/css/userbd_common.css">
    <link rel="stylesheet" href="../static/css/shoppingCart.css">
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

    <div class="userbd">
        <div class="wrapper">

            <!-- main content -->
            <div class="main">
                <h4>Shopping Cart</h4>
                <div class="content">
                    <ul>
                        <li>
                            <div class="goods common">
                                <p>Product</p>
                            </div>
                            <div class="number common">
                                <p>Number </p>
                            </div>
                            <div class="price common">
                                <p>Total Price </p>
                            </div>
                            <div class="time common">
                                <p>Addition Time </p>
                            </div>
                            <div class="action common">
                                <a href="/order?opt=toBuy&userName=${user.username}">Purchase All</a>
                            </div>
                        </li>

                        <c:forEach items="${shoppingCarts}" var="shoppingCart">
                        <li>
                            <div class="goods common">
                                <div class="pic">
                                    <a href="/product?opt=show&productId=${shoppingCart.productId}&userName=${user.username}"><img src="${shoppingCart.pic}" alt="" style="width: 107px;height: 107px;"></a>
                                </div>
                                <div class="txt">
                                    <h5>${shoppingCart.product}</h5>
                                </div>
                            </div>
                            <div class="number common">${shoppingCart.productAmount}</div>
                            <div class="price common">
                                <b>£</b>
                                <span>${shoppingCart.price}</span>
                            </div>
                            <div class="time common">${shoppingCart.addTime}</div>
                            <div class="action common">
                                <a href="/order?opt=toBuy3&cartId=${shoppingCart.cartId}&userName=${user.username}">Purchase</a>
                                <a href="/shoppingCart?opt=toDelete2&cartId=${shoppingCart.cartId}&userName=${user.username}">Delete</a>
                            </div>
                        </li>
                        </c:forEach>
                    </ul>
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

    <script>

    </script>

</body>

</html>