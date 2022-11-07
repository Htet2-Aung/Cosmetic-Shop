<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
	<div class='row'>
	<div class='col-md-4'></div>
	<div class='col-md-4'>
		 <form action="login" method="post">
        <h2 class="mb-3 text-center">Please Sign in</h2>
        
        <input type="hidden" name="mode" value="SIGNIN">
        
        <c:if test="${loginFail }">
        <div class="mb-3">
        <span class="alert alert-danger"> Username or password is incorrect</span>
        </div>
        </c:if>
        
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" id="email" name="email" placeholder="Enter Your Email" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter Your Password" class="form-control" required="required" autofocus>
        </div>
        
        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-danger">Reset</button>
    </form> <!-- /form -->
     <p> Don't have an account? <a href="signup.jsp">Please Sign up</a> </p>
</div>
	</div>
	<div class='col-md-4'></div>
	</div>
	</section>

    <!-- ./container -->
	
	<section class="login-footer"></section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>