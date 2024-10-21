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

<!-- Favicon-->
<link rel="icon" type="TemplateChiTietSP/image/x-icon" href="TemplateChiTietSP/assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="TemplateChiTietSP/css/styles.css" rel="stylesheet" />
<!-- Favicon -->
	<link rel="icon" type="image/png" href="images/favicon.png">
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
				<a style="font-size: 20px" class="navbar-brand" href="HomeForward">C2N Shop</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul style="font-size: 17px" class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item" ><a class="nav-link active" aria-current="page" href="HomeForward">Home</a></li>
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
					<button style="margin-right: 20px" class="btn btn-outline-dark" type="submit">
						<i class="fas bi-cart-fill me-1"></i>
							Giỏ Hàng
						<span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
					</button>
					<button class="btn btn-outline-dark" type="submit">
						<i class="bi-cart-fill me-1"></i>
							Tài Khoản
					</button>
					<%= session.getAttribute("session_ten") %>
				</form>
				</div>
			</div>
		</nav>
		<p>Giỏ Hàng</p>
		<!-- Shopping Cart -->
	<!-- Giỏ Hàng -->
<div class="shopping-cart section">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <!-- Shopping Summery -->
                <table class="table shopping-summery">
                    <thead>
                        <tr class="main-hading">
                            <th>PRODUCT</th>
                            <th>NAME</th>
                            <th class="text-center">UNIT PRICE</th>
                            <th class="text-center">QUANTITY</th>
                            <th class="text-center">TOTAL</th> 
                            <th class="text-center"><i class="ti-trash remove-icon"></i></th>
                        </tr>
                    </thead>
                    <c:set var="o" value="${sessionScope.giohang}" />
                    <c:forEach items="${o.items}" var="i">
                    <tbody>
                            <tr>
                                <td class="image" data-title="No"><img src="#"></td>
                                <td class="product-des" data-title="Description">
                                    <p class="product-name"><a href="#">${i.sanpham.ten_sp}</a></p>
                                </td>
                                <td class="price" data-title="Price"><span>${i.gia}</span></td>
                                <td class="qty" data-title="Qty"><!-- Input Order -->
                                    <div class="input-group">
                                        <div class="button minus">
                                            <button type="button" class="btn1 btn-primary btn-number" disabled="disabled" data-type="minus" data-field="quant[3]">
                                                <a href="CongVaXoaSanPham?qly=tru&id_sp=${i.sanpham.id_sp}"><i class="ti-minus"></i></a>
                                            </button>
                                        </div>
                                        <input type="text" name="quant[3]" readonly class="input-number"  data-min="1" data-max="100" value="${i.soluong}">
                                        <div class="button plus">
                                            <button type="button" class="btn1 btn-primary btn-number" data-type="plus" data-field="quant[3]">
                                            	 <a href="CongVaXoaSanPham?qly=cong&id_sp=${i.sanpham.id_sp}"><i class="ti-plus"></i></a>
                                            </button>
                                        </div>
                                    </div>
                                    <!--/ End Input Order -->
                                </td>
                                <td class="total-amount" data-title="Total"><span>${i.gia*i.soluong}</span></td>
                                <td class="action" data-title="Remove"><a href="XoaSPController?qly=xoa&id_sp=${i.sanpham.id_sp}"><i class="ti-trash remove-icon"></i></a></td>
                            </tr>
                    </tbody>
                    </c:forEach>
                </table>
                <!--/ End Shopping Summery -->
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <!-- Total Amount -->
                <div class="total-amount">
                    <div class="row">
                        <div class="col-lg-8 col-md-5 col-12">
                            <div class="left">
                                <div class="coupon">
                                    <form action="#" target="_blank">
                                        <input name="Coupon" placeholder="Enter Your Coupon">
                                        <button class="btn">Apply</button>
                                    </form>
                                </div>
                                <div class="checkbox">
                                    <label class="checkbox-inline" for="2"><input name="news" id="2" type="checkbox"> Shipping (+10$)</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-7 col-12">
                            <div class="right">
                                <ul>
                                    <li>Cart Subtotal<span>$330.00</span></li>
                                    <li>Shipping<span>Free</span></li>
                                    <li>You Save<span>$20.00</span></li>
                                    <li class="last">You Pay<span>${o.TongTien()}</span></li>
                                </ul>
                                <div class="button5">
                                    <a href="ThanhToanController"><button type="submit" class="btn1">Thanh Toán</button></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--/ End Total Amount -->
            </div>
        </div>
    </div>
</div>
<!--/ End Shopping Cart -->
	<!--/ End Shopping Cart -->
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
        </footer>
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
			
        </style>
         <!-- Bootstrap core JS-->
        <script src="TemplateChiTietSP/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="TemplateChiTietSP/js/scripts.js"></script>
        
        
        <!-- Jquery -->
    <script src="Template/js/jquery.min.js"></script>
    <script src="Template/js/jquery-migrate-3.0.0.js"></script>
	<script src="Template/js/jquery-ui.min.js"></script>
	<!-- Popper JS -->
	<script src="Template/js/popper.min.js"></script>
	<!-- Bootstrap JS -->
	<script src="Template/js/bootstrap.min.js"></script>
	<!-- Color JS -->
	<script src="Template/js/colors.js"></script>
	<!-- Slicknav JS -->
	<script src="Template/s/slicknav.min.js"></script>
	<!-- Owl Carousel JS -->
	<script src="Template/js/owl-carousel.js"></script>
	<!-- Magnific Popup JS -->
	<script src="Template/js/magnific-popup.js"></script>
	<!-- Fancybox JS -->
	<script src="Template/js/facnybox.min.js"></script>
	<!-- Waypoints JS -->
	<script src="Template/js/waypoints.min.js"></script>
	<!-- Countdown JS -->
	<script src="Template/js/finalcountdown.min.js"></script>
	<!-- Nice Select JS -->
	<script src="Template/js/nicesellect.js"></script>
	<!-- Ytplayer JS -->
	<script src="Template/js/ytplayer.min.js"></script>
	<!-- Flex Slider JS -->
	<script src="Template/js/flex-slider.js"></script>
	<!-- ScrollUp JS -->
	<script src="Template/js/scrollup.js"></script>
	<!-- Onepage Nav JS -->
	<script src="Template/js/onepage-nav.min.js"></script>
	<!-- Easing JS -->
	<script src="Template/js/easing.js"></script>
	<!-- Active JS -->
	<script src="Template/js/active.js"></script>
        
    </body>
</html>