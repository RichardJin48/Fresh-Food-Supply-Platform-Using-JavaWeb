<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Account Editing</title>
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" action="${url1}" method="post">
                <h3>${title}</h3>
                <input type="hidden" name="customerId" value="${cus.customerId}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Username</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="username" placeholder="Username" value="${cus.username}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password" placeholder="Password (Leave blank if you don't want to change)">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Nickname</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="nickname" placeholder="Nickname" value="${cus.nickname}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Gender</label>
                    <div class="col-sm-10">
                        <div class="form-control">
                            <input type="radio" name="gender" value="Male" ${male}> Male
                            <input type="radio" name="gender" value="Female" ${female}> Female
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Phone Number</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="phone" placeholder="Phone Number" value="${cus.phone}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Delivery Address</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="addr" placeholder="Delivery Address" value="${cus.addr}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Personal Signature</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" name="sign" rows="10">${cus.sign}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-12" style="text-align: center">
                        <a href="${url2}" class="btn btn-warning btn-sm-12">Cancel</a>
                        <input type="submit" value="Submit" class="btn btn-success">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
