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
    <style>
    </style>
    <script>
        function thongbao() {
            alert("Chỉ được tạo tối đa 5 hoá đơn");
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
            <c:if test="${listHD.size()<5}">
                <form action="/tao-hoa-don/add" method="post">
                    <button class="btn btn-primary" data-bs-toggle="tooltip" data-bs-placement="right"
                            title="Tạo hoá đơn">
                        <i class="bi bi-plus-lg"></i>
                    </button>
                </form>
            </c:if>
            <c:if test="${listHD.size()>=5}">
                <button class="btn btn-primary" onclick="thongbao()"
                        data-bs-toggle="tooltip" data-bs-placement="right" title="Đã tối đa">
                    <i class="bi bi-plus-lg"></i>
                </button>
            </c:if>
        </li>
    </ul>
    <c:if test="${listHD.size()<=0}">
        <div style="text-align: center">
            <h3>Chưa có hoá đơn nào được tạo</h3>
        </div>
    </c:if>
    <div class="ban-hang row" style="margin-top: 10px">
        <div class="gio-hang col-md-9">
            <c:if test="${listHD.size()>0}">
                <!--code giỏ hàng và modal sản phẩm-->
                <!-- Button modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#themSP">
                    Thêm sản phẩm
                </button>
                <!-- Button modal quét qr-->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Quét QR
                </button>
                <c:if test="${errorSL==1}">
                    <div class="alert alert-danger d-flex" role="alert">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                             class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img"
                             aria-label="Warning:">
                            <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                        </svg>
                        <div>Số lượng sản phẩm còn lại không đủ</div>
                    </div>
                </c:if>
                <c:if test="${errorSL==2}">
                    <div class="alert alert-danger d-flex" role="alert">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                             class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img"
                             aria-label="Warning:">
                            <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                        </svg>
                        <div>Số lượng phải lớn hơn 0</div>
                    </div>
                </c:if>
                <table class="table">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Ảnh</th>
                        <th>Tên sản phẩm</th>
                        <th>Kiểu dáng</th>
                        <th>Màu sắc</th>
                        <th>Kích thước</th>
                        <th>Thương hiệu</th>
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
                            <td>${hdct.sanPhamCT.kdx.ten}</td>
                            <td>${hdct.sanPhamCT.ms.ten}</td>
                            <td>${hdct.sanPhamCT.kt.ten}</td>
                            <td>${hdct.sanPhamCT.th.ten}</td>
                            <td>${hdct.soLuong}</td>
                            <td>
                                <fmt:formatNumber type="number" value="${hdct.sanPhamCT.gia}"/>
                            </td>
                            <td>
                                <fmt:formatNumber type="number" value="${hdct.sanPhamCT.gia*hdct.soLuong}"/>
                            </td>
                            <td>
                                <button class="btn btn-success" data-bs-placement="bottom" data-bs-toggle2="suaSL"
                                        data-bs-toggle="modal"
                                        data-bs-target="#suaSL" data-bs-slSua="${hdct.soLuong}"
                                        data-bs-idHDCT="${hdct.id}" title="Sửa số lượng">
                                    <i class="bi bi-pencil-square"></i>
                                </button>
                                <!-- Modal -->
                                <div class="modal fade" id="suaSL" tabindex="-1" aria-labelledby="exampleModalLabel"
                                     aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="/hoa-don/sua-san-pham" method="post"
                                                      modelAttribute="hdct">
                                                    <input type="text" name="id" id="idSuaSL" class="form-control"
                                                           hidden>
                                                    <div class="input-group mb-3">
                                                        <input class="form-control" name="soLuong"
                                                               aria-describedby="button-suaSL"
                                                               id="slSua" type="number" placeholder="Nhập số lượng">
                                                        <button class="btn btn-outline-primary" type="submit"
                                                                id="button-suaSL">Sửa
                                                        </button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
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
            <c:if test="${listHD.size()>0}">
                <!--Thông tin thanh toán và khách hàng-->
                <h3>Thanh Toán</h3>
                <!--Thông tin thanh toán và khách hàng-->
                <div class="row">
                    <div class="col-md-7">
                        <button style="margin-bottom: 3px" type="submit" class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#themKH"><i
                                class="bi bi-search"></i>Khách Hàng
                        </button>
                    </div>
                    <div class="col-md-6">
                        <button type="submit" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#themVC"><i
                                class="bi bi-file-earmark-diff-fill"></i>Voucher
                        </button>
                    </div>
                    <div class="col-md-6">
                        <c:if test="${v!=null}">
                            <form action="/huy/voucher" method="get">
                                <button data-bs-toggle="tooltip" data-bs-placement="bottom" title="Hủy Voucher"
                                        type="submit" class="btn btn-danger"><i class="bi bi-x-square"></i> Hủy
                                </button>
                            </form>
                        </c:if>
                    </div>
                    <br>
                </div>
                <!--modal-->
                <div class="modal fade" id="themKH" data-bs-backdrop="static" tabindex="-1" aria-hidden="true">
                    <div class="modal-dialog modal-xl modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
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
                                            <td>${kh.trangThai==0? "Hoạt động" : "Không hoạt động"}</td>
                                            <td>
                                                <form action="/hoa-don/them-khach-hang" method="post">
                                                    <input name="KHID" value="${kh.idKhachHang}" hidden>
                                                    <button class="btn btn-warning" data-bs-toggle="tooltip"
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
                <td>
                    Mã Voucher : ${v.ma}<br>
                </td>
                <td>
                    Tên Khách Hàng: ${kh.hoTen}<br>
                </td>
                <td>
                    Email Khách Hàng: ${kh.email}<br>
                </td>
                <td>
                    SDT Khách Hàng: ${kh.sdt}<br>
                </td>
                <!--het modal-->
                <!--modal voucher-->
                <div class="modal fade" id="themVC" data-bs-backdrop="static" tabindex="-1" aria-hidden="true">
                    <div class="modal-dialog modal-xl modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="">
                                    <div class="input-group mb-3">
                                        <input type="text" class="form-control" placeholder="Nhập mã voucher"
                                               aria-describedby="button-addon4">
                                        <button class="btn btn-outline-secondary" type="button" id="button-addon4">Tìm
                                            kiếm
                                        </button>
                                    </div>
                                </form>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>STT</th>
                                        <th>Mã</th>
                                        <th>Giá Trị</th>
                                        <th>Số Lượng</th>
                                        <th>Ngày Bắt Đầu</th>
                                        <th>Ngày Kết Thúc</th>
                                        <th>Trạng Thái</th>
                                        <th>Hành động</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listV}" var="v" varStatus="stt">
                                        <tr>
                                            <td>${stt.index+1}</td>
                                            <td>${v.ma}</td>
                                            <td>Giảm ${v.giaTri}%</td>
                                            <td>${v.soLuong}</td>
                                            <td>${v.ngayBD}</td>
                                            <td>${v.ngayKT}</td>
                                            <td>${v.trangThai==0? "Hoạt động" : "Không hoạt động"}</td>
                                            <td>
                                                <form action="/hoa-don/them-voucher" method="post">
                                                    <input name="VCID" value="${v.id}" hidden>
                                                    <c:if test="${v.soLuong>0}">
                                                        <button class="btn btn-warning" data-bs-toggle="tooltip"
                                                                data-bs-placement="right"
                                                                title="Chọn">
                                                            <i class="bi bi-plus"></i>
                                                        </button>
                                                    </c:if>
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
                <!--het modal-->

                <label>Tạm Tính : <fmt:formatNumber type="number" value="${tamTinh}"/> VND</label><br>
                <input type="number" id="tamTinh" value="${tamTinh}" hidden>
                <label>Tổng Tiền : <fmt:formatNumber type="number" value="${tongTien}"/> VND</label><br>
                <input type="number" id="tongTien" value="${tongTien}" hidden>
                <label>
                    Tiền Khách Đưa: <input id="tienKhachDua" placeholder="Tiền Khách Cần Trả" type="number"
                                           name="tienKhachDua">
                </label><br>
                <label>
                    Tiền Trả Lại: <label id="tienTraLai"></label>
                </label><br>
                <div class="row">
                    <form class="col-md-7" action="/hoa-don/thanh-toan" method="post">
                        <input hidden value="${tamTinh}" name="tamTinh">
                        <input hidden value="${tongTien}" name="tongTien">
                        <button id="pay" type="submit" class="btn btn-success"><i
                                class="bi bi-wallet-fill"></i> Thanh Toán
                        </button>
                    </form>
                    <form class="col-md-5" action="/hoa-don/huy" method="post">
                        <input hidden value="${tamTinh}" name="tamTinh">
                        <button onclick="return confirm('Bạn Chắc Chắn Muốn Hủy?')" id="huy" type="submit"
                                class="btn btn-danger">
                            <i class="bi bi-x-square"></i>
                            Hủy
                        </button>
                    </form>
                </div>
            </c:if>
        </div>
        <%--        end thanh toan--%>
    </div>
