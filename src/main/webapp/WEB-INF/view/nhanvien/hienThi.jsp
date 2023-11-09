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
</head>
<body style="padding-top: 10px">
<h3>Quản lý thương hiệu</h3>
<a href="/nhan-vien/showFormAdd"><button>Thêm mới nhân viên</button></a>
<table class="table">
    <thead>
    <tr>
        <th width="20">STT</th>
        <th width="20">Ảnh thẻ</th>
        <th width="20">Mã NV</th>
        <th width="100">email</th>
        <th width="150">Họ và tên</th>
        <th width="150">Ngày sinh</th>
        <th width="150">Giới Tính</th>
        <th>Chức vụ</th>
        <th width="150">SĐT</th>
        <th width="100">Trạng Thái</th>
        <th width="100">Thao Tác</th>
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
            <td>${nv.trangThai == 0 ? 'Làm viêc' : 'Nghỉ việc'}</td>
            <td class="table-td-center">
                <a href="/nhan-vien/delete/${nv.idNhanVien}" class="btn btn-primary btn-sm trash"
                   type="button" title="Xóa" onclick="if (!(confirm('Bạn có muốn xóa nhân viên này không?'))) return false">
                    <i class="fas fa-trash-alt"></i>
                </a>
                <a href="/nhan-vien/detail/${nv.idNhanVien}" class="btn btn-primary btn-sm edit"
                   type="button" title="Sửa" onclick="if (!(confirm('Bạn có muốn sửa nhân viên này không?'))) return false">
                    <i class="fas fa-edit"></i>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>