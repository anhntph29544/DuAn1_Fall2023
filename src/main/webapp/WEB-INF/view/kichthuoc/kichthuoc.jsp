<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h3 STYLE="text-align: center">QUẢN LÝ KÍCH THƯỚC</h3>
<form action="/shop-xe/kich-thuoc/hien-thi">
    <input type="text" name="tenSearch" placeholder="Search" value="${tenSearch}">
    <button type="submit" class="btn btn-primary">Tìm kiếm</button>
</form>
<br>
<form:form action="/shop-xe/kich-thuoc/add" method="post" modelAttribute="kt1">
    Mã: <form:input path="ma" disabled="true"/>
    <br/>
    Tên: <form:input path="ten"/>
    <br>
    Trạng Thái:
    <form:radiobutton path="trangThai" value="0" checked="true"/>Hoạt động
    <form:radiobutton path="trangThai" value="1"/>Không hoạt động
    <br>
    <form:button type="submit" class="btn btn-primary">Thêm</form:button>
</form:form><br>
<a href="/shop-xe/kich-thuoc/hien-thi">
    <button class="btn btn-primary">Hiển thị tất cả</button>
</a>
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
    <c:forEach items="${listKT.content}" var="kt" varStatus="stt">
        <tr>
            <th scope="row">${stt.index+1}</th>
            <td>${kt.ma}</td>
            <td>${kt.ten}</td>
            <td>${kt.trangThai==0?"hoạt động":"không hoạt động"}</td>
            <td>
                <a href="/shop-xe/kich-thuoc/view-update/${kt.id}">
                    <button class="btn btn-warning">sửa</button>
                </a>
                <a href="/shop-xe/kich-thuoc/detail/${kt.id}">
                    <button class="btn btn-success">chi tiết</button>
                </a>
<%--                <a href="/shop-xe/kich-thuoc/delete/${kt.id}">--%>
<%--                    <button class="btn btn-danger">delete</button>--%>
<%--                </a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${listKT.totalPages-1<0?0:listKT.totalPages-1}" varStatus="loop">
            <c:if test="${listKT.totalPages-1>=0}">
                <li class="page-item">
                    <c:if test="${tenSearch!=''}">
                        <a class="page-link"
                           href="/shop-xe/kich-thuoc/hien-thi?tenSearch=${tenSearch}&page=${loop.index}">
                                ${loop.index+1}
                        </a>
                    </c:if>
                    <c:if test="${tenSearch==''}">
                        <a class="page-link"
                           href="/shop-xe/kich-thuoc/hien-thi?page=${loop.index}">
                                ${loop.index+1}
                        </a>
                    </c:if>
                </li>
            </c:if>
        </c:forEach>
    </ul>
</nav>
</body>
</html>