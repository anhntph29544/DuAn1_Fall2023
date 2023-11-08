<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật Hình ảnh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Cập nhật Hình ảnh</h1>
    <form:form action="/hinh-anh/update/${object.id}" modelAttribute="object" method="post" class="mb-4">
        <div class="form-group">
            <label for="ten">Tên:</label>
            <form:input path="ten" id="ten" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="duongDan">Đường dẫn:</label>
            <form:input path="duongDan" id="duongDan" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="macDinh">Mặc định:</label>
            <form:input path="macDinh" id="macDinh" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng thái:</label><br>
            <input type="radio" id="hoatDong" name="trangThai" value="0" checked="true"/>
            <label for="hoatDong">Hoạt động</label>
            <input type="radio" id="khongHoatDong" name="trangThai" value="1"/>
            <label for="khongHoatDong">Không hoạt động</label>
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật</button>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
