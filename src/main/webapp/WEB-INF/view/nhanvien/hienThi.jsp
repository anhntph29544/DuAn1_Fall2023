<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý nhân viên</title>
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
<body style=" padding-top: 10px" class="text-center">
<jsp:include page="../include/header.jsp"/>

<div class="container">
    <h3>Quản lý Nhân Viên</h3>
    <div class="d-flex justify-content-between mb-3 align-items-center">
        <!-- Nút thêm mới khách hàng -->
        <a href="/nhan-vien/showFormForAdd" class="btn btn-primary">Thêm mới nhân viên</a>



        <!-- Ô input và nút tìm kiếm -->
        <f:form action="/nhan-vien/search" method="post">
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
                    <input type="text" class="form-control" placeholder="Tìm kiếm nhân viên..." name="keyword">
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
            <th width="20">Ảnh thẻ</th>
            <th >Mã NV</th>
            <th >email</th>
            <th >Họ và tên</th>
            <th >Ngày sinh</th>
            <th >Giới Tính</th>
            <th>Chức vụ</th>
            <th >SĐT</th>
            <th >Trạng Thái</th>
            <th >Thao Tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="nv" varStatus="status">
            <tr>
                <td>${num*sizePage + status.index + 1}</td>
                <td>
                    <img src="${nv.image}" />
                </td>
                <td>${nv.ma}</td>
                <td>${nv.email}</td>
                <td>${nv.hoTen}</td>
                <td>${nv.ngaySinh}</td>
                <td>${nv.gioiTinh == 0 ? 'nam' : 'nữ'}</td>
                <td>${nv.chucVu.tenChucVu}</td>
                <td>${nv.sdt}</td>
                <td>${nv.trangThai == 0 ? 'Hoạt động' : 'Dừng hoạt động'}</td>
                <td class="table-td-center">
                    <a href="/nhan-vien/delete/${nv.idNhanVien}" class="btn btn-primary btn-sm trash"
                       type="button" title="Xóa" onclick="if (!(confirm('Bạn có muốn xóa nhân viên này không?'))) return false">
                        <label> Xóa</label>
                    </a>
                    <a href="/nhan-vien/detail/${nv.idNhanVien}" class="btn btn-primary btn-sm edit"
                       type="button" title="Sửa" onclick="if (!(confirm('Bạn có muốn sửa nhân viên này không?'))) return false">
                        <label> Xem</label>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <c:forEach begin="1" end="${total}" varStatus="stt">
            <a> <a href="/nhan-vien/hien-thi?num=${stt.index-1}"> ${stt.index-1}</a> </a>
        </c:forEach>
    </div>
</div>
</body>
</html>