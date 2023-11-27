<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <script>
        function thongbao() {
            alert("Chỉ được tạo tối đa 8 hoá đơn");
        }
    </script>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<div class="container" style="margin-top: 10px">
    <br>
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <c:if test="${listHD.size()>0}">
            <c:forEach items="${listHD}" var="hd" varStatus="stt">
                <li class="nav-item" role="presentation">
                    <a href="/chon-hoa-don/hien-thi/${hd.id}" style="text-decoration: none">
                        <button class="nav-link ${hd.id==idHDSelect?'active':''}" data-bs-toggle="tab" type="button"
                                role="tab">
                            Hoá đơn ${stt.index+1}
                        </button>
                    </a>
                </li>
            </c:forEach>
        </c:if>
        <li>
            <c:if test="${listHD.size()<8}">
                <form action="/tao-hoa-don/add" method="post">
                    <button class="btn btn-primary" data-bs-toggle="tooltip" data-bs-placement="right"
                            title="Tạo hoá đơn">
                        <i class="bi bi-plus-lg"></i>
                    </button>
                </form>
            </c:if>
            <c:if test="${listHD.size()>=8}">
                <button class="btn btn-primary" onclick="thongbao()"
                        data-bs-toggle="tooltip" data-bs-placement="right" title="Đã tối đa">
                    <i class="bi bi-plus-lg"></i>
                </button>
            </c:if>
        </li>
    </ul>
    <div class="ban-hang row" style="margin-top: 10px">
        <div class="gio-hang col-md-9">
            <c:if test="${listHD.size()>0}">
                <!--code giỏ hàng và modal sản phẩm-->
                <!-- Button modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#themSP">
                    Thêm sản phẩm
                </button>
                <table class="table">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Ảnh</th>
                        <th>Tên sản phẩm</th>
                        <th>Số lượng</th>
                        <th>Đơn giá</th>
                        <th>Tổng tiền</th>
                        <th>Thao tác</th>
                    </tr>
                    </thead>
                    <c:forEach var="hdct" varStatus="stt" items="${listHDCT}">
                        <tr>
                            <td>${stt.index+1}</td>
                            <td>
                                <img src='<c:url value="/getimage/${hdct.sanPhamCT.hinhAnh}"></c:url>'
                                     style="max-width: 100px">
                            </td>
                            <td>${hdct.sanPhamCT.sp.ten}</td>
                            <td>${hdct.soLuong}</td>
                            <td>
                                <fmt:formatNumber type="number" value="${hdct.sanPhamCT.gia}"/>
                            </td>
                            <td>
                                <fmt:formatNumber type="number" value="${hdct.sanPhamCT.gia*hdct.soLuong}"/>
                            </td>
                            <td>
                                <a href="/hoa-don/xoa-san-pham/${hdct.id}" style="text-decoration: none; color: white">
                                    <button class="btn btn-danger" data-bs-toggle="tooltip" data-bs-placement="bottom"
                                            title="Xoá sản phẩm" onclick="return confirm('Bạn có chắc không?')">
                                        <i class="bi bi-trash"></i>
                                    </button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <div class="thanh-toan col-md-3">
            <!--Thông tin thanh toán và khách hàng-->
            <h3>Thanh Toán</h3>
            <!--Thông tin thanh toán và khách hàng-->
            <button type="submit" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#themKH"><i
                    class="bi bi-search"></i>Chọn Khách Hàng
            </button>
            <br>
            <!--modal-->
            <div class="modal fade" id="themKH" data-bs-backdrop="static" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-xl modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="">
                                <div class="input-group mb-3">
                                    <input type="text" class="form-control" placeholder="Nhập email khách hàng"
                                           aria-describedby="button-addon2">
                                    <button class="btn btn-outline-secondary" type="button" id="button-addon3">Tìm
                                        kiếm
                                    </button>
                                </div>
                            </form>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Mã</th>
                                    <th>Hình ảnh</th>
                                    <th>Tên Khách Hàng</th>
                                    <th>SDT</th>
                                    <th>Địa Chỉ</th>
                                    <th>Trạng Thái</th>
                                    <th>Hành động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listKH}" var="kh" varStatus="stt">
                                    <tr>
                                        <td>${stt.index+1}</td>
                                        <td>${kh.ma}</td>
                                        <td>
                                                <%--<img src='<c:url value="/getimage/${spct.hinhAnh}"></c:url>' style="max-width: 100px">--%>
                                        </td>
                                        <td>${kh.hoTen}</td>
                                        <td>${kh.sdt}</td>
                                        <td>${kh.soNha}</td>
                                        <td>${spct.trangThai==0? "Hoạt động" : "Không hoạt động"}</td>
                                        <td>
                                            <form action="/hoa-don/them-khach-hang" method="post">
                                                <input name="KHID" value="${kh.idKhachHang}" hidden>
                                                <button style="padding-bottom: 3px" class="btn btn-warning" data-bs-toggle="tooltip"
                                                        data-bs-placement="right"
                                                        title="Chọn">
                                                    <i class="bi bi-plus"></i>
                                                </button>
                                            </form>

                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Nhập voucher"
                       aria-describedby="button-addon2">
                <button class="btn btn-outline-secondary" type="button" id="button-addon4">Tìm
                    kiếm
                </button></br>
            </div>
            <td>
                Tên Khách Hàng: <input value="${kh.hoTen}"><br>
            </td>
            <td>
                Email Khách Hàng:<input value="${kh.email}"><br>
            </td>
            <td>
                SDT Khách Hàng:<input value="${kh.sdt}"><br>
            </td>
            <!--het modal-->
            <form:form modelAttribute="hd" method="post" action="/hoa-don/add">
                Tạm Tính :<form:input path="thanhTien"/><br>
                Tổng Tiền:<form:input path="tienKhachDua"/><br>
            </form:form>
            <button type="submit" class="btn btn-primary"><i class="bi bi-wallet-fill"></i>Thanh Toán</button>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="themSP" data-bs-backdrop="static" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="">
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="Nhập mã sản phẩm"
                               aria-describedby="button-addon2">
                        <button class="btn btn-outline-secondary" type="button" id="button-addon2">Tìm kiếm</button>
                    </div>
                </form>
                <table class="table">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Mã</th>
                        <th>Hình ảnh</th>
                        <th>Tên sản phẩm</th>
                        <th>Số lượng</th>
                        <th>Kích thước</th>
                        <th>Màu sắc</th>
                        <th>Đơn giá</th>
                        <th>Mô tả</th>
                        <th>Trạng thái</th>
                        <th>Hành động</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listSPCT}" var="spct" varStatus="stt">
                        <tr>
                            <td>${stt.index+1}</td>
                            <td>${spct.ma}</td>
                            <td>
                                <img src='<c:url value="/getimage/${spct.hinhAnh}"></c:url>' style="max-width: 100px">
                            </td>
                            <td>${spct.sp.ten}</td>
                            <td>${spct.soLuong}</td>
                            <td>${spct.kt.ten}</td>
                            <td>${spct.ms.ten}</td>
                            <td>${spct.gia}</td>
                            <td>${spct.moTa}</td>
                            <td>${spct.trangThai==0? "Hoạt động" : "Không hoạt động"}</td>
                            <td>
                                <form action="/hoa-don/them-san-pham" method="post">
                                    <input name="spctID" value="${spct.id}" hidden>
                                    <button class="btn btn-warning" data-bs-toggle="tooltip" data-bs-placement="right"
                                            title="Thêm vào giỏ hàng">
                                        <i class="bi bi-cart-plus"></i>
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
    var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl)
    })
</script>
</body>
</html>