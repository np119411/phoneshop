<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.phoneshop.shopping.CartProduct"%>
<%@page import="com.phoneshop.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>G2 - Cart</title>

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
						<li class="active"><a
							href="<%=request.getContextPath()%>/GetPhone">Home</a></li>
						<li><a href="<%=request.getContextPath()%>/GetShopPage">Shop
								page</a></li>
						
						<li class="active"><a
							href="<%=request.getContextPath()%>/AddToCart">Cart</a></li>
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
						<h2>Shopping Cart</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Page title area -->


	<div class="single-product-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="single-sidebar">
						<h2 class="sidebar-title">Search Products</h2>
						<form action="#">
							<input type="text" placeholder="Search products..."> <input
								type="submit" value="Search">
						</form>
					</div>

					<div class="single-sidebar">
						<h2 class="sidebar-title">Products</h2>
						<c:forEach var="item1" items="${ACTIVE_PRODUCT_LIST}" begin='0'
							end='3'>
							<div class="thubmnail-recent">
								<img src="${item1.image}" class="recent-thumb" alt="">
								<h2>
									<a
										href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${item1.ID}">${item1.name}</a>
								</h2>
								<div class="product-sidebar-price">
									<ins>${item1.price}</ins>
									<del>${item1.priceDel}</del>
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
						<div class="woocommerce">
							<form method="post" action="UpdateController?action=update">
								<table cellspacing="0" class="shop_table cart">
									<thead>
										<tr>
											<th class="product-remove">&nbsp;</th>
											<th class="product-thumbnail">&nbsp;</th>
											<th class="product-name">Product</th>
											<th class="product-price">Price</th>
											<th class="product-quantity">Quantity</th>
											<th class="product-subtotal">Total</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="item" items="${CART.lineItems}">
											<tr class="cart_item">
												<c:set var="k" value="${item}" />
												<c:choose>
													<c:when test="${not empty k.phoneDTO}">
														<td class="product-remove"><a
															title="Remove this item" class="remove"
															href="<%=request.getContextPath()%>/MainController?action=Remove&ID=${k.phoneDTO.ID}">Remove</a></td>

														<td class="product-thumbnail"><a
															href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${k.phoneDTO.ID}"><img
																width="145" height="145" alt="poster_1_up"
																class="shop_thumbnail" src="${k.phoneDTO.image}"></a></td>

														<td class="product-name"><a
															href="<%=request.getContextPath()%>/MainController?action=GetDetail&ID=${k.phoneDTO.ID}">${k.phoneDTO.name}</a></td>

														<td class="product-price"><span class="amount">${k.phoneDTO.price}</span>
														</td>

													</c:when>
													<c:otherwise>
														<td class="product-remove"><a
															title="Remove this item" class="remove"
															href="<%=request.getContextPath()%>/MainController?action=RemovePhonecase&ID=${k.phonecaseDTO.pcID}">Remove</a></td>

														<td class="product-thumbnail">
														<a href="#">
														<img	width="145" height="145" alt="poster_1_up"
																class="shop_thumbnail" src="${k.phonecaseDTO.image}">
																</a></td>

														<td class="product-name"><a href="#">Phonecase</a></td>

														<td class="product-price"><span class="amount">${k.phonecaseDTO.price}</span>
														</td>
													</c:otherwise>

												</c:choose>
												<td class="product-quantity">
													<div class="quantity buttons_added">
														<input type="button" class="minus" value="-"> <input
															type="number" name="quantity" size="4"
															class="input-text qty text" title="Qty"
															value="${item.quantity }" min="1" step="1"> <input
															type="button" class="plus" value="+">
													</div>
												</td>

												<td class="product-subtotal"><span class="amount">${item.subPrice}</span>
												</td>

											</tr>

										</c:forEach>

										<tr>
											<h3>Total Price:</h3>
											<h4>${CART.totalPrice}</h4>
										</tr>

										<tr>
											<td class="actions" colspan="6">
												<div class="coupon">
													<label for="coupon_code">Coupon:</label> <input type="text"
														placeholder="Coupon code" value="" id="coupon_code"
														class="input-text" name="coupon_code"> <input
														type="submit" value="Apply Coupon" name="apply_coupon"
														class="button">
												</div> <input type="submit" value="update" name="update_cart"
												class="button">
												
											</td>
										</tr>
									</tbody>

								</table>
							</form>

							<div class="cart-collaterals">


								<div class="cross-sells">

										<h2>Phonecase</h2>

									<ul class="products">
										<c:forEach var="i" items="${PHONECASE_ACTIVE_PRODUCT_LIST}"
											begin='0' end='1'>
											<li class="product"><a
												href="<%=request.getContextPath()%>/MainController?action=AddPhonecase&ID=${i.pcID}">
													<img width="325" height="325" alt="T_4_front"
													class="attachment-shop_catalog wp-post-image"
													src="${i.image }">
													<h3>&nbsp;</h3> <span class="price"><span
														class="amount"> </span></span>
											</a> <a class="add_to_cart_button" data-quantity="1"
												data-product_sku="" data-product_id="22" rel="nofollow"
												href="<%=request.getContextPath()%>/MainController?action=AddPhonecase&ID=${i.pcID}">Select
													options</a></li>
										</c:forEach>
										<a>&nbsp;</a>
									</ul>
									<br>
								</div>






							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>




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
</body>
</html>