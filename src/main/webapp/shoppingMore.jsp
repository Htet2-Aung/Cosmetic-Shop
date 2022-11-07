<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:import url="common/header.html"></c:import>
<title>Shopping More</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" >
	<link rel="stylesheet" href="css/product.css">
</head>
<body>
	<!-- Responsive navbar-->
	<c:import url="common/navbar.jsp"></c:import>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <ul class="product-list">
                        <li><input type="radio" name="skincare" id="facewash" class="form-check-input" checked><label for="" class="form-check-label">Facewash</label> </li>
                        <li><input type="radio" name="skincare" id="foundation" class="form-check-input"><label for="" class="form-check-label">Foundation</label> </li>
                        <li><input type="radio" name="skincare" id="powder" class="form-check-input"><label for="" class="form-check-label">Powder</label> </li>
                        <li><input type="radio" name="skincare" id="eyebrow" class="form-check-input"><label for="" class="form-check-label">Eyebrow</label> </li>
                        <li><input type="radio" name="skincare" id="lipstick" class="form-check-input"><label for="" class="form-check-label">Lipstick</label> </li>
                        <li><input type="radio" name="skincare" id="body-lotion" class="form-check-input"><label for="" class="form-check-label">Body Lotion</label> </li>
                    </ul>
                </div>
                <div class="col-md-9">
                   <table id="product" class="table table-striped">
			<thead>
				<tr>
					<th>Product Id</th>
					<th>Brand</th>
					<th>Type</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Action</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cosmetic" items="${cosmeticList}">
					<c:url var="updateLink" value="cosmetic">
						<c:param name="mode" value="LOAD"></c:param>
						<c:param name="productId" value="${cosmetic.productId}"></c:param>
					</c:url>
					
					<c:url var="deleteLink" value="cosmetic">
						<c:param name="mode" value="DELETE"></c:param>
						<c:param name="productId" value="${cosmetic.productId}"></c:param>
					</c:url>
					<c:url var="buyLink" value="add">
						<c:param name="mode" value="BUY"></c:param>
						<c:param name="productId" value="${cosmetic.productId}"></c:param>
					</c:url>
					
					<tr>
						<td> <c:out value="${cosmetic.productId}"></c:out> </td>
						<td> <c:out value="${cosmetic.brand}"></c:out> </td>
						<td> <c:out value="${cosmetic.type}"></c:out> </td>
						<td> <c:out value="${cosmetic.price}"></c:out> </td>
						<td id="shopping_qty"> <c:out value="${cosmetic.quantity }"></c:out> </td>
						
						
						
					
						<c:choose>
							<c:when test="${fn:contains(user.role,'admin') }">
								<td> 
								<a href="${updateLink }" class="btn btn-primary">Edit</a>
								<a href="${deleteLink }" id="delete" class="btn btn-danger" onclick="return confirm('Are you sure to delete this result?');">Delete</a>
								</td>
							</c:when>
							<c:otherwise>
								<td> 
								<a href="${buyLink }" class="btn btn-primary" id="buy">Buy</a>
								</td> 
							</c:otherwise>
						</c:choose>
						
					
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>Product Id</th>
					<th>Brand</th>
					<th>Type</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Action</th>
					
				</tr>
			</tfoot>
		</table>
                </div>
            </div>
        </div>
      
    </section>
    <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>