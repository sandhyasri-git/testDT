<%@include file="Header.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="çol-sm-6">
				<div class="thumbnail">
					<img src="/mobilesfront/pics/${product.prodname}.jpg"
						alt="product name">

				</div>

			</div>
			<div class="col-sm-6">
				<table class="table table-responsive">
					<tr>
						<td>product name</td>
						<td>${product.prodname}</td>
					</tr>
					<tr>
						<td>product name</td>
						<td>${product.price}</td>
					</tr>
					<tr>
						<td>product name</td>
						<td>${product.quantity}</td>
					</tr>
					<tr>
						<td><a href="cart"><input type="submit"
								value="addtocart" /></a></td>
					</tr>


				</table>


			</div>

		</div>

	</div>
	<div class="col-sm-3"></div>

</div>
<%@include file="Footer.jsp"%>