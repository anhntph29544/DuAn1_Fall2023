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
<form action="/shop-xe/san-pham/hien-thi">
    <input type="text" name="tenSearch" placeholder="Search" value="${tenSearch}">
    <button type="submit">Search</button>
</form>
<form:form action="/shop-xe/san-pham/add" modelAttribute="sp1" method="post">
    Mã: <form:input path="ma"/><br>
    Tên: <form:input path="ten"/><br>
    Trạng thái:
    <form:radiobutton path="trangThai" value="0" checked="true"/>Hoạt động
    <form:radiobutton path="trangThai" value="1"/>Không hoạt động<br>
    <form:button type="submit">Add</form:button>
</form:form>
<a href="/shop-xe/san-pham/hien-thi">
    <button>Hiển thị tất cả</button>
</a>
<table class="table">
    <thead>
    <tr>
        <th>Mã</th>
        <th>Tên</th>
        <th>Trạng thái</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSP.content}" var="sp">
        <tr>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>${sp.trangThai==0?"Hoạt động":"Không hoạt động"}</td>
            <td>
                <a href="/shop-xe/san-pham/detail/${sp.id}">
                    <button>Detail</button>
                </a>
                <a href="/shop-xe/san-pham/view-update/${sp.id}">
                    <button>Update</button>
                </a>
                <a href="/shop-xe/san-pham/delete/${sp.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${listSP.totalPages-1<0?0:listSP.totalPages-1}" varStatus="loop">
            <c:if test="${listSP.totalPages-1>=0}">
                <li class="page-item">
                    <c:if test="${tenSearch!=''}">
                        <a class="page-link"
                           href="/shop-xe/san-pham/hien-thi?tenSearch=${tenSearch}&page=${loop.index}">
                                ${loop.index+1}
                        </a>
                    </c:if>
                    <c:if test="${tenSearch==''}">
                        <a class="page-link"
                           href="/shop-xe/san-pham/hien-thi?page=${loop.index}">
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