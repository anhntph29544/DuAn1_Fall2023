<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            padding-top: 10px;
        }

        h3 {
            margin-bottom: 20px;
        }

        button {
            margin-bottom: 20px;
        }

        .table {
            width: 100%;
            margin-bottom: 1rem;
            color: #212529;
            border-collapse: collapse;
            border-spacing: 0;
        }

        .table th, .table td {
            padding: 0.75rem;
            vertical-align: top;
            border-top: 1px solid #dee2e6;
        }

        .table th {
            text-align: center;
        }

        .table img {
            max-width: 50px;
            max-height: 50px;
            border-radius: 50%;
        }

        .table-td-center {
            text-align: center;
        }

        .btn-sm {
            padding: 0.25rem 0.5rem;
            font-size: 0.875rem;
            line-height: 1.5;
            border-radius: 0.2rem;
        }
             /* Để làm nhỏ ô input */
         .search-input {
             max-width: 200px;
         }
    </style>
</head>
<body style="padding-top: 10px" class="text-center">
<div class="container">
<h3>Quản lý khách hàng</h3>
    <div class="d-flex justify-content-between mb-3 align-items-center">
        <!-- Nút thêm mới khách hàng -->
        <a href="/khach-hang/showFormForAdd" class="btn btn-primary">Thêm mới khách hàng</a>



        <!-- Ô input và nút tìm kiếm -->
        <f:form action="/khach-hang/search" method="post">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai"  value="0">
                <label class="form-check-label" >Hoạt động</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai"  value="1">
                <label class="form-check-label" >Không hoạt động</label>
            </div>

            <div class="row">
            <div class="control-group col-md-8">
                <input type="text" class="form-control" placeholder="Tìm kiếm khách hàng..." name="keyword">
            </div>
                <div class="control-group col-md-4">
                    <button class="btn btn-success" type="submit">Tìm kiếm</button>
                </div>

            </div>
        </f:form>
    </div>
<table class="table">
    <thead>
    <tr>
        <th width="20">STT</th>
        <th width="50">Ảnh thẻ</th>
        <th >Mã KH</th>
        <th >email</th>
        <th >Họ và tên</th>
        <th >Ngày sinh</th>
        <th >Giới Tính</th>
        <th >SĐT</th>
        <th >Trạng Thái</th>
        <th >Thao Tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="kh" varStatus="status">
        <tr>
            <td>${num*sizePage + status.index + 1}</td>
            <td>
                <img src="${kh.image}" />
            </td>
            <td>${kh.ma}</td>
            <td>${kh.email}</td>
            <td>${kh.hoTen}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.gioiTinh == 0 ? 'nam' : 'nữ'}</td>
            <td>${kh.sdt}</td>
            <td>${kh.trangThai == 0 ? 'Hoạt động' : 'Dừng hoạt động'}</td>
            <td class="table-td-center">
                <a href="/khach-hang/delete/${kh.idKhachHang}" class="btn btn-primary btn-sm trash"
                   type="button" title="Xóa" onclick="if (!(confirm('Bạn có muốn xóa khách hàng này không?'))) return false">
                    <label>Xóa</label>
                </a>
                <a href="/khach-hang/detail/${kh.idKhachHang}" class="btn btn-primary btn-sm edit"
                   type="button" title="Sửa" onclick="if (!(confirm('Bạn có muốn sửa khách hàng này không?'))) return false">
                    <label>Detail</label>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <div>
        <c:forEach begin="1" end="${total}" varStatus="stt">
            <a> <a href="/khach-hang/hien-thi?num=${stt.index-1}"> ${stt.index-1}</a> </a>
        </c:forEach>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>