<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Feedback Page</title>
    <!--引入bootstrap核心样式-->
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">

</head>
<body>
    <div class="col-sm-6 col-sm-offset-3">
        <h1 class="text-center" style="margin-top:70px">${inf}</h1>
    </div>
    <div class="col-sm-6 col-sm-offset-5" style="line-height:10">
        <a href="${url}" class="btn btn-danger btn-sm-12 col-sm-offset-1">OK</a>
    </div>
</body>
</html>
