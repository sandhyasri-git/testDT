<%@include file="Header.jsp" %>
<style>
.carousel-inner > .item > img,
.carousel-inner > .item > a > img {
margin:auto;

}
</style>

<body>
	<div class="container">
		<h2>Mobiles...@@...</h2>
		<div id="mycarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#mycarousel" data-slide-to="0" class="active"></li>
				<li data-target="#mycarousel" data-slide-to="1"></li>
				<li data-target="#mycarousel" data-slide-to="2"></li>
				<li data-target="#mycarousel" data-slide-to="3"></li>
			</ol>
			<div class="carousel-inner" role="listbox" style="width:100%; height:300px !important;"> 
			
				<div class="item active">
					<img src="images/11.jpg" alt="xperia l" style="width: 40%"; style="hight: 300px";>
					<div class="carousel-caption">
						<h3>xperia l</h3>
					</div>
				</div>
				<div class="item">
					<img src="images/22.jpg" alt="xperia C" style="width: 40%";style="hight: 300px";>
					<div class="carousel-caption">
						<h3>xperia C</h3>
					</div>
				</div>
				<div class="item">
					<img src="images/33.jpg" alt="xperia M" style="width: 40%";" style="hight: 300px";>
					<div class="carousel-caption">
						<h3>xperia M</h3>
					</div>
				</div>
				<div class="item">
					<img src="images/44.jpg" alt="ultra t2" style="width: 40%";" style="hight: 300px";>
					<div class="carousel-caption">
						<h3>ultra t2</h3>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#mycarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> 
				<span class="sr-only">previous</span>
			</a> <a class="right carousel-control" href="#mycarousel"
				data-slide="next"> 
				<span class="glyphicon glyphicon-chevron-right"></span> 
				<span class="sr-only">next</span>
			</a>



		</div>


	</div>
<%@include file="Footer.jsp"%>