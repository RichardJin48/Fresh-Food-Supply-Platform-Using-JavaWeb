<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Supplier Management System</title>
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">
    <link rel="stylesheet" href="../static/font-awesome-local/node_modules/font-awesome/css/font-awesome.min.css">

    <style>
        h3, h5 {
            color: #3f51b5;
        }

        a.btn {
            margin: 5px;
        }

        .btn-primary {
            background-color: #3f51b5;
        }

        .text-center {
            margin-bottom: 30px;
        }

        /* 按钮悬停效果 */
        .btn-primary:hover {
            background-color: #5c6bc0;
        }
    </style>
</head>
<body style="background-color: #f7f7f7;">
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Community Fresh Food Supply Platform Supplier Management System</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/product?opt=list&userCard=${user.idCard}"><i class="fa fa-shopping-cart"></i> Product</a></li>
            <li><a href="/order?opt=list&userCard=${user.idCard}"><i class="fa fa-list"></i> Order</a></li>
            <li><a href="/return?opt=list&userCard=${user.idCard}"><i class="fa fa-undo"></i> Return</a></li>
            <li><a href="/ann?opt=list&userCard=${user.idCard}"><i class="fa fa-bullhorn"></i> Announcement</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/emp?opt=show&userCard=${user.idCard}"><span class="glyphicon glyphicon-user"></span>Welcome!
                User: ${user.empName}</a></li>
            <li><a href="/emp?opt=toLogin"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
        </ul>
    </div>
</nav>

<div style="padding-top: 70px;"></div>


<div class="row">
    <div class="col-sm-6 col-sm-offset-3">
        <h2 class="text-center" style="margin-top: 28px;margin-left: -107px;margin-bottom:30px">Supplier Management
            System</h2>

    </div>
</div>

<div class="row">
    <div class="col-sm-6 col-sm-offset-4" style="margin-bottom:30px">
        <a href="/product?opt=list&userCard=${user.idCard}" class="btn btn-primary col-sm-3"><i
                class="fa fa-shopping-cart"></i> Product</a>
        <a href="/order?opt=list&userCard=${user.idCard}" class="btn btn-primary col-sm-3 col-sm-offset-2"><i
                class="fa fa-list"></i> Order</a>
    </div>
    <div class="col-sm-6 col-sm-offset-4" style="margin-bottom:30px">
        <a href="/return?opt=list&userCard=${user.idCard}" class="btn btn-primary col-sm-3"><i
                class="fa fa-undo"></i> Return</a>
        <a href="/ann?opt=list&userCard=${user.idCard}" class="btn btn-primary col-sm-3 col-sm-offset-2"><i
                class="fa fa-bullhorn"></i> Announcement</a>
    </div>
</div>


</div>
</body>
</html>