<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Personal Information</title>
    <!--引入bootstrap核心样式-->
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">
    <link rel="stylesheet" href="../static/font-awesome-local/node_modules/font-awesome/css/font-awesome.min.css">
    <style>
        h3, h5 {
            color: #3f51b5;
        }

        a.btn {
            margin: 5px;
        }


        .text-center {
            margin-bottom: 30px;
        }



        .table th, .table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        .table th {
            background-color: #f7f7f7;
            font-weight: bold;
        }

        .table tbody tr:nth-child(odd) {
            background-color: #f2f2f2;
        }

        .table tbody tr:hover {
            background-color: #e0e0e0;
        }

        .table > tbody > tr > td {
            vertical-align: middle;
        }

    </style>
</head>
<body style="background-color: #f7f7f7;">
<div class="container">
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
            <h2 class="text-center" style="margin-top:40px;margin-bottom:20px">Personal Information</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 col-sm-offset-5">
            <h4 style="margin-top:30px">Name: ${user.empName}</h4>
            <h4 style="margin-top:30px">ID: ${user.idCard}</h4>
            <h4 style="margin-top:30px">Department: ${user.dept}</h4>
            <h4 style="margin-top:30px">Gender: ${user.gender}</h4>
            <h4 style="margin-top:30px">Age: ${user.age}</h4>
            <h4 style="margin-top:30px">Phone: ${user.phone}</h4>
        </div>
    </div>
</div>
</body>
</html>
