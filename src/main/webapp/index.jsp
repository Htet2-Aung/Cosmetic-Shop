<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Home Page</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" >
	<link rel="stylesheet" href="css/product.css">
</head>
<body>
	<!-- Responsive navbar-->
	<c:import url="common/navbar.jsp"></c:import>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-4 product-wrap my-5">
                    <div class="product-info">
                        <h4>Facewash</h4>
                        <a href="signin.jsp" class="btn btn-outline-white">Shopping More</a>
                    </div>
                    <img src="COS/facewash.webp" alt="" width="100%" height="300px"> 
                </div>
                <div class="col-md-4 product-wrap my-5">
                    <div class="product-info">
                        <h4>Foundation</h4>
                        <a href="signin.jsp" class="btn btn-outline-white">Shopping More</a>
                    </div>
                    <img src="COS/foundation.webp" alt="" width="100%" height="300px"> 
                </div>
                <div class="col-md-4 product-wrap my-5">
                    <div class="product-info">
                        <h4>Powder</h4>
                        <a href="signin.jsp" class="btn btn-outline-white">Shopping More</a>
                    </div>
                    <img src="COS/face-powders.jpg" alt="" width="100%" height="300px"> 
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 product-wrap  my-3">
                    <div class="product-info">
                        <h4>Eyebrow</h4>
                        <a href="signin.jsp" class="btn btn-outline-white">Shopping More</a>
                    </div>
                    <img src="COS/eyebrow.webp" alt="" width="100%" height="300px"> 
                </div>
                <div class="col-md-4 product-wrap my-3">
                    <div class="product-info">
                        <h4>Lipstick</h4>
                        <a href="signin.jsp" class="btn btn-outline-white">Shopping More</a>
                    </div>
                    <img src="COS/lipstick.jpg" alt="" width="100%" height="300px"> 
                </div>
                <div class="col-md-4 product-wrap my-3">
                    <div class="product-info">
                        <h4>Body Lotion</h4>
                        <a href="signin.jsp" class="btn btn-outline-white">Shopping More</a>
                    </div>
                    <img src="COS/bodylotion1.webp" alt="" width="100%" height="300px"> 
                </div>
            </div>
    </section>
	
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