</div>
<!-- Modal QR-->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Quét QR</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container">
                    <div class="section">
                        <div id="my-qr-reader">
                        </div>
                    </div>
                </div>
                <script src="https://unpkg.com/html5-qrcode"></script>
                <script type="text/javascript">
                    <%@include file="script.js" %>
                </script>
            </div>
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
                        <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Tìm kiếm</button>
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
                            <td>
                                <fmt:formatNumber type="number" value="${spct.gia}"/>
                            </td>
                            <td>${spct.moTa}</td>
                            <td>${spct.trangThai==0? "Hoạt động" : "Không hoạt động"}</td>
                            <td>
                                <form action="/hoa-don/them-san-pham" method="post">
                                    <input name="spctID" value="${spct.id}" hidden>
                                    <c:if test="${spct.soLuong>0}">
                                        <button class="btn btn-warning" data-bs-toggle="tooltip"
                                                data-bs-placement="right"
                                                title="Thêm vào giỏ hàng">
                                            <i class="bi bi-cart-plus"></i>
                                        </button>
                                    </c:if>
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
    var suaSLTrigger = [].slice.call(document.querySelectorAll('[data-bs-toggle2="suaSL"]'))
    var suaSL = suaSLTrigger.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl)
    })
    var exampleModal = document.getElementById('suaSL')
    if (exampleModal != null) {
        exampleModal.addEventListener('show.bs.modal', function (event) {
            var button = event.relatedTarget
            var slSua = button.getAttribute('data-bs-slSua')
            var idHDCT = button.getAttribute('data-bs-idHDCT')
            var slInput = exampleModal.querySelector('.modal-body #slSua')
            var idInput = exampleModal.querySelector('.modal-body #idSuaSL')
            slInput.value = slSua
            idInput.value = idHDCT
        })
    }
    document.getElementById('pay').addEventListener('click', function Pay() {
        const submitButton = document.getElementById('pay');
        const tienKhachDua = parseFloat(document.getElementById('tienKhachDua').value);
        const tongTien = parseFloat('${tongTien}');
        const tamTinh = parseFloat('${tamTinh}');
        if(tamTinh==0){
            event.preventDefault();
            alert("Vui Lòng Chọn Sản Phẩm");
        }else if (tienKhachDua >= tongTien) {
            submitButton.disabled = false;
            alert("Thanh Toán Thành Công");
        }else {
            event.preventDefault();
            alert("Vui Lòng Điền Đúng Số Tiền");
        }

    });
    const tienKhachDua = document.getElementById("tienKhachDua");
    const tienTraLai = document.getElementById("tienTraLai");
    const tongTien = document.getElementById("tongTien").value;
    tienKhachDua.addEventListener("input", () => {
        tienTraLai.innerHTML = new Intl.NumberFormat('vi-VN', {
            style: 'currency',
            currency: 'VND'
        }).format(tienKhachDua.value - tongTien);
    })
</script>
</body>
</html>