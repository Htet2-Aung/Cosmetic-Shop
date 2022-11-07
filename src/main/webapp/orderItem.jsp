<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:import url="common/header.html"></c:import>
<title>Order Item</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/product.css">
</head>
<body>
	<c:import url="common/navbar.jsp"></c:import>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<table id="item" class="table table-striped">
						<thead>
							<tr>
								<th>Order Id</th>
								<th>Brand</th>
								<th>Type</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Total</th>
								<th>Action</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="order" items="${orderList}">

								<c:url var="deleteLink" value="order">
									<c:param name="mode" value="DELETE"></c:param>
									<c:param name="orderId" value="${order.orderId}"></c:param>
								</c:url>

								<tr>
									<td><c:out value="${order.orderId}"></c:out></td>
									<td><c:out value="${order.brand}"></c:out></td>
									<td><c:out value="${order.type}"></c:out></td>
									<td><c:out value="${order.price}"></c:out></td>
									<td><c:out value="${order.quantity }"></c:out></td>
									<td><c:out value="${order.total}"></c:out></td>
									<td><a href="${deleteLink }" id="cancel"
										class="btn btn-danger"
										onclick="return confirm('Are you sure to delete this result?');">Cancel</a>
									</td>


								</tr>
							</c:forEach>
							<tr>
								<td colspan='5'>Total</td>
								<td><c:out value="${netTotal }"></c:out></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-2"></div>
			</div>
			<c:url var="outLink" value="backCosmetic">
				<c:param name="mode" value="OUT"></c:param>
			</c:url>
			  <div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<!--<a href="outLink" id="checkout" class="btn btn-success">Proceed
						To Checkout</a>   -->
					<a href="cosmetic" id="continue" class="btn btn-info">Continue shopping</a>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</section>
	<section class="login-footer"></section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>