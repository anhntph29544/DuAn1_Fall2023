<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>
        function goBack() {
            window.history.back()
        }
    </script>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<div class="container">
    <form:form modelAttribute="h1" action="/hoa-don/detail" method="post">
    <div class="ttkh ">
        <h3>Thông Tin Hóa Đơn</h3>
        <h5>Nhân Viên Xác Nhận : ${h1.nhanVien.hoTen}</h5>
        <div class="">
            <table class="table">
                <thead>
                <div class="row">
                    <tr>
                        <div class="col-md-2">
                            <th>Mã Đơn Hàng</th>
                        </div>
                        <div class="col-md-2">
                            <th>Khách Hàng</th>
                        </div>
                        <div class="col-md-2">
                            <th>Số Điện Thoại</th>
                        </div>
                        <div class="col-md-3">
                            <th>Địa Chỉ</th>
                        </div>
                        <div class="col-md-3">
                            <th>Voucher Sử Dụng</th>
                        </div>
                    </tr>
                </div>
                </thead>
                <tbody>
                <tr>
                    <td class="col-md-2 ">${h1.ma}</td>
                    <td class="col-md-2 ">${h1.khachHang.hoTen}</td>
                    <td class="col-md-2 ">${h1.khachHang.sdt}</td>
                    <td class="col-md-3 ">${h1.khachHang.thanhPho}</td>
                    <td class="col-md-3 ">${h1.voucher.ma} : ${h1.voucher.giaTri}%</td>
                </tr>
                </tbody>
            </table>
            <div class="hoa-don2 row">
                <table class="table">
                    <thead>
                    <div class="row">
                        <tr>
                            <div class="col-md-2">
                                <th>Tạm Tính</th>
                            </div>
                            <div class="col-md-2">
                                <th>Tổng Tiền</th>
                            </div>
                            <div class="col-md-2">
                                <th>Trạng Thái</th>
                            </div>
                            <div class="col-md-3">
                                <th>Ngày Tạo</th>
                            </div>
                            <div class="col-md-3">
                                <th>Ngày Thanh Toán</th>
                            </div>
                        </tr>
                    </div>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="col-md-2"><fmt:formatNumber type="number" value="${h1.thanhTien}"/></td>
                        <td class="col-md-2"><fmt:formatNumber type="number" value="${h1.tongTien}"/></td>
                        <td class="col-md-2 ">${h1.tinhTrang==0?"Chưa Thanh Toán":h1.tinhTrang==1?"Đã Thanh Toán":"Đã Hủy"}</td>
                        <td class="col-md-3 ">${h1.ngayThem}</td>
                        <td class="col-md-3">${h1.ngayThanhToan}</td>

                    </tr>
                    </tbody>
                </table>
            </div>

        </div>
        <!--sanpham-->
        <div class="ttkh row">
            <table class="table">
                <h3>Danh Sách Sản Phẩm</h3>
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Ảnh</th>
                    <th>Sản Phẩm</th>
                    <th>Số Lượng</th>
                    <th>
                        <Thành></Thành>
                        Tiền
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="hdct1" items="${listHDCT1}" varStatus="t">
                    <tr>
                        <td>${t.index+1}</td>
                        <td>
                            <img src='<c:url value="/getimage/${hdct1.sanPhamCT.hinhAnh}"></c:url>'
                                 style="max-width: 100px">
                        </td>
                        <td>${hdct1.sanPhamCT.sp.ten} ${hdct1.sanPhamCT.kt.ten} ${hdct1.sanPhamCT.ms.ten} ${hdct1.sanPhamCT.kdx.ten}<br>
                            <fmt:formatNumber type="number" value="${hdct1.sanPhamCT.gia}"/>
                        </td>
                        <td>
                                ${hdct1.soLuong}
                        </td>
                        <td>
                            <fmt:formatNumber type="number" value="${hdct1.sanPhamCT.gia*hdct1.soLuong}"/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </form:form>
    </div>
    <button onclick="goBack()" class="btn btn-danger">Quay lại</button>
</body>
</html>