<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Confirmation Page</title>
    <!--引入bootstrap核心样式-->
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">

</head>
<body>
    <div class="col-sm-6 col-sm-offset-3">
        <h1 class="text-center" style="margin-top:70px">${inf}</h1>
    </div>
    <div class="col-sm-6 col-sm-offset-5" style="line-height:10">
        <a href="${url1}" class="btn btn-warning btn-sm-12">No</a>
        <a href="${url2}" class="btn btn-success btn-sm-12 col-sm-offset-1">Yes</a>
    </div>
</body>
</html>
