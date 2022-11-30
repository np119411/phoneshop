<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
	ustora by freshdesignweb.com
	Twitter: https://twitter.com/freshdesignweb
	URL: https://www.freshdesignweb.com/ustora/
-->
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>G2 - Home</title>

<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="css/responsive.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>


	<div class="site-branding-area">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="logo">
						<h1>
							<a href="./"><img src="img/logo.png"></a>
						</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End site branding area -->

	<div class="mainmenu-area">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="<%=request.getContextPath()%>/GetPhone">Home</a></li>
						<li><a href="<%=request.getContextPath()%>/GetShopPage">Shop page</a></li>
						<li><a href="<%=request.getContextPath()%>/AddToCart">Cart</a></li>
						<li><a href="<%=request.getContextPath()%>/Checkout">Checkout</a></li>

					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End mainmenu area -->

	<div class="slider-area">
		<!-- Slider -->
		<div class="block-slider block-slider4">
			<ul class="" id="bxslider-home4">
				<li><img src="img/h4-slide.png" alt="Slide">
					<div class="caption-group">
						<h2 class="caption title">
							Realme <span class="primary">8 <strong>Pro</strong></span>
						</h2>
						<h4 class="caption subtitle">Dare To Leap.</h4>
						<a class="caption button-radius" href="<%=request.getContextPath()%>/MainController?action=AddToCart&ID=1"><span class="icon"></span>Shop
							now</a>
					</div></li>
				<li><img src="img/h4-slide2.png" alt="Slide">
					<div class="caption-group">
						<h2 class="caption title">
							Xiaomi <span class="primary">12 <strong>Pro</strong></span>
						</h2>
						<h4 class="caption subtitle">Master Every Scene.</h4>
						<a class="caption button-radius" href="#"><span class="icon"></span>Shop
							now</a>
					</div></li>
				<li><img src="img/h4-slide3.png" alt="Slide">
					<div class="caption-group">
						<h2 class="caption title">
							Nokia <span class="primary">G50 <strong>5G</strong></span>
						</h2>
						<h4 class="caption subtitle">Alive every experience.</h4>
						<a class="caption button-radius" href="<%=request.getContextPath()%>/MainController?action=AddToCart&ID=3"><span class="icon"></span>Shop
							now</a>
					</div></li>
				<li><img src="img/h4-slide4.png" alt="Slide">
					<div class="caption-group">
						<h2 class="caption title">
							Oppo <span class="primary">Reno8 <strong>5G</strong></span>
						</h2>
						<h4 class="caption subtitle">Portrait specialist.</h4>
						<a class="caption button-radius" href="<%=request.getContextPath()%>/MainController?action=AddToCart&ID=2"><span class="icon"></span>Shop
							now</a>
					</div></li>
			</ul>
		</div>
		<!-- ./Slider -->
	</div>
	<!-- End slider area -->

	<div class="promo-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-6">
					<div class="single-promo promo1">
						<i class="fa fa-refresh"></i>
						<p>30 Days return</p>
					</div>
				</div>
				<div class="col-md-3 col-sm-6">
					<div class="single-promo promo2">
						<i class="fa fa-truck"></i>
						<p>Free shipping</p>
					</div>
				</div>
				<div class="col-md-3 col-sm-6">
					<div class="single-promo promo3">
						<i class="fa fa-lock"></i>
						<p>Secure payments</p>
					</div>
				</div>
				<div class="col-md-3 col-sm-6">
					<div class="single-promo promo4">
						<i class="fa fa-gift"></i>
						<p>New products</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End promo area -->

	<div class="maincontent-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="latest-product">
						<h2 class="section-title">Latest Products</h2>
						<div class="product-carousel">
							<c:forEach var="c" items="${ACTIVE_PRODUCT_LIST}">
								<div class="single-product">
									<div class="product-f-image">
										<img src="${c.image}" alt="">
										<div class="product-hover">
											<a href="<%=request.getContextPath()%>/MainController?action=AddToCart&ID=${c.ID}" class="add-to-cart-link"><i
												class="fa fa-shopping-cart"></i> Add to cart</a> <a
												href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${c.ID}" class="view-details-link"><i
												class="fa fa-link"></i> See details</a>
										</div>
									</div>

									<h2>
										<a href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${c.ID}">${c.name}</a>
									</h2>

									<div class="product-carousel-price">
										<ins>${c.price}</ins>
										<del>${c.priceDel}</del>
									</div>
								</div>
							</c:forEach>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End main content area -->

	<div class="brands-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="brand-wrapper">
						<div class="brand-list">
							<img src="img/brand1.png" alt=""> <img src="img/brand2.png"
								alt=""> <img src="img/brand3.png" alt=""> <img
								src="img/brand4.png" alt=""> <img src="img/brand5.png"
								alt=""> <img src="img/brand6.png" alt=""> <img
								src="img/brand1.png" alt=""> <img src="img/brand2.png"
								alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End brands area -->

	<div class="product-widget-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="single-product-widget">
						<h2 class="product-wid-title">Top Sellers</h2>
						<a href="" class="wid-view-more">View All</a>
						<c:forEach var="item1" items="${ACTIVE_PRODUCT_LIST}" begin='0'
							end='2'>
							<div class="single-wid-product">
								<a href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${item1.ID}"><img src="${item1.image}"
									height=190px width=190px alt="" class="product-thumb"></a>
								<h2>
									<a href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${item1.ID}">${item1.name}</a>
								</h2>
								<div class="product-wid-rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</div>
								<div class="product-wid-price">
									<ins>${item1.price}</ins>
									<del>${item1.priceDel}</del>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

				<div class="col-md-4">
					<div class="single-product-widget">
						<h2 class="product-wid-title">Recently Viewed</h2>
						<a href="#" class="wid-view-more">View All</a>
						<c:forEach var="item2" items="${ACTIVE_PRODUCT_LIST}" begin='3'
							end='5'>
							<div class="single-wid-product">
								<a href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${item2.ID}"><img src="${item2.image}"
									height=190px width=190px alt="" class="product-thumb"></a>
								<h2>
									<a href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${item2.ID}">${item2.name}</a>
								</h2>
								<div class="product-wid-rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</div>
								<div class="product-wid-price">
									<ins>${item2.price}</ins>
									<del>${item2.priceDel}</del>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-md-4">
					<div class="single-product-widget">
						<h2 class="product-wid-title">Recently Viewed</h2>
						<a href="#" class="wid-view-more">View All</a>
						<c:forEach var="item3" items="${ACTIVE_PRODUCT_LIST}" begin='6'
							end='8'>
							<div class="single-wid-product">
								<a href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${item3.ID}"><img src="${item3.image}"
									height=190px width=190px alt="" class="product-thumb"></a>
								<h2>
									<a href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${item3.ID}">${item3.name}</a>
								</h2>
								<div class="product-wid-rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</div>
								<div class="product-wid-price">
									<ins>${item3.price}</ins>
									<del>${item3.priceDel}</del>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End product widget area -->

	<div class="footer-top-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-6">
					<div class="footer-about-us">
						<h2>
							G<span>2 Store</span>
						</h2>
						<p>We are group 2. Developers with Youthful Enthusiasm!</p>
						<div class="footer-social">
							<a href="#" target="_blank"><i class="fa fa-facebook"></i></a> <a
								href="#" target="_blank"><i class="fa fa-twitter"></i></a> <a
								href="#" target="_blank"><i class="fa fa-youtube"></i></a> <a
								href="#" target="_blank"><i class="fa fa-linkedin"></i></a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- End footer top area -->



	<!-- Latest jQuery form server -->
	<script src="https://code.jquery.com/jquery.min.js"></script>

	<!-- Bootstrap JS form CDN -->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<!-- jQuery sticky menu -->
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.sticky.js"></script>

	<!-- jQuery easing -->
	<script src="js/jquery.easing.1.3.min.js"></script>

	<!-- Main Script -->
	<script src="js/main.js"></script>

	<!-- Slider -->
	<script type="text/javascript" src="js/bxslider.min.js"></script>
	<script type="text/javascript" src="js/script.slider.js"></script>
</body>
</html>