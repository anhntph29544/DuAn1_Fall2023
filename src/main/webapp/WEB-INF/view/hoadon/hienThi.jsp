<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <div class="row">
                <div class="col-md-6" style="border: 1px solid black;padding: 10px;">
                    <form action="/hoa-don/hien-thi" class="row">
                        <div class="col-md-6">
                            <label>Ngày Bắt Đầu</label>
                            <input type="date" name="ngayBD" class="form-control me-2" placeholder="Nhập ngày bắt đầu"
                                   value="${ngayBD}">
                            <label>Ngày Kết Thúc</label>
                            <input type="date" name="ngayKT" class="form-control me-2" placeholder="Nhập ngày kết thúc"
                                   value="${ngayKT}">
                        </div>
                        <div class="col-md-6">
                            <label>Trạng thái </label>
                            <select name="trangThai" class="form-select">
                                <option value="3" ${trangThai==3?"selected":""}></option>
                                <option value="2" ${trangThai==2?"selected":""}>Đã Hủy</option>
                                <option value="0" ${trangThai==0?"selected":""}>Chưa Thanh Toán</option>
                                <option value="1" ${trangThai==1?"selected":""}>Đã THanh Toán</option>
                            </select>
                        </div>
                        <div class="col-md-12" style="padding-top: 10px">
                            <button type="submit" class="btn btn-primary"><i class="bi bi-search"></i> Tìm kiếm</button>
                        </div>
                    </form>
                </div>

                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/hoa-don/hien-thi">Tất Cả</a>

                    </li>
                </ul>
                <div>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>STT</th>
                            <th>Mã HD</th>
                            <th>SDT</th>
                            <th>Tên KH</th>
                            <th>Tạm Tính</th>
                            <th>Tổng Tiền</th>
                            <th>Ngày Tạo</th>
                            <th>Ngày Thanh Toán</th>
                            <th>Trạng Thái</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <c:forEach var="h" items="${listHD.content}" varStatus="d">
                            <tr>
                                <td>${d.index+1}</td>
                                <td>${h.ma}</td>
                                <td>${h.khachHang.sdt}</td>
                                <td>${h.khachHang.hoTen}</td>
                                <td><fmt:formatNumber type="number" value="${h.thanhTien}"/>VND</td>
                                <td><fmt:formatNumber type="number" value="${h.tongTien}"/>VND</td>
                                <td>${h.ngayThem}</td>
                                <td>${h.ngayThanhToan}</td>
                                <td>${h.tinhTrang==0?"Chưa Thanh Toán":h.tinhTrang==1?"Đã Thanh Toán":"Đã Hủy"}</td>
                                <td>
                                    <a href="/hoa-don/detail/${h.id}">
                                        <button class="btn btn-dark"><i class="bi bi-eye-fill"></i></button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <c:forEach begin="0" end="${listHD.totalPages-1<0?0:listHD.totalPages-1}" varStatus="loop">
                                <c:if test="${listHD.totalPages-1>=0}">
                                    <li class="page-item">
                                        <c:if test="${ngayBD!=''||ngayKT!=''}">
                                            <a class="page-link"
                                               href="/hoa-don/hien-thi?ngayBD=${ngayBD}&ngayKT=${ngayKT}&trangThai=${trangThai}&page=${loop.index}">
                                                    ${loop.index+1}
                                            </a>
                                        </c:if>
                                        <c:if test="${ngayBD==''||ngayKT==''}">
                                            <a class="page-link"
                                               href="/hoa-don/hien-thi?page=${loop.index}">
                                                    ${loop.index+1}
                                            </a>
                                        </c:if>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </nav>

                </div>
            </div>
        </div>
    </div>

</body>
</html>