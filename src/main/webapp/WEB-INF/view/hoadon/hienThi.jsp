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
</head>
<body>
<div class="container ">
    <div class="hoaDon row">
        <div class="col-md-8">
            <div class="bangHoaDon" style="margin-bottom: 30px;border:#0b2e13 1px solid ">
                <table class="table">
                    <h5>Danh Sách Hóa Đơn</h5>
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Mã HD</th>
                        <th>Tên NV</th>
                        <th>Tên KH</th>
                        <th>Trạng Thái</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach varStatus="d" var="h" items="${listHD}">
                        <tr>
                            <td>${d.index+1}</td>
                            <td>${h.ma}</td>
                            <td>${h.nhanVien.hoTen}</td>
                            <td>${h.khachHang.hoTen}</td>
                            <td>${h.tinhTrang}</td>
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
                <form:form modelAttribute="hd" method="post" action="add/hoa-don">
                    Tên KH :<form:input path="khachHang.hoTen"/><br>
                    SDT :<form:input path="khachHang.sdt"/><br>
                    Địa Chỉ:<form:input path="khachHang.thanhPho"/><br>
                    Tổng Tiền:<br>
                    Khách Cần Trả:<form:input path="thanhTien"/><br>
                    Tiền Khách Đưa:<br>
                    Tiền Thừa:<br>
                    <form:button type="submit">Tạo Hóa Đơn</form:button>
                </form:form>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>