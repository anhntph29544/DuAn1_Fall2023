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
</head>
<body>
<form:form action="/ghi-dong/add" modelAttribute="gd1" method="post">
    Mã: <form:input path="ma"/><br>
    Tên: <form:input path="ten"/><br>
    Trạng thái:
    <form:radiobutton path="trangThai" value="0" checked="true"/>Hoạt động
    <form:radiobutton path="trangThai" value="1"/>Không hoạt động<br>
    <form:button type="submit">Add</form:button>
</form:form>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Trạng thái</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listGD}" var="gd">
        <tr>
            <td>${gd.id}</td>
            <td>${gd.ma}</td>
            <td>${gd.ten}</td>
            <td>${gd.trangThai==0?"Hoạt động":"Không hoạt động"}</td>
            <td>
                <a href="/ghi-dong/detail/${gd.id}">
                    <button>Detail</button>
                </a>
                <a href="/ghi-dong/view-update/${gd.id}">
                    <button>Update</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>