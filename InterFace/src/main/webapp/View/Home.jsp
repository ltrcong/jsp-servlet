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
				
				<c:set var="size" value="${requestScope.size}" />
					<a style="margin-right: 20px" class="btn btn-outline-dark" href="HienThiGioHang">
						<i class="fas bi-cart-fill me-1"></i>
							Giỏ Hàng
						<span class="badge bg-dark text-white ms-1 rounded-pill">${size}</span>
					</a>
					<form class="d-flex" action="DangNhapTaiKhoanController"  method="POST">
					<button class="btn btn-outline-dark" type="submit">
						<i class="bi-cart-fill me-1"></i>
							Tài Khoản
					</button>
					
					
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
        <div class="search-top"> 
        	<form class="search-form"> 
        		<input type="text" placeholder="Search here..." name="search"> 
        		<button value="search" type="submit">Tìm Kiếm</button> 
        	</form> 
        </div> 
        <!-- Section-->
		<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<c:forEach items="${ds_sp}" var="ds_sp">
				<c:set var="id" value="${ds_sp.id_sp}"/>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top" src="${ds_sp.anh_sp}" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<a href="ChiTietSanPham?id_sp=${ds_sp.id_sp}"><h5 class="fw-bolder">${ds_sp.ten_sp}</h5></a>
								<!-- Product price-->
								${ds_sp.gia_sp}
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent d-flex justify-content-center 	">
							<div class="text-center" ><a href="GioHangForward?id_sp=${ds_sp.id_sp}" class="btn btn-outline-dark mt-auto">Add to card</a></div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
		</section>
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
* Style the search-top container */
.search-top {
  background-color: #f8f8f8; /* Background color */
  padding: 20px; /* Add padding to the container */
}

/* Style the search form */
.search-form {
  display: flex;
  justify-content: center;
  float: right;
  margin-right: 60px;
  margin-top: 25px
}

/* Style the search input field */
.search-form input[type="text"] {
  padding: 10px; /* Add padding to the input field */
  border: 1px solid #ccc; /* Add a border */
  border-radius: 5px; /* Add some rounded corners */
  width: 300px; /* Set the input width */
}

/* Style the search button */
.search-form button {
  color: white; /* Text color */
  padding: 10px 20px; /* Add padding to the button */
  border: none; /* Remove button border */
  
  cursor: pointer; /* Add a pointer cursor on hover */
  margin-left: 10px; /* Add some spacing to the button */
}

/* Style the search button icon (if it has an icon) */
.search-form button i {
  font-size: 20px; /* Set the icon size */
}
        </style>
    </body>
</html>