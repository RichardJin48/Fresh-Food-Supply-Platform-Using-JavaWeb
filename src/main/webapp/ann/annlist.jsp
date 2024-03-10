<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Announcement Management</title>
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">--%>
    <link rel="stylesheet" href="../static/font-awesome-local/node_modules/font-awesome/css/font-awesome.min.css">
</head>
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

    .btn-primary:hover {
        background-color: #5c6bc0;
    }

    .table {
        background-color: white;
        box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
        border-collapse: separate;
        border-spacing: 0;
        width: 100%;
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
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h3 class="text-center">Announcement Management</h3>
            <h3 class="text-center" style="color:orange;margin-top:30px;margin-bottom:10px">In Progress</h3>
            <table class="table table-striped table-bordered">
                <tr>
                    <th>Title</th>
                    <th>Content</th>
                    <th>Last Edit Time</th>
                    <th>
<%--                        <a href="/ann?opt=toAdd&userCard=${user.idCard}" class="btn btn-primary btn-sm">Add</a>--%>
                    </th>
                </tr>
                <%--                用jstl标签进行数据的遍历--%>
                <c:forEach items="${anns}" var="ann">
                    <tr>
                        <td>${ann.title}</td>
                        <td>${ann.content}</td>
                        <td>${ann.modifiedTime}</td>
                        <td>
                            <a href="/ann?opt=toEdit&annId=${ann.annId}&userCard=${user.idCard}" class="btn btn-info btn-sm">Edit</a>
<%--                            <a href="/ann?opt=toDelete&annId=${ann.annId}&userCard=${user.idCard}" class="btn btn-danger btn-sm">Delete</a>--%>
                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>
    </div>
</div>
</body>
</html>