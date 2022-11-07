<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:import url="common/header.html"></c:import>
<title>Add To Cart</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/product.css">
</head>
<body>
	<!-- Responsive navbar-->
	<c:import url="common/navbar.jsp"></c:import>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<form action="add" method="post">
						<h2 class="text-center">Add To Cart Form</h2>
						<h3>ID: ${cosmeticCart.productId}</h3>
						<input type="hidden" name="mode" value="ADD">
						<div class="container">
							<div class="row">
								<div class="col-md-6">
									<label for="brand" class="form-label">Brand</label> <input
										type="text" id="brand" name="brand" readonly="readonly" value="${cosmeticCart.brand }"
										class="form-control">
								</div>

								<div class="col-md-6">
									<label for="type" class="form-label">Type</label> <input
										type="text" id="type" name="type" readonly="readonly" value="${cosmeticCart.type }"
										class="form-control">
								</div>
							</div>
							<div class="row" >
								<div class="col-md-6">
									<label for="price" class="form-label">Price</label> 
									<input type="number" id="order_price" name="price" readonly="readonly"
										value="${cosmeticCart.price }" class="form-control">
								</div>

								<div class="col-md-6">
									<label for="quantity" class="form-label">Quantity</label>
									 <input type="number" name="quantity" id="qty" min=0 max="${cosmeticCart.quantity }" class="form-control" required="required" autofocus="autofocus">
								</div>
							</div>
							<div class="col-md-6 mb-3">
								<label for="quantity" class="form-label">Total</label> <input
									type="number" name="total" id="total" class="form-control">
							</div>
							<div class="">
								<button type="submit" class="btn btn-primary" id="add_item">Add
									To Cart</button>
								<button type="reset" class="btn btn-danger">Reset</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</section>
	<section class="login-footer"></section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>