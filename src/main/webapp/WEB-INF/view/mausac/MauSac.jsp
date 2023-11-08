<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/shop-xe/mau-sac/hien-thi">
    <input type="text" name="tenSearch" placeholder="Search" value="${tenSearch}">
    <button type="submit">Search</button>
</form>
<table>
    <form:form method="post" action="/shop-xe/mau-sac/add" modelAttribute="m1">
        Mã:<form:input path="ma"/><br>
        Tên:<form:input path="ten"/><br>
        Trạng Thái:<form:radiobutton path="trangThai" value="1" checked="1"/>Hoạt Động
        <form:radiobutton path="trangThai" value="0"/>Không Hoạt Động</br>
        <form:button type="submit">ADD</form:button>
    </form:form>
</table>
<a href="/shop-xe/mau-sac/hien-thi">
    <button>Hiển thị tất cả</button>
</a>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Trạng Thái</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="m" items="${listM.content}" varStatus="d">
        <tr>
            <td>${d.index+1}</td>
            <td>${m.ma}</td>
            <td>${m.ten}</td>
            <td>${m.trangThai==1?"Hoạt Động":"Không Hoạt Động"}</td>
            <td>
                <a href="/shop-xe/mau-sac/detail/${m.id}">
                    <button>Detail</button>
                </a>
                <a href="/shop-xe/mau-sac/view-update/${m.id}">
                    <button>Update</button>
                </a>
                <a href="/shop-xe/mau-sac/delete/${m.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${listM.totalPages-1<0?0:listM.totalPages-1}" varStatus="loop">
            <c:if test="${listM.totalPages-1>=0}">
                <li class="page-item">
                    <c:if test="${tenSearch!=''}">
                        <a class="page-link"
                           href="/shop-xe/mau-sac/hien-thi?tenSearch=${tenSearch}&page=${loop.index}">
                                ${loop.index+1}
                        </a>
                    </c:if>
                    <c:if test="${tenSearch==''}">
                        <a class="page-link"
                           href="/shop-xe/mau-sac/hien-thi?page=${loop.index}">
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