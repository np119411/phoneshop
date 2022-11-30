<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>G2 - Checkout</title>

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
						
						<li><a href="<%=request.getContextPath()%>/AddToCart">Cart</a></li>
						<li class="active"><a
							href="<%=request.getContextPath()%>/Checkout">Checkout</a></li>

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
						<div class="woocommerce">


							<div class="woocommerce-info">
								Have a coupon? <a class="showcoupon" data-toggle="collapse"
									href="#coupon-collapse-wrap" aria-expanded="false"
									aria-controls="coupon-collapse-wrap">Click here to enter
									your code</a>
							</div>

							<form id="coupon-collapse-wrap" method="post"
								class="checkout_coupon collapse">

								<p class="form-row form-row-first">
									<input type="text" value="" id="coupon_code"
										placeholder="Coupon code" class="input-text"
										name="coupon_code">
								</p>

								<p class="form-row form-row-last">
									<input type="submit" value="Apply Coupon" name="apply_coupon"
										class="button">
								</p>

								<div class="clear"></div>
							</form>

							<form enctype="multipart/form-data" action="#" class="checkout"
								method="post" name="checkout">

								<div id="customer_details" class="col2-set">
									<div class="col-1">
										<div class="woocommerce-billing-fields">
											<h3>Billing Details</h3>

											<p id="billing_first_name_field"
												class="form-row form-row-first validate-required">
												<label class="" for="billing_first_name">First Name
												</label> <input type="text" value="" placeholder=""
													id="billing_first_name" name="billing_first_name"
													class="input-text ">
											</p>

											<p id="billing_last_name_field"
												class="form-row form-row-last validate-required">
												<label class="" for="billing_last_name">Last Name </label> <input
													type="text" value="" placeholder="" id="billing_last_name"
													name="billing_last_name" class="input-text ">
											</p>
											<div class="clear"></div>

											<p id="billing_address_1_field"
												class="form-row form-row-wide address-field validate-required">
												<label class="" for="billing_address_1">Address </label> <input
													type="text" value="" placeholder="Your Address"
													id="billing_address_1" name="billing_address_1"
													class="input-text ">
											</p>


											<p id="billing_email_field"
												class="form-row form-row-first validate-required validate-email">
												<label class="" for="billing_email">Email Address </label> <input
													type="text" value="" placeholder="abc@example.com"
													id="billing_email" name="billing_email" class="input-text ">
											</p>

											<p id="billing_phone_field"
												class="form-row form-row-last validate-required validate-phone">
												<label class="" for="billing_phone">Phone </label> <input
													type="text" value="" placeholder="" id="billing_phone"
													name="billing_phone" class="input-text ">
											</p>
											<div class="clear"></div>



										</div>
									</div>



								</div>

								<h3 id="order_review_heading">Your order</h3>

								<div id="order_review" style="position: relative;">
									<c:forEach var="item1" items="${CART.lineItems}" begin='0'
										end='0'>
										<c:forEach var="item" items="${CART.lineItems}">
										
											<table class="shop_table">
												<thead>
													<tr>
														<th class="product-name">Product</th>
														<th class="product-total">Total</th>
													</tr>
												</thead>
												<tbody>
													<tr class="cart_item">
														<td class="product-name">${item.phoneDTO.name}</td>
														<td class="product-total"><span class="amount">${item.subPrice}</span>
														</td>
													</tr>
												</tbody>
											</table>
										</c:forEach>
										<table class="shop_table">
										<tfoot>
											<tr class="shipping">
												<th>Shipping and Handling</th>
												<td>Free Shipping <input type="hidden"
													class="shipping_method" value="free_shipping"
													id="shipping_method_0" data-index="0"
													name="shipping_method[0]">
												</td>
											</tr>
											<tr class="order-total">
												<th>Order Total</th>
												<td><strong><span class="amount">${CART.totalPrice}</span></strong>
												</td>
											</tr>
										</tfoot>
										</table>
									</c:forEach>


									<div id="payment">
										<ul class="payment_methods methods">
											<li class="payment_method_cheque"><input type="radio"
												data-order_button_text="" value="cheque"
												name="payment_method" class="input-radio"
												id="payment_method_cheque"> <label
												for="payment_method_cheque">Cash on Delivery</label></li>
											<li class="payment_method_paypal"><input type="radio"
												data-order_button_text="Proceed to PayPal" value="paypal"
												name="payment_method" class="input-radio"
												id="payment_method_paypal"> <label
												for="payment_method_paypal">Credit Card </label></li>
										</ul>

										<div class="form-row place-order">

											<input type="submit" data-value="Place order"
												value="Place order" id="place_order"
												name="woocommerce_checkout_place_order" class="button alt">


										</div>
										<br>

										<div class="clear"></div>

									</div>

								</div>
							</form>

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