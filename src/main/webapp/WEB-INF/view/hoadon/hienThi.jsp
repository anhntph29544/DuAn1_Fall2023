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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script language="javascript" type="text/javascript">
        <%@include file="hoadon.js" %>
        var count = document.querySelectorAll('#hoa-don-cho').length;// Số lượng hóa đơn đã tạo

        // Hàm kiểm tra số lượng hóa đơn và ẩn nút tạo hóa đơn nếu đã đủ 5 hóa đơn
        function kiemTraSoLuongHoaDon() {
            if (count >= 5) {
                $('#tao-hoa-don').hide();// Ẩn nút tạo hóa đơn khi đã tạo đủ 5 hóa đơn
            } else {
                $('#tao-hoa-don').show();  // Hiển thị nút tạo hóa đơn nếu số lượng hóa đơn ít hơn 5
            }
            if (count <= 1) {
                $('#tao-hoa-don').show();  // Hiển thị nút tạo hóa đơn nếu số lượng hóa đơn ít hơn hoặc bằng 1
            }
        }

        // Hàm tạo hóa đơn
        function taoHoaDon() {
            count++;
            kiemTraSoLuongHoaDon(); // Gọi hàm kiểm tra số lượng hóa đơn sau khi tạo hóa đơn
        }

        // Gọi hàm kiểm tra số lượng hóa đơn sau khi tải lại trang
        window.onload = function () {

            kiemTraSoLuongHoaDon();
        }

        //xoa
        function prepareDelete(button) {
            let id = $(button).data('id'); // Lấy giá trị ID từ data attribute của nút
            ajaxDelete(id); // Gọi hàm ajaxDelete với ID vừa lấy được
        }

        $(".btn-info").on("click", function () {
            prepareDelete(this);
        });

        function ajaxDelete(id) {
            $.ajax({
                url: 'http://localhost:8080/hoa-don/delete/' + id,
                type: 'DELETE',
                success: function (response) {
                    // Xử lý kết quả sau khi xóa hóa đơn
                    alert("Xóa hóa đơn thành công");
                    // Cập nhật giao diện người dùng, ví dụ: ẩn hàng trong bảng
                    $("#xoa-hoa-don-" + id).closest("tr").remove(); // Ẩn hàng trong bảng chứa thông tin hóa đơn đã xóa
                    // count--; // Giảm số lượng hóa đơn
                    // kiemTraSoLuongHoaDon(); // Kiểm tra số lượng hóa đơn sau khi xóa hóa đơn
                },
                error: function (e) {
                    // Xử lý lỗi nếu có
                    alert("Lỗi khi xóa hóa đơn: " + e.responseText);
                    console.log("ERROR: ", e);
                }
            });
        }

        $("[id^=xoa-hoa-don]").submit(function (event) {
            // Ngăn form gửi đi thông qua trình duyệt.
            event.preventDefault();
            var id = this.id.split("-").pop(); // Lấy ID của hóa đơn cần xóa từ ID của form theo cú pháp "xoa-hoa-don-{id}"
            ajaxDelete(id);
            count--;
            kiemTraSoLuongHoaDon();
        });
        //hết hàm xóa
    </script>
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
                        <th>Mã HD</th>
                        <th>Tên NV</th>
                        <th>Tên KH</th>
                        <th>Trạng Thái</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody id="hoa-don-cho">
                    <c:forEach var="h" items="${listHD}">
                        <tr>
                            <td>${h.ma}</td>
                            <td>${h.nhanVien.hoTen}</td>
                            <td>${h.khachHang.hoTen}</td>
                            <td style="font-family: Roboto">${h.tinhTrang==0?"Chưa Thanh Toán":"Đã Thanh Toán"}</td>
                            <td>
                                <form id="xoa-hoa-don-${h.id}">

                                    <button data-id="${h.id}" type="button" onclick="prepareDelete(this)"
                                            class="btn btn-info">Hủy
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="gioHang" style="margin-top: 30px;border:#0b2e13 1px solid ">
                <table class="table">
                    <h5 style="display: inline-flex">Giỏ Hàng</h5>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#themSP">
                        <i class="bi bi-plus-lg"></i>
                    </button>

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
                </form:form>
                <form id="tao-hoa-don" onsubmit="taoHoaDon()">
                    <c:if test="${listHD.size()<5}">
                        <button class="btn btn-primary" type="submit">
                            Tạo Hóa Đơn
                        </button>
                    </c:if>
                </form>
                </table>
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
                        <input type="text" class="form-control" placeholder="Nhập mã sản phẩm" aria-describedby="button-addon2">
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
                                <a href="/hoa-don/them-san-pham">
                                    <button class="btn btn-warning" data-bs-toggle="tooltip" data-bs-placement="right"
                                            title="Thêm vào giỏ hàng">
                                        <i class="bi bi-cart-plus"></i>
                                    </button>
                                </a>
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