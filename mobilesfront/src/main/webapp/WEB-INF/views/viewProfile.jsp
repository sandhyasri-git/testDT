<%@include file="Header.jsp"%>




<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="çol-sm-6">
				<div class="thumbnail">
					<img src="/mobilesfront/pics/${loggedInUser}.jpg" alt="user image">
						

				</div>

			</div>
			<div class="col-sm-6">
				<table class="table table-responsive">
					<tr>
						<td>user name</td>
						<td>${user.username}</td>
					</tr>
					<tr>
						<td>first name</td>
						<td>${user.firstname}</td>
					</tr>
					<tr>
						<td>last name</td>
						<td>${user.lastname}</td>
					</tr>
					<tr>
						<td>Email id</td>
						<td>${user.emailid}</td>
					</tr>
					<tr>
						<td>phone</td>
						<td>${user.phone}</td>
					</tr>
					
					<tr>
						<td><a href="addtocart"><input type="submit"
								value="addtocart" /></a></td>
					</tr>


				</table>


			</div>

		</div>

	</div>
	<div class="col-sm-3"></div>

</div>
<%@include file="Footer.jsp"%>