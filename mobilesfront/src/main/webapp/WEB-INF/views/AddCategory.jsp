<%@include file="Adminhome.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		<form:form method="POST" action="addcat" commandName="category" >
			<table>
				<tr>
					<td><h2>addCategory</h2></td>
				</tr>
				<c:if test="${!empty category.catname }">
					<tr>
						<td><form:label path="catid">ID</form:label></td>
						<td><form:input path="catid" readonly="true" disabled="true" /> <form:hidden path="catid" /></td>
					</tr>
				</c:if>
				<tr>
					<td><form:label path="catname">Category Name</form:label></td>
					<td><form:input path="catname"></form:input></td>
				</tr>
				
				<!--  select:dropdown, items:collection ,itemValue: name to listen
 -->
				<tr>
 <%-- <td>Category</td>
 <td><form:select path="catid" items="${categoryList}"
 itemValue="catid" itemLabel="catid">
 </form:select></td>
 </tr> --%>
 <%-- <tr>
 <td>Supplier</td>
 <td><form:select path="supplierid" items="${supplieridt}"
 itemValue="suplierid" itemLabel="supplierid">
 </form:select></td>
 </tr> --%>
				
				<tr>
					<c:if test="${empty category.catname}">
						<td style="text-align: center;"><input type="submit"
							value="submit" style="color: green; font-size: 15pt;" /></td>
						<td><input type="reset" value="cancel"
							style="color: red; font-size: 15pt" /></td>
					</c:if>
					<c:if test="${!empty category.catname}">
						<td><input type="submit" value="Edit category" /></td>
					</c:if>
				</tr>
			</table>
		</form:form>
		<h2>Category List</h2>
		<!--    core tags,if or choose,$ expresssion language
 -->
		<c:if test="${!empty categoryList}">
			<table class="tg">
		<tr>
					<th>Category Id</th>
					<th>CategoryName</th>
					
					
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${categoryList }" var="category">
					<tr>
						<td>${category.catid}</td>
						<td>${category.catname}</td>
						<
						<%-- <td>${product.category.cat}</td>
  <td>${product.supplier.supplierid}</td> --%>
						<td><a href="<c:url value='/editcategory${category.catid}'/>">Edit</a></td>
						<td><a
							href="<c:url value='/deletecategory${category.catid}'/>">delete</a></td>
					</tr>
				</c:forEach>

			</table>
		</c:if>
		<a href="Adminhome">Back</a>
</body>
</html>
