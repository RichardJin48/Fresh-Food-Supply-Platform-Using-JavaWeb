<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add a Product</title>
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" action="${url1}" method="post">
                <h3>${title}</h3>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Product Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="productName" placeholder="Product Name">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Category ID</label>
                    <div class="col-sm-10">
                        <div class="form-control">
                            <input type="radio" name="categoryId" value="1"> Fresh Fruit
                            <input type="radio" name="categoryId" value="2"> Seafood & Aquatic
                            <input type="radio" name="categoryId" value="3"> Selected Meats
                            <input type="radio" name="categoryId" value="4"> Frozen Food
                            <input type="radio" name="categoryId" value="5"> Vegetables & Eggs
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Price</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="price" placeholder="Price">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Publish Status</label>
                    <div class="col-sm-10">
                        <div class="form-control">
                            <input type="radio" name="publishStatus" value="0" checked> Off The Shelf
                            <input type="radio" name="publishStatus" value="1"> On The Shelf
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Recommended</label>
                    <div class="col-sm-10">
                        <div class="form-control">
                            <input type="radio" name="recommend" value="No" checked> No
                            <input type="radio" name="recommend" value="Yes"> Yes
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Weight (g)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="weight" placeholder="Weight (g)">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Date of Manufacture</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="productionDate" placeholder="Date of Manufacture (yyyy-mm-dd)">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Description</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" name="descript" rows="5"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Inventory</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="stock" placeholder="Inventory">
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
