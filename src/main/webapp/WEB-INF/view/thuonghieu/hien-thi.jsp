<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý Thương hiệu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/1.11.6/css/dataTables.bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Quản lý Thương hiệu</h1>
    <form:form action="/thuong-hieu/add" modelAttribute="thuongHieu" method="post">
        <div class="form-group">
            <label for="ma">Mã:</label>
            <form:input path="ma" id="ma" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="ten">Tên:</label>
            <form:input path="ten" id="ten" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng thái:</label><br>
            <input type="radio" id="hoatDong" name="trangThai" value="0" checked="true"/>
            <label for="hoatDong">Hoạt động</label>
            <input type="radio" id="khongHoatDong" name="trangThai" value="1"/>
            <label for="khongHoatDong">Không hoạt động</label>
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
    </form:form>
    <table class="table table-hover table-bordered" id="sampleTable">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="thuongHieu">
            <tr>
                <td>${thuongHieu.id}</td>
                <td>${thuongHieu.ma}</td>
                <td>${thuongHieu.ten}</td>
                <td>${thuongHieu.trangThai == 0 ? 'Hoạt động' : 'Không hoạt động'}</td>
                <td>
                    <a href="/thuong-hieu/delete/${thuongHieu.id}" class="btn btn-danger">Xóa</a>
                    <a href="/thuong-hieu/detail/${thuongHieu.id}" class="btn btn-info">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
