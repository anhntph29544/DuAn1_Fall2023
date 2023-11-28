<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <a class="nav-link active" aria-current="page" href="/shop-xe/trang-chu">Trang Chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/tao-hoa-don/hien-thi">Tạo Hóa Đơn</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Quản Lý Chung
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/nhan-vien/hien-thi">Quản Lý Nhân Viên</a></li>
                        <li><a class="dropdown-item" href="/khach-hang/hien-thi">Quản Lý Khách Hàng</a></li>
                        <li><a class="dropdown-item" href="/shop-xe/san-pham">Quản Lý Sản Phẩm</a>
                        </li>
                        <li><a class="dropdown-item" href="#">Thống Kê</a></li>
                        <li><a class="dropdown-item" href="">Quản Lý Voucher</a></li>
                        <li><a class="dropdown-item" href="/hoa-don/hien-thi">Quản Lý Hóa Đơn</a></li>

                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Thông tin sản phẩm
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/shop-xe/mau-sac/hien-thi">Quản Lý Màu Sắc</a></li>
                        <li><a class="dropdown-item" href="/shop-xe/kich-thuoc/hien-thi">Quản Lý Kích Thước</a></li>
                        <li><a class="dropdown-item" href="/shop-xe/kieu-dang-xe/hien-thi">Quản Lý Kiểu Dáng</a></li>
                        <li><a class="dropdown-item" href="/shop-xe/thuong-hieu/hien-thi">Quản Lý Thương hiệu</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>