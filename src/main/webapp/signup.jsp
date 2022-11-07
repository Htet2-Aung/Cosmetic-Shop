<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:import url="common/header.html"></c:import>
<title>Register</title>


</head>
<body>
	<!-- Responsive navbar-->
	<c:import url="common/navbar.jsp"></c:import>
	
		<div class="container">
			<form action="user" method="post">
				<h2 class="mb-3 text-center">User Registration</h2>

				<input type="hidden" name="mode" value="SIGNUP">

				<div class="mb-3">
					<label for="username" class="form-label">*Username</label> <input
						type="text" id="username" name="username"
						placeholder="Enter Your Name" class="form-control"
						required="required" autofocus>
				</div>

				<div class="mb-3">
					<label for="email" class="form-label">*Email</label> <input
						type="email" id="email" name="email"
						placeholder="Enter Your Email" class="form-control"
						required="required" autofocus>
				</div>

				<div class="mb-3">
					<label for="password" class="form-label">*Password</label> <input
						type="password" id="password" name="password"
						placeholder="Enter Your Password" class="form-control"
						required="required" autofocus>
				</div>

				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="role"
						name="role" value="true"> <label class="form-check-label"
						for="role">Admin</label>
				</div>

				<div class="mb-3">
					<div class="col-sm-9 col-sm-offset-3">
						<span class="help-block">*Required fields</span>
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
				<button type="reset" class="btn btn-danger">Reset</button>
			</form>
			<!-- /form -->
			<p>
				Already has an account ? <a href="signin.jsp">Please Sign in</a>
			</p>
		</div>
		<!-- ./container -->


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>