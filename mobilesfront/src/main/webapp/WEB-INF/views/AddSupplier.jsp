
<%@include file="Adminhome.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		<form:form method="POST" action="addsupplier" commandName="supplier" enctype="multipart/form-data">
			<table>
				<tr>
					<td><h2>addSupplier</h2></td>
				</tr>
				<c:if test="${!empty supplier.brand }">
					<tr>
						<td><form:label path="supplierid">ID</form:label></td>
						<td><form:input path="supplierid" readonly="true" disabled="true" /> <form:hidden path="supplierid" /></td>
					</tr>
				</c:if>
				<tr>
					<td><form:label path="email">Supplier email</form:label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="address">Supplier address</form:label></td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td><form:label path="brand">supplier brand</form:label></td>
					<td><form:input path="brand" /></td>
				</tr>
				<tr>
					<td><form:label path="phone">supplierphone</form:label></td>
					<td><form:input path="phone" /></td>
				</tr>
				
				<!--  select:dropdown, items:collection ,itemValue: name to listen
 -->
				<%-- <tr>
 <td>Category</td>
 <td><form:select path="catid" items="${categoryList}"
 itemValue="catid" itemLabel="catid">
 </form:select></td>
 </tr>
 <tr>
 <td>Supplier</td>
 <td><form:select path="supplierid" items="${supplieridt}"
 itemValue="suplierid" itemLabel="supplierid">
 </form:select></td>
 </tr> --%>
				<%-- <tr>
					<td><form:label path="img">Select Image:</form:label></td>
					<td><form:input type="file" path="img" /></td>
				</tr> --%>
				<tr>
					<c:if test="${empty supplier.brand}">
						<td style="text-align: center;"><input type="submit"
							value="submit" style="color: green; font-size: 15pt;" /></td>
						<td><input type="reset" value="cancel"
							style="color: red; font-size: 15pt" /></td>
					</c:if>
					<c:if test="${!empty supplier.brand}">
						<td><input type="submit" value="Edit supplier" /></td>
					</c:if>
				</tr>
			</table>
		</form:form>
		<h2>Supplier List</h2>
		<!--    core tags,if or choose,$ expresssion language
 -->
		<c:if test="${!empty supplierList}">
			<table class="tg">
		<tr>
					<th>supplier Id</th>
					<th>supplierName</th>
					<th>Address</th>
					<th>email</th>
					<th>phone</th>
					
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${supplierList }" var="supplier">
					<tr>
						<td>${supplier.supplierid}</td>
						<td>${supplier.brand}</td>
						<td>${supplier.address}</td>
						<td>${supplier.email}</td>
						<td>${supplier.phone}</td>
						<%-- <td>${product.category.cat}</td>
  <td>${product.supplier.supplierid}</td> --%>
						<td><a href="<c:url value='/editsupplier${supplier.supplierid}'/>">Edit</a></td>
						<td><a
							href="<c:url value='/deletesupplier${supplier.supplierid}'/>">delete</a></td>
					</tr>
				</c:forEach>

			</table>
		</c:if>
		<a href="Adminhome">Back</a>
</body>
</html>

