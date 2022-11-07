<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" >
<c:import url="common/header.html"></c:import>
<title>Product Added </title>
</head>
<body>
	<!-- Responsive navbar-->
	<c:import url="common/navbar.jsp"></c:import>
	<div class="container">
	    <form action="cosmetic" method="post">
        <h2 class="text-center">Product Update Form</h2>
        
        <input type="hidden" name="mode" value="UPDATE">
        <input type="hidden" name="productId" value="${cosmetic.productId }">
        <h3> <c:out value="ID : ${cosmetic.productId}"></c:out> </h3>
        
        <div class="mb-3">
            <label for="brand" class="form-label">*Brand</label>
            <input type="text" id="brand" name="brand" value="${cosmetic.brand }" placeholder="Enter Brand" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="type" class="form-label">*Type</label>
            <input type="text" id="type" name="type" value="${cosmetic.type }" placeholder="Enter Product Type" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="price" class="form-label">*Price</label>
            <input type="number" id="price" name="price" value="${cosmetic.price }" placeholder="Enter Price" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="quantity" class="form-label">*Quantity</label>
            <input type="number" id="quantity" name="quantity" value="${cosmetic.quantity }" placeholder="Enter Quantity" class="form-control" required="required" autofocus>
        </div>
        <div class="mb-3">
            <div class="col-sm-9 col-sm-offset-3">
                <span class="help-block">*Required fields</span>
            </div>
        </div>
        
        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-danger">Reset</button>
    </form> <!-- /form -->
</div> <!-- ./container -->
	

</body>
</html>