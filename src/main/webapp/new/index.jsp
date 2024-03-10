<%@ page language="java"  contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="../static/css/base.css">
    <link rel="stylesheet" href="../static/css/common.css">
    <link rel="stylesheet" href="../static/css/index.css">
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
    <div class= 'announce' style="float: left; margin: 10px 0 0 160px; border: 1px solid black; width: 550px; text-align: center; padding: 10px 0; box-shadow: 1px 1px 1px; position: relative">
        <p style="position: absolute; right: 10px; top: 1px; cursor: pointer" class="close">x</p>
        <p style="font-size: 24px;">${ann.title}</p>
        <p>${ann.content}</p>
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
    <!-- banner -->
    <div class="banner">
        <div class="wrapper">
            <!-- banner aside -->
            <div class="aside">
                <ul>
                    <li><a href="/product?opt=category&userName=${user.username}&category=1">Fresh Fruit</a></li>
                    <li><a href="/product?opt=category&userName=${user.username}&category=2">Seafood & Aquatic</a></li>
                    <li><a href="/product?opt=category&userName=${user.username}&category=3">Selected Meats</a></li>
                    <li><a href="/product?opt=category&userName=${user.username}&category=4">Frozen Food</a></li>
                    <li><a href="/product?opt=category&userName=${user.username}&category=5">Vegetables & Eggs</a></li>
                </ul>
            </div>
            <!-- banner imge -->
            <div class="bcg">
                <a href="/product?opt=category&userName=${user.username}&category=1">
                    <img src="../static/images/banner1.jpg" alt="">
                </a>
            </div>

            <!-- Turn page button-->
            <button class="prev"></button>
            <button class="next"></button>

            <!-- Turn page dots -->
            <ol class="indicator">
                <li class="active"></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ol>
        </div>

    </div>
    <div class="recommend">
        <div class="wrapper">
            <div class="hd">
                <h2>Recommended Foods</h2>
            </div>
            <div class="bd clearfix">
                <ul>
                    <c:forEach items="${p1}" var="product">
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
        <div class="wrapper">
            <div class="hd">
                <h2>All Foods</h2>
            </div>
            <div class="bd clearfix">
                <ul>
                    <c:forEach items="${p2}" var="product">
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

    <div class="elevator">
        <ul class="elevator-list">
            <li><a href="javascript:;" id="backTop"><i class="sprites"></i>Top</a></li>
        </ul>
    </div>

    <script>
        const a = document.querySelector('.banner .bcg a')
        const img = document.querySelector('.banner .bcg img')
        const next = document.querySelector('.next');
        const prev = document.querySelector('.prev');
        let i = 1;
        next.addEventListener('click', function () {
            i++;
            if (i > 5) {
                i = 1;
            }
            console.log(i)
            a.href = `/product?opt=category&userName=${user.username}&category=`+i
            img.src = `../static/images/banner`+i+`.jpg`;
            toggle();
        })

        prev.addEventListener('click', function () {
            i--;
            if (i === 0) {
                i = 5
            }
            console.log(i)
            a.href = `/product?opt=category&userName=${user.username}&category=`+i
            img.src = `../static/images/banner`+i+`.jpg`;
            toggle();
        })

        function toggle() {
            document.querySelector('.indicator .active').classList.remove('active');
            document.querySelector(`.indicator li:nth-child(`+i+`)`).classList.add('active');
        }

        let timeId = setInterval(function () {
            next.click();
        }, 1000)

        const bcg = document.querySelector('.banner .bcg');

        bcg.addEventListener('mouseenter', function () {
            clearInterval(timeId);
        })

        bcg.addEventListener('mouseleave', function () {
            clearInterval(timeId);

            timeId = setInterval(function () {
                next.click();
            }, 3000)
        })

        const close = document.querySelector(".close")
        const announce = document.querySelector(".announce")
        close.addEventListener('click', function () {
            announce.style.display = 'none'
        })
            // elevator:display
            // (function () {
            //     const elevator = document.querySelector('.elevator');
            //     const banner = document.querySelector('.banner')
            //     window.addEventListener('scroll', function () {
            //         const n = document.documentElement.scrollTop;
            //         if (n >= banner.offsetTop) {
            //             elevator.style.opacity = 1;
            //         }
            //         else {
            //             elevator.style.opacity = 0;
            //         }
            //     })
            //
            //     const backTop = document.querySelector('#backTop')
            //     backTop.addEventListener('click', function () {
            //         document.documentElement.scrollTop = 0;
            //     })
            // })();
    </script>

</body>

</html>