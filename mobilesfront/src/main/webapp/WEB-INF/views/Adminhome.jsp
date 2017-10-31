<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>

</head>

<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="#">Websitename</a>


</div>
<ul class="nav navbar-nav">
<li class="active"><a href="Welcome">home</a></li> 
<li class="dropdown">
<a class="dropdown-toggle" data-toggle="dropdown" href="#">products <span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="AddProduct">addproducts</a></li>
<li><a href="#">view</a></li>

</ul>     
</li>
<li class="dropdown">
<a class="dropdown-toggle" data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="AddCategory">add category</a></li>
<li><a href="#">view</a></li>

</ul>     
</li><li class="dropdown">
<a class="dropdown-toggle" data-toggle="dropdown" href="#">Supplier <span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="AddSupplier">add supplier</a></li>
<li><a href="#">view</a></li>

</ul>     
</li>
<ul class="nav navbar-nav navbar-right">
<li><a href="Welcome"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>

</ul>
</ul>
</div>
</nav>
</body>
</html>