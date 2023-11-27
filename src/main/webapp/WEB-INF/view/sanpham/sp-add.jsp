<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <script>
        function goBack() {
            window.history.back()
        }
    </script>
</head>
<body>
<%@include file="../include/header.jsp"%>
<div style="padding: 20px">
    <div style="text-align: center">
        <h3>THÊM SẢN PHẨM</h3>
    </div>
    <form:form class="col-md-5" style="margin: auto" action="/shop-xe/san-pham/add" modelAttribute="sp1" method="post">
        <div class="mb-3">
            <label class="col-form-label">Tên</label>
            <form:input path="ten" type="text" class="form-control"/><br>
            <div class="form-text"><form:errors path="ten"/></div>
            <div class="form-text" ${tenError==null?"hidden":""}>
                    ${tenError}
            </div>
        </div>
        <label class="form-label">Trạng thái</label>
        <div class="mb-3 form-check">
            <form:radiobutton path="trangThai" class="form-check-input" value="0"
                              id="trangThaiSP1"
                              checked="true"/>
            <label class="form-check-label" for="trangThaiSP1">Hoạt động</label>
        </div>
        <div class="mb-3 form-check">
            <form:radiobutton path="trangThai" class="form-check-input" value="1"
                              id="trangThaiSP2"/>
            <label class="form-check-label" for="trangThaiSP2">Không hoạt động</label>
        </div>
        <form:button type="submit" class="btn btn-primary"
                     onclick="return confirm('Bạn có chắc không?')">Thêm</form:button>
    </form:form>
    <button onclick="goBack()" class="btn btn-danger">Quay lại</button>
</div>
</body>
</html>