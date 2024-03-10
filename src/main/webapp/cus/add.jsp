<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Account Registration</title>
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" action="${url1}" method="post">
                <h3>${title}</h3>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Username</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="username" placeholder="Username (Required)">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password" placeholder="Password (Password should be 8-16 digits and contain numbers, lowercase and uppercase letters)">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Nickname</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="nickname" placeholder="Nickname">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Gender</label>
                    <div class="col-sm-10">
                        <div class="form-control">
                            <input type="radio" name="gender" value="Male"> Male
                            <input type="radio" name="gender" value="Female"> Female
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Phone Number</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="phone" placeholder="Phone Number"">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Delivery Address</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="addr" placeholder="Delivery Address">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Personal Signature</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" name="sign" rows="10"></textarea>
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
