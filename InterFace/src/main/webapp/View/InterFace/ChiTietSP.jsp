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
        <!-- Header-->
		<header class="bg-dark py-5">
			<div class="container px-4 px-lg-5 my-5">
				<div class="text-center text-white">
					<h1 class="display-4 fw-bolder">Shop in style</h1>
					<p class="lead fw-normal text-white-50 mb-0">With this shop hompeage template</p>
				</div>
			</div>
        </header>
		<!-- Page Content-->
        <div class="container px-4 px-lg-5">
            <!-- Heading Row-->
            <c:forEach items="${ds_sp}" var="ds_sp">
            <div class="row gx-4 gx-lg-5 align-items-center my-5">
                <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0" src="${ds_sp.anh_sp}" alt="..." /></div>
                <div class="col-lg-5">
                    <h1 class="font-weight-light">${ds_sp.ten_sp}</h1>
                    <p>${ds_sp.gia_sp}</p>
                    <a class="btn btn-primary" href="GioHangForward">Thêm Vào Giỏ Hàng</a>
                </div>
            </div>
            <!-- Call to Action-->
            <div class="card text-white bg-secondary my-5 py-4 text-center">
                <div class="card-body"><p class="text-white m-0">This call to action card is a great place to showcase some important information or display a clever tagline!</p></div>
            </div>
            <!-- Content Row-->
            <div class="row gx-4 gx-lg-5">
                <div class="col-md-4 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                            <h2 class="card-title">Chi Tiết</h2>
                            <p class="card-text"><li>${ds_sp.chitiet_sp}</li></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                            <h2 class="card-title">Khuyến Mãi</h2>
                            <p class="card-text"><li>${ds_sp.khuyenmai}</li></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                            <h2 class="card-title">Thông Tin Thêm</h2>
                            <p class="card-text">
                            	<li>${ds_sp.tinhtrang}</li>
                            	<li>${ds_sp.baohanh}</li>
                            	<li>${ds_sp.phukien}</li>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
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
    </body>
</html>