<%@include file="Header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="perform_login" method="POST" role="form">
			<div class="form-group">
				<label for="username"> Enter mail id </label> <input type="email"
					name="username" required class="form-control"><br> <label
					for="password"> </label>enter password<input type="password"
					name="password" required class="form-control"><br>

				<!-- <input type="submit" value="Register">
<input type="reset" value="danger">
 -->
				<button type="submit" class="btn btn-success">Login</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-danger">Cancel</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			</div>





		</form>
	</div>

	

</body>
</html>