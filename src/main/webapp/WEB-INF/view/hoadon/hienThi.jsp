<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
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
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script language="javascript" type="text/javascript">
        <%@include file="hoadon.js" %>
    </script>
</head>
<body>
<div class="container ">
    <div class="hoaDon row">
        <div class="col-md-8">
            <div class="bangHoaDon" style="margin-bottom: 30px;border:#0b2e13 1px solid ">
                <table class="table">
                    <h5>Danh Sách Hóa Đơn</h5>
                    <form id="tao-hoa-don">
                        <c:if test="${listHD.size()<5}">
                        <button type="submit">
                            Tạo Hóa Đơn
                        </button>
                        </c:if>
                    </form>
                    <thead>
                    <tr>
                        <th>Mã HD</th>
                        <th>Tên NV</th>
                        <th>Tên KH</th>
                        <th>Trạng Thái</th>
                    </tr>
                    </thead>
                    <tbody id="hoa-don-cho">
                    <c:forEach  var="h" items="${listHD}">
                        <tr>
                            <td>${h.ma}</td>
                            <td>${h.nhanVien.hoTen}</td>
                            <td>${h.khachHang.hoTen}</td>
                            <td style="font-family: Roboto">${h.tinhTrang==0?"Chưa Thanh Toán":"Đã Thanh Toán"}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="gioHang" style="margin-top: 30px;border:#0b2e13 1px solid ">
                <table class="table">
                    <h5>Giỏ Hàng</h5>
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Mã SP</th>
                        <th>Tên SP</th>
                        <th>Số Lượng</th>
                        <th>Đơn Giá</th>
                        <th>Giảm Giá</th>
                        <th>Thành Tiển</th>
                        <th>Trạng Thái</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>


        <div class="col-md-4">
            <div class="taoHoaDon" style="padding: 5px;border:#0b2e13 1px solid ">
                <h5>Tạo Hóa Đơn</h5>
                <%--                <div>--%>
                <%--                    <input type="text" name="emailSearch" class="form-control me-2"--%>
                <%--                           placeholder="Nhập sdt/email khách hàng"--%>
                <%--                           value="${emailSearch}">--%>
                <%--                    <button type="submit" class="btn btn-primary"><i class="bi bi-search"></i>Tìm Kiếm</button>--%>
                <%--                </div>--%>
                <button type="submit" class="btn btn-primary"><i class="bi bi-search"></i>Chọn Khách Hàng</button>
                <label>
                    Tên Khách Hàng:<input type="text"><br>
                    SDT Khách Hàng:<input type="text"><br>
                    Email Khách Hàng:<input type="text"><br>
                </label>

                <form:form modelAttribute="hd" method="post" action="/hoa-don/add">
                    Tổng Tiền:<br>
                    Khách Cần Trả:<form:input path="thanhTien"/><br>
                    Tiền Khách Đưa:<br>
                    Tiền Thừa:<br>
                    <form:button class="btn btn-primary" type="submit">Tạo Hóa Đơn</form:button>
                </form:form>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>