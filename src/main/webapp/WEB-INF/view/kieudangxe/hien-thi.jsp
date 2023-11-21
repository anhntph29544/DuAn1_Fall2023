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
<body>
<%@include file="../include/header.jsp"%>
<h3 STYLE="text-align: center">QUẢN LÝ KIỂU DÁNG</h3>
<f:form action="/shop-xe/kieu-dang-xe/add" method="post" modelAttribute="kdx1">
    ma: <f:input path="ma"/>
    <f:errors path="ma"/><br>
    ten: <f:input path="ten"/>
    <f:errors path="ten"/><br>
    trang thai: <f:radiobutton path="trangThai" value="0" checked="true"/>hoat dong
    <f:radiobutton path="trangThai" value="1"/>khong hoat dong <br>
    <f:button type="submit" class="btn btn-primary">add</f:button>
</f:form>
<form action="/shop-xe/kieu-dang-xe/hien-thi">
    <input type="text" name="tenSearch" value="${tenSearch}">
    <button type="submit" class="btn btn-primary">Tìm Kiếm</button>
</form>
<a href="/shop-xe/kieu-dang-xe/hien-thi"><button class="btn btn-primary">hiển thị tất cả</button></a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Trạng Thái</th>
        <th scope="col">Hành Động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listkdx.content}" var="kdx1" varStatus="stt">
        <tr>
            <th scope="row">${stt.index+1}</th>
            <td>${kdx1.ma}</td>
            <td>${kdx1.ten}</td>
            <td>${kdx1.trangThai==0?"hoạt động":"không hoạt động"}}</td>
            <td>
                <a href="/shop-xe/kieu-dang-xe/view-update/${kdx1.id}">
                    <button class="btn btn-warning">sửa</button>
                </a>
                <a href="/shop-xe/kieu-dang-xe/detail/${kdx1.id}">
                    <button class="btn btn-success">chi tiết</button>
                </a>
<%--                <a href="/shop-xe/kieu-dang-xe/delete/${kdx1.id}">--%>
<%--                    <button class="btn btn-danger">delete</button>--%>
<%--                </a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${listkdx.totalPages-1<0?0:listkdx.totalPages-1}" varStatus="loop">
            <li class="page-item"><a class="page-link"
                                     href="/shop-xe/kieu-dang-xe/hien-thi?tenSearch=${tenSearch}&page=${loop.index}">${loop.index+1}</a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>