<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	

<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"> 
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>


 
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="#">MOBILES</a>



</div>
<ul class="nav navbar-nav">
<li class="active"><a href="Welcome">home</a></li> 
<li class="dropdown">
<a class="dropdown-toggle" data-toggle="dropdown" href="#">Brands <span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="#">Sony</a></li>
<li><a href="#">Samsung</a></li>
<li><a href="#">Iphone</a></li>
<li><a href="#">oppo</a></li>	
<li><a href="#">Redmi</a></li>
</ul>     
</li>

<li><a href="viewProducts">Products</a></li>
<li><a href="#">About Us</a></li>

</ul>
<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${empty loggedInUser }">
					<li><a href="registration"><span
							class="glyphicon glyphicon-user"></span>SIGNUP</a></li>
					<li><a href="login"><span
							class="glyphicon glyphicon-login"></span>LOGIN</a></li>
				</c:when>
				<c:when test="${not empty loggedInUser }">
					<li><a href="addtocart">Cart</a></li>
					<li><a href="${loggedInUserId}viewProfile">View Profile</a></li>
					<div class="media" style="float:left;">
					<img src="/mobilesfront/pics/${loggedInUser}.jpg" class="media-object" style="Width:80px"></img>
					</div>
					<li class="navbar-text" style="font-size:100%"> welcome ${loggedInUser}!</li>
					<li><a href="Welcome">Sign Out</a></li>
                   <form class="navbar-form navbar-right">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="search">
							<div class="input-group-btn">
								<button class="btn btn-info" type="submit">
									<i class="glyphicon glyphicon-search"></i>

								</button>

							</div>


						</div>
					</form>
				</c:when>
			</c:choose>
		</ul>
</div>


</nav>
</body>
