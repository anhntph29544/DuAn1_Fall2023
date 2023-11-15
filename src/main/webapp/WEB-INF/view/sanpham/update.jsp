<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">TÀI KHOẢN</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Trang Chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Tạo Hóa Đơn</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Quản Lý Chung
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Quản Lý Nhân Viên</a></li>
                        <li><a class="dropdown-item" href="#">Quản Lý Khách Hàng</a></li>
                        <li><a class="dropdown-item" href="/shop-xe/san-pham-chi-tiet/hien-thi">Quản Lý Sản Phẩm</a>
                        </li>
                        <li><a class="dropdown-item" href="#">Thống Kê</a></li>
                        <li><a class="dropdown-item" href="">Quản Lý Voucher</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Linh kiện
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/mau-sac/hien-thi">Màu Sắc</a></li>
                        <li><a class="dropdown-item" href="/nsx/hien-thi">Nhà Sản Xuất</a></li>
                        <li><a class="dropdown-item" href="/shop-xe/kieu-dang-xe">Kiểu Dáng</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div style="padding: 20px">
    <div style="text-align: center">
        <h3>SỬA SẢN PHẨM</h3>
    </div>
    <form:form class="col-md-5" style="margin: auto" action="/shop-xe/san-pham/update" modelAttribute="sp1"
               method="post">
        <div class="mb-3">
            <label class="form-label">Mã sản phẩm</label>
            <form:input class="form-control" path="ma" disabled="true"/>
            <div class="form-text"><form:errors path="ma"/></div>
        </div>
        <div class="mb-3">
            <label class="form-label">Tên sản phẩm</label>
            <form:input class="form-control" path="ten"/>
            <div class="form-text"><form:errors path="ten"/></div>
        </div>
        <%--trạng thái--%>
        <div class="mb-3">
            <label class="form-label">Trạng thái</label>
            <div class="mb-3 form-check">
                <form:radiobutton path="trangThai" class="form-check-input" value="0" id="trangThaiSP1"
                                  checked="true"/>
                <label class="form-check-label" for="trangThaiSP1">Hoạt động</label>
            </div>
            <div class="mb-3 form-check">
                <form:radiobutton path="trangThai" class="form-check-input" value="1" id="trangThaiSP2"/>
                <label class="form-check-label" for="trangThaiSP2">Không hoạt động</label>
            </div>
        </div>
        <form:button type="submit" class="btn btn-primary">Update</form:button>
    </form:form>
</div>
</body>
</html>