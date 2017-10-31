<%@ include file="Header.jsp"%>
<br>
<br>
<br>
<c:choose>
	<c:when test="${!empty mycartList}">
MY CART<br>
		<table class="table table-hover">

			<tr style="background-color: #D8D4D4">
				<th>Product Name</th>
				<!-- <th>Product Description</th> -->
				<th>quantity</th>
				<th>Price</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${mycartList}" var="cart">
				<tr>
					<td>${cart.cartid}</td>
					<%-- <td>${cart.cartproduct.description}</td> --%>
					<td>${cart.qty}</td>
					<td>${cart.grandtotal}</td>
					<td><a href="<c:url value='cartupdate${product.prodid}'/>"><span
							class="glyphicon glyphicon-pencil"></span></a></td>
					<td><a href="<c:url value='deletecart/${cart.cartid}'/>"><span
							class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="checkout">checkout</a>
	</c:when>
	<c:otherwise>
No Products in your Cart
</c:otherwise>
</c:choose>

<%@ include file="Footer.jsp"%>