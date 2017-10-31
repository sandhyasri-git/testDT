<%@include file="Header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- <body bgColor="blue"> -->
<!-- <div class="container">
<form action="mainpage" method="post" role="form">
<div class="form group">
<label for="txtname">enter user name</label> <input type="text" name="txtuser"required class="form-control">
<label for="txtemail">enter user email</label> <input type="text" name="txemail"required class="form-control">
<label for="txphone">enter user phonr number</label> <input type="text" name="txtphone"required class="form-control">
<label for="txtpass">enter user password</label> <input type="text" name="txtpass"required class="form-control">
<label for="txtfirstname">enter user firstname</label> <input type="text" name="txtfirstname"required class="form-control">
<label for="txtlastname">enter user lastname</label> <input type="text" name="txtlastname"required class="form-control">

<button type="button" class="btn btn-success">Register</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" class="btn btn-danger">cancel</button><br>
<a href="Mail">Mail</a>



</div>




</form>
</div>
 -->
 
					<h2 align="center" style="color:green" > Register here</h2>
					<hr>
					
					
				
 <form:form method="POST" action="addus" commandName="user" enctype="multipart/form-data">
			<table align="center">
			
			
				
				<%--<tr>
					<td><form:label path="userid">user id</form:label></td>
					<td><form:input path="userid" readonly="true" disable="true"/><form:hidden path="userid"/></td> 
				</tr> --%>
				
					<td><form:label path="username">user name</form:label></td>
					<td><form:input path="username"/></td>
				</tr>
					<tr>
						<td><form:label path="firstname">first name</form:label></td>
						<td><form:input path="firstname" /></td>
					</tr>
				
				<tr>
					<td><form:label path="lastname">last Name</form:label></td>
					<td><form:input path="lastname" /></td>
				</tr>
				
				<tr>
					<td><form:label path="password">password</form:label></td>
					<td><form:input path="password" type="password" /></td>
					
				</tr>
				<tr>
					<td><form:label path="cpassword">confirm password</form:label></td>
					<td><form:input path="cpassword" type="password" /></td>
				</tr>
				<tr>
					<td><form:label path="phone">phone</form:label></td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td><form:label path="emailid">emailid</form:label></td>
					<td><form:input path="emailid" /></td>
				</tr>
				
				<tr>
				<td><form:label path="img"> select image:</form:label></td>
				<td><form:input type="file" path="img"></form:input> </td>
				
				</tr>
				<tr>
					<td style="text-align: center;"><input type="submit"
					value="submit" style="color: green; font-size: 15pt;" /></td>
				<td><input type="reset" value="cancel"
							style="color: red; font-size: 15pt" /></td>
					
				</tr>
			</table>
		</form:form>
	
 </body>

</html>