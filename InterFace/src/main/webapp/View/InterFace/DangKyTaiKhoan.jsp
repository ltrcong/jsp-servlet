<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<!-- Favicon-->
<link rel="icon" type="Template/image/x-icon" href="Template/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="Template/font/bootstrap-icons.css" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="Template/css/styles.css" rel="stylesheet" />


	<!-- Web Font -->
	<link href="TemplateGH/css/font-face-css.CSS" rel="stylesheet">
	
	<!-- StyleSheet -->
	
	<!-- Bootstrap -->
	<link rel="stylesheet" href="TemplateGH/css/bootstrap.css">
	<!-- Magnific Popup -->
    <link rel="stylesheet" href="TemplateGH/css/magnific-popup.min.css">
	<!-- Font Awesome -->
    <link rel="stylesheet" href="TemplateGH/css/font-awesome.css">
	<!-- Fancybox -->
	<link rel="stylesheet" href="TemplateGH/css/jquery.fancybox.min.css">
	<!-- Themify Icons -->
    <link rel="stylesheet" href="TemplateGH/css/themify-icons.css">
	<!-- Nice Select CSS -->
    <link rel="stylesheet" href="TemplateGH/css/niceselect.css">
	<!-- Animate CSS -->
    <link rel="stylesheet" href="TemplateGH/css/animate.css">
	<!-- Flex Slider CSS -->
    <link rel="stylesheet" href="TemplateGH/css/flex-slider.min.css">
	<!-- Owl Carousel -->
    <link rel="stylesheet" href="TemplateGH/css/owl-carousel.css">
	<!-- Slicknav -->
    <link rel="stylesheet" href="TemplateGH/css/slicknav.min.css">
	
	<!-- Eshop StyleSheet -->
	<link rel="stylesheet" href="TemplateGH/css/reset.css">
	<link rel="stylesheet" href="TemplateGH/style.css">
    <link rel="stylesheet" href="TemplateGH/css/responsive.css">

</head>

