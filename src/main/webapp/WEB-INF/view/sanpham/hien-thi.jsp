<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        i {
            font-size: 30px;
        }
        body{
            margin: auto;
        }
    </style>
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
<div class="ql" style="padding: 20px">
    <h2 style="text-align: center">QUẢN LÝ SẢN PHẨM</h2>
    <form:form method="post" action="/shop-xe/san-pham-chi-tiet/add" modelAttribute="spct1">
        <%--thông tin sản phẩm--%>
        <h4>SẢN PHẨM</h4>
        <div class="col-md-12 row">
            <div class="col-md-3">
                    <%--mã sản phẩm chi tiết--%>
                <div class="mb-3">
                    <label class="form-label">Mã</label>
                    <form:input class="form-control" path="ma"/>
                    <div class="form-text"><form:errors path="ma"/></div>
                </div>
                    <%--sản phẩm--%>
                <div class="mb-3">
                    <label class="form-label">Sản phẩm</label>
                    <div class="col-md-12 row">
                        <div class="col-md-11">
                            <form:select path="sp" class="form-select">
                                <c:forEach items="${listSP}" var="sp">
                                    <form:option value="${sp}">${sp.ten}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-md-1">
                            <a href="/san-pham/hien-thi"><i class="bi bi-plus-circle-dotted"></i></a>
                        </div>
                    </div>
                </div>
                    <%--đơn giá--%>
                <div class="mb-3">
                    <label class="form-label">Đơn giá</label>
                    <form:input class="form-control" path="gia"/>
                    <div class="form-text"><form:errors path="gia"/></div>
                </div>
            </div>
            <div class="col-md-3">
                    <%--số lượng--%>
                <div class="mb-3">
                    <label class="form-label">Số lượng</label>
                    <form:input class="form-control" path="soLuong" type="number"/>
                    <div class="form-text"><form:errors path="soLuong"/></div>
                </div>
                    <%--mô tả--%>
                <div class="mb-3">
                    <label class="form-label">Mô tả</label>
                    <form:input class="form-control" path="moTa"/>
                    <div class="form-text"><form:errors path="moTa"/></div>
                </div>
                <div class="mb-3">
                    <label class="form-label">Màu sắc</label>
                    <form:select path="ms" class="form-select">
                        <c:forEach items="${listMS}" var="ms">
                            <form:option value="${ms}">${ms.ten}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="col-md-3">

                <div class="mb-3">
                    <label class="form-label">Kiểu dáng xe</label>
                    <form:select path="kdx" class="form-select">
                        <c:forEach items="${listKDX}" var="kdx">
                            <form:option value="${kdx}">${kdx.ten}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Kích thước</label>
                    <form:select path="kt" class="form-select">
                        <c:forEach items="${listKT}" var="kt">
                            <form:option value="${kt}">${kt.ten}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Thương hiệu</label>
                    <form:select path="th" class="form-select">
                        <c:forEach items="${listTH}" var="th">
                            <form:option value="${th}">${th.ten}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="col-md-3">
                    <%--hinh anh--%>
                <div class="mb-3">
                    <label class="form-label">Hình ảnh</label>
                    <input type="file"/>
                </div>
                    <%--trạng thái--%>
                <div class="mb-3">
                    <label class="form-label">Trạng thái</label>
                    <div class="mb-3 form-check">
                        <form:radiobutton path="trangThai" class="form-check-input" value="0" id="exampleCheck1"
                                          checked="true"/>
                        <label class="form-check-label" for="exampleCheck1">Hoạt động</label>
                    </div>
                    <div class="mb-3 form-check">
                        <form:radiobutton path="trangThai" class="form-check-input" value="1" id="exampleCheck2"/>
                        <label class="form-check-label" for="exampleCheck2">Không hoạt động</label>
                    </div>
                </div>
            </div>
        </div>
        <div style="text-align: right">
            <button type="submit" class="btn btn-primary" onclick="return confirm('Bạn chắc chưa ?')">
                <i class="bi bi-plus-square"></i> Thêm
            </button>
        </div>
    </form:form>
    <table class="table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Mô tả</th>
            <th>Trạng thái</th>
            <th>action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSPCT.content}" var="spct" varStatus="stt">
            <tr>
                <td>${stt.index+1}</td>
                <td>${spct.ma}</td>
                <td>${spct.sp.ten}</td>
                <td>${spct.soLuong}</td>
                <td>${spct.gia}</td>
                <td>${spct.moTa}</td>
                <td>${spct.trangThai==0? "Hoạt động" : "Không hoạt động"}</td>
                <td>
                    <a href="/shop-xe/san-pham-chi-tiet/detail/${spct.id}">
                        <button class="btn btn-primary"><i class="bi bi-collection"></i> Chi tiết</button>
                    </a>
                    <a href="/shop-xe/san-pham-chi-tiet/view-update/${spct.id}">
                        <button class="btn btn-success"><i class="bi bi-pencil-square"></i> Cập nhật</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <c:forEach begin="0" end="${listSPCT.totalPages-1<0?0:listSPCT.totalPages-1}" varStatus="loop">
            <c:if test="${listSPCT.totalPages-1>=0}">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link"
                                             href="/shop-xe/san-pham-chi-tiet/hien-thi?page=${loop.index}">${loop.index+1}</a>
                    </li>
                </ul>
            </c:if>
        </c:forEach>
    </nav>
</div>
</body>
</html>