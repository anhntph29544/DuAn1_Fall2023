<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script language="javascript" type="text/javascript">
        <%@include file="hoadon.js" %>

    </script>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<div class="container ">
    <div class="hoaDon ">
        <div class="bangHoaDon">
            <h5>Danh Sách Hóa Đơn</h5>
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/hoa-don/hien-thi">Tất Cả</a>

                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/hoa-don/hien-thi/dtt">Đã Thanh Toán</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/hoa-don/hien-thi/dh">Đã Hủy</a>
                </li>
            </ul>
            <div>
                <table class="table">
                    <thead>
                    <tr>
                        <th>Mã HD</th>
                        <th>Tên NV</th>
                        <th>Tên KH</th>
                        <th>Trạng Thái</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <c:forEach var="h" items="${listHD}">
                        <tr>
                            <td>${h.ma}</td>
                            <td>${h.nhanVien.hoTen}</td>
                            <td>${h.khachHang.hoTen}</td>
                            <td>${h.tinhTrang==0?"Chưa Thanh Toán":h.tinhTrang==1?"Đã Thanh Toán":"Đã Hủy"}</td>
                            <td>
                                <a href="/chi-tiet/id=${h.id}">
                                    <button class="btn btn-primary"><i class="bi bi-eye-fill"></i></button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>


</body>
</html>