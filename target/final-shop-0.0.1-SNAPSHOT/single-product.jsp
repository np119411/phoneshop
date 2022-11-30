<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>G2 - Product</title>

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
						<li><a href="<%=request.getContextPath()%>/GetPhone">Home</a></li>
						<li><a href="<%=request.getContextPath()%>/GetShopPage">Shoppage</a></li>
						<li class="active"><a
							href="<%=request.getContextPath()%>/GetDetail">Single product</a></li>
						<li><a href="<%=request.getContextPath()%>/AddToCart">Cart</a></li>
						<li><a href="<%=request.getContextPath()%>/Checkout">Checkout</a></li>

					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End mainmenu area -->

	<div class="product-big-title-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="product-bit-title text-center">
						<h2>G2 Shop</h2>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="single-product-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="single-sidebar">
						<h2 class="sidebar-title">Search Products</h2>
						<form action="">
							<input type="text" placeholder="Search products..."> <input
								type="submit" value="Search">
						</form>
					</div>

					<div class="single-sidebar">
						<h2 class="sidebar-title">Products</h2>
						<c:forEach var="item" items="${ACTIVE_PRODUCT_LIST}" begin='0'
							end='3'>
							<div class="thubmnail-recent">
								<img src="${item.image}" class="recent-thumb" alt="">
								<h2>
									<a
										href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${item.ID}">${item.name}</a>
								</h2>
								<div class="product-carousel-price">
									<ins>${item.price}</ins>
									<del>${item.priceDel}</del>
								</div>
							</div>
						</c:forEach>
					</div>

					<div class="single-sidebar">
						<h2 class="sidebar-title">Recent Posts</h2>
						<ul>
							<c:forEach var="item" items="${ACTIVE_PRODUCT_LIST}" begin='0'
								end='5'>
								<li><a
									href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${item.ID}">${item.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="col-md-8">
					<div class="product-content-right">
						<div class="product-breadcroumb">
							<a href="">Home</a> <a href="">Single Product</a> <a href="">${PRODUCT_DETAIL.name}</a>
						</div>

						<div class="row">
							<div class="col-sm-6">
								<div class="product-images">
									<div class="product-main-img">
										<img src="${PRODUCT_DETAIL.image}" alt="">
									</div>

								</div>
							</div>

							<div class="col-sm-6">
								<div class="product-inner">

									<h2 class="product-name">${PRODUCT_DETAIL.name}</h2>
									<div class="product-inner-price">
										<ins>${PRODUCT_DETAIL.price}</ins>
										<del>${PRODUCT_DETAIL.priceDel}</del>
									</div>
									
									<a
										href="<%=request.getContextPath()%>/MainController?action=AddToCart&ID=${PRODUCT_DETAIL.ID}"
										class="add_to_cart_button"> ADD TO CART</a>

									<div class="product-inner-category">
										<p>
											&nbsp; <a href="">&nbsp;</a>
										</p>
									</div>

									<div role="tabpanel">
										<ul class="product-tab" role="tablist">
											<li role="presentation" class="active"><a href="#home"
												aria-controls="home" role="tab" data-toggle="tab">Description</a></li>
											<li role="presentation"><a href="#profile"
												aria-controls="profile" role="tab" data-toggle="tab">Reviews</a></li>
										</ul>
										<div class="tab-content">
											<div role="tabpanel" class="tab-pane fade in active"
												id="home">
												<h2>Product Description</h2>
												<table border="0">
													<tr>
														<td colspan="1">CPU:</td>
														<td rowsspan="2">Exynos 1280 (5 nm)</td>
													</tr>
													<tr>
														<td>GPU:</td>
														<td>Mali-G68</td>
													</tr>
													<tr>
														<td>RAM:</td>
														<td>4GB, 6GB hoặc 8GB</td>
													</tr>
													<tr>
														<td>ROM:</td>
														<td>128GB hoặc 256GB</td>
													</tr>
													<tr>
														<td>Thẻ nhớ:</td>
														<td>MicroSDXC</td>
													</tr>
													<tr>
														<td>Số Sim:</td>
														<td>2 sim Nano</td>
													</tr>
													<tr>
														<td>Màn hình:</td>
														<td>Công nghệ: Super AMOLED, 120Hz, 800 nits</td>
													</tr>
													<tr>
														<td>Kích thước:</td>
														<td>6.5 inches</td>
													</tr>
													<tr>
														<td>Tỷ lệ:</td>
														<td>20:9</td>
													</tr>
													<tr>
														<td>Độ phân giải:</td>
														<td>1080 x 2400 pixel (mật độ ~ 405 ppi)</td>
													</tr>
													<tr>
														<td>Kết nối:</td>
														<td>USB type-C 3.1</td>
													</tr>
													<tr>
														<td>Bluetooth:</td>
														<td>5.1, A2DP, LE</td>
													</tr>
													<tr>
														<td>Cảm biến:</td>
														<td>Cảm biến vân tay dưới màn hình, chuyển động, hồi
															chuyển, tiệm cận, la bàn</td>
													</tr>
													<tr>
														<td>Cảm biến:</td>
														<td>Vân tay</td>
													</tr>


												</table>

											</div>
											<div role="tabpanel" class="tab-pane fade" id="profile">
												<h2>Reviews</h2>
												<div class="submit-review">
													<p>
														<label for="name">Name</label> <input name="name"
															type="text">
													</p>
													<p>
														<label for="email">Email</label> <input name="email"
															type="email">
													</p>
													<div class="rating-chooser">
														<p>Your rating</p>

														<div class="rating-wrap-post">
															<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																class="fa fa-star"></i>
														</div>
													</div>
													<p>
														<label for="review">Your review</label>
														<textarea name="review" id="" cols="30" rows="10"></textarea>
													</p>
													<p>
														<input type="submit" value="Submit">
													</p>
												</div>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>


						<div class="related-products-wrapper">
							<h2 class="related-products-title">Related Products</h2>
							<div class="related-products-carousel">
								<c:forEach var="item1" items="${ACTIVE_PRODUCT_LIST}">
									<div class="single-product">

										<div class="product-f-image">
											<img src="${item1.image }" alt="">
											<div class="product-hover">
												<a href="<%=request.getContextPath()%>/MainController?action=AddToCart&ID=${item1.ID}" class="add-to-cart-link"><i
													class="fa fa-shopping-cart"></i> Add to cart</a> <a
													href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${item1.ID}"
													class="view-details-link"><i class="fa fa-link"></i>
													See details</a>
											</div>
										</div>

										<h2>
											<a
												href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${item1.ID}">${item1.name}</a>
										</h2>
										<div class="product-carousel-price">
											<ins>${item1.price}</ins>
											<del>${item1.priceDel}</del>
										</div>
									</div>
								</c:forEach>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>

	<br>
	<br>
	<br>


	<br>
	<br>
	<br>


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
</body>
</html>