<body>
        <!-- Navigation-->
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container px-4 px-lg-5">
				<a class="navbar-brand" href="HomeForward">C2N Shop</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="HomeForward">Home</a></li>
					<!-- <li class="nav-item"><a class="nav-link" href="#!">About</a></li> -->
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Danh Mục</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<c:forEach items="${dm_sp}" var="dm_sp">
							<li><a class="dropdown-item" href="LaySanPhamTheoIDDM?id_dm=${dm_sp.id_dm}">${dm_sp.ten_dm}</a></li>
							</c:forEach>
						</ul>
					</li>
				</ul>
				<form class="d-flex">
				<c:set var="size" value="${requestScope.size}" />
					<a style="margin-right: 20px" class="btn btn-outline-dark" href="HienThiGioHang">
						<i class="fas bi-cart-fill me-1"></i>
							Giỏ Hàng
						<span class="badge bg-dark text-white ms-1 rounded-pill">${size}</span>
					</a>
					<button class="btn btn-outline-dark" type="submit">
						<i class="bi-cart-fill me-1"></i>
							Tài Khoản
					</button>
				</form>
				</div>
			</div>
		</nav>
        <section class="shop checkout section">
			<div class="container">
				<div class="row"> 
					<div class="col-lg-8 col-12">
						<div class="checkout-form">
							<h2>Make Your Checkout Here</h2>
							<p>Please register in order to checkout more quickly</p>
							<!-- Form -->
							<form class="form" method="post" action="#">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-12">
										<div class="form-group">
											<label>Name<span>*</span></label>
											<input type="text" name="ten_kh" placeholder="" required="required">
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-12">
										<div class="form-group">
											<label>Email Address<span>*</span></label>
											<input type="email" name="email_kh" placeholder="" required="required">
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-12">
										<div class="form-group">
											<label>Phone Number<span>*</span></label>
											<input type="text" name="sdt_kh" placeholder="" required="required">
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-12">
										<div class="form-group">
											<label>Adress<span>*</span></label>
											<input type="text" name="diachi_kh" placeholder="" required="required">
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-12">
										<div class="form-group">
											<label>Password<span>*</span></label>
											<input type="text" name="mk_kh" placeholder="" required="required">
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-12">
										<div class="form-group">
											<label>Confirm Password<span>*</span></label>
											<input type="text" name="nlmk_kh" placeholder="" required="required">
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-12">
										<div class="form-group" >
											<label>Gender<span>*</span></label>
											<input  type="radio" name="gioitinh_kh" value="nam"><p>Nam</p>
											<input  type="radio" name="gioitinh_kh" value="nữ"><p>Nữ</p>
										</div>
									</div>
								
									<div class="col-12">
										<div class="form-group create-account">
											<a href="DangNhapTaiKhoanController" style="font-size: 20px">Create an account ?</a>
										</div>
									</div>
								</div>
								<!-- Button Widget -->
								<div class="single-widget get-button">
									<div class="content">
										<div class="button">
											<input type="button" class="btn" value="proceed to checkout">
										</div>
									</div>
								</div>
								<!--/ End Button Widget -->
							</form>
							<!--/ End Form -->
						</div>
					</div>
					<div class="col-lg-4 col-12">
						<div class="order-details">
							<!-- Order Widget -->
							<div class="single-widget">
								<h2>CART  TOTALS</h2>
								<div class="content">
									<ul>
										<li>Sub Total<span>$330.00</span></li>
										<li>(+) Shipping<span>$10.00</span></li>
										<li class="last">Total<span>$340.00</span></li>
									</ul>
								</div>
							</div>
							<!--/ End Payment Method Widget -->
							
						</div>
					</div>
				</div>
			</div>
		</section>
        
        <!-- Bootstrap core JS-->
        <script src="Template/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="Template/js/scripts.js"></script>
        <style>
        	a 
        	{
  				text-decoration: none; /* Loại bỏ gạch dưới chân mặc định */
  				color: inherit; /* hoặc color: #your-color; */
  				font-family: Times New Roman;
  				font-weight: 10;
			}

			a:hover 
			{
  				text-decoration: none; /* Loại bỏ gạch dưới chân khi di chuột qua */
			}
			.fw-bolder
			{
				 font-weight: 10;
			}
			
			.shop.checkout.section 
			{
  				padding: 80px 0;
			}

			.shop.checkout.section 
			{
			  padding: 80px 0;
			}
			
			.checkout-form 
			{
			  background-color: #ffffff;
			  padding: 40px;
			  border-radius: 5px;
			  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
			}
			
			.checkout-form h2 
			{
			  font-size: 24px;
			  font-weight: 700;
			  margin-bottom: 20px;
			}
			
			.checkout-form p 
			{
			  margin-bottom: 20px;
			}
			
			.form-group 
			{
			  margin-bottom: 20px;
			}
			
			.form-group label 
			{
			  font-weight: 500;
			  display: block;
			  margin-bottom: 5px;
			}
			
			.form-group input[type="text"],
			.form-group input[type="number"],
			.form-group input[type="email"],
			.form-group select,
			.form-group textarea 
			{
			  width: 100%;
			  padding: 10px;
			  border: 1px solid #ccc;
			  border-radius: 3px;
			}
			
			.form-group select 
			{
			  appearance: none;
			  -webkit-appearance: none;
			  -moz-appearance: none;
			  background: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 30 30'%3E%3Cpath d='M15 18.8l-7-7.2c-.4-.4-1-.4-1.4 0s-.4 1 0 1.4l7.7 7.8c.2.2.5.2.7 0l7.7-7.8c.4-.4.4-1 0-1.4s-1-.4-1.4 0l-7 7.2z'/%3E%3C/svg%3E") no-repeat right 10px center;
			  padding-right: 30px;
			  background-color: #ffffff;
			  color: #666666;
			  border: 1px solid #ccc;
			}
			
			.form-group select::-ms-expand 
			{
			  display: none;
			}
			
			.form-group textarea 
			{
			  resize: vertical;
			}
			
			.checkout-form input[type="radio"] 
			{
			  display: inline-block;
			  vertical-align: middle;
			  margin-right: 15px;
			}
			
			.checkout-form input[type="radio"] + p 
			{
			  display: inline-block;
			  vertical-align: middle;
			  margin-top: 19px;
			}
			
			.order-details .single-widget 
			{
			  margin-bottom: 30px;
			}
			
			.order-details h2 
			{
			  font-size: 24px;
			  font-weight: 700;
			  margin-bottom: 20px;
			}
			
			.order-details ul 
			{
			  padding: 0;
			  margin: 0;
			  list-style: none;
			}
			
			.order-details ul li 
			{
			  margin-bottom: 10px;
			  display: flex;
			  justify-content: space-between;
			}
			
			.order-details ul li.last 
			{
			  font-weight: 700;
			}
			
			.order-details ul li span 
			{
			  font-weight: 500;
			}
			
			.payement .content 
			{
			  text-align: center;
			}
			
			.payement img 
			{
			  max-width: 150px;
			}
			
			.get-button .content 
			{
			  text-align: center;
			}
			
			.get-button .button 
			{
			  margin-top: 20px;
			}
			
			.get-button .button .btn 
			{
			  display: inline-block;
			  background-color: black;
			  color: white;
			  padding: 10px 20px;
			  border-radius: 3px;
			  text-decoration: none;
			}
			
			.get-button .button .btn:hover 
			{
			  background-color: #333333;
			}
        </style>
    </body>
</html>