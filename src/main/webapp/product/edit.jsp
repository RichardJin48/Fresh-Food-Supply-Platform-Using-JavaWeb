<%@ page language="java"  contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit the Product</title>
    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">
    <style>
        .custom-file-upload {
            display: inline-block;
            padding: 6px 12px;
            cursor: pointer;
            background-color: #f8f9fa; /* This is a light gray color */
            border: 1px solid #000000; /* This adds a black border */
            border-radius: 4px; /* Optional: This makes the border slightly rounded */
        }

        .custom-file-upload:hover {
            background-color: #e2e6ea; /* Slightly darker gray color on hover */
        }


    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" action="${url1}" method="post" enctype="multipart/form-data">
                <h3>${title}</h3>
                <input type="hidden" name="productId" value="${product.productId}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Product Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="productName" value="${product.productName}" placeholder="Product Name">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Category ID</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="categoryId" value="${product.categoryId}" placeholder="1.Fresh Fruit  2.Seafood & Aquatic  3.Selected Meats  4.Frozen Food  5.Vegetables & Eggs">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Price</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="price" value="${product.price}" placeholder="Price">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Publish Status</label>
                    <div class="col-sm-10">
                        <div class="form-control">
                            <input type="radio" name="publishStatus" value="0" ${off}> Off The Shelf
                            <input type="radio" name="publishStatus" value="1" ${on}> On The Shelf
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Recommended</label>
                    <div class="col-sm-10">
                        <div class="form-control">
                            <input type="radio" name="recommend" value="No" ${no}> No
                            <input type="radio" name="recommend" value="Yes" ${yes}> Yes
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Weight (g)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="weight" value="${product.weight}" placeholder="Weight (g)">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Date of Manufacture</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="productionDate" value="${product.productionDate}" placeholder="Date of Manufacture (yyyy-mm-dd)">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Description</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" name="descript" rows="5">${product.descript}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Inventory</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="stock" value="${product.stock}" placeholder="Inventory">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Product Image</label>
                    <div class="col-sm-10">
                        <label class="custom-file-upload">
                            <input type="file" class="form-control" name="productImage" style="display: none;">
                            Upload File
                        </label>
                    </div>
                </div>



                <input type="hidden" name="salesVolume" value="${product.salesVolume}">
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
