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
<f:form action="/shop-xe/thuong-hieu/add" method="post" modelAttribute="th1">
    ma: <f:input path="ma"/>
    <f:errors path="ma"/><br>
    ten: <f:input path="ten"/>
    <f:errors path="ten"/><br>
    trang thai: <f:radiobutton path="trangThai" value="0" checked="true"/>hoat dong
    <f:radiobutton path="trangThai" value="1"/>khong hoat dong <br>
    <f:button type="submit">add</f:button>
</f:form>
<form>
    <input type="text" name="ten">
    <a href="/shop-xe/thuong-hieu/hien-thi"><button>tim kiem</button></a>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">ma</th>
        <th scope="col">ten</th>
        <th scope="col">trang thai</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list.content}" var="th" varStatus="stt">
        <tr>
            <th scope="row">${stt.index+1}</th>
            <td>${th.ma}</td>
            <td>${th.ten}</td>
            <td>${th.trangThai}</td>
            <td>
                <a href="/shop-xe/thuong-hieu/view-update/${th.id}">
                    <button>update</button>
                </a>
                <a href="/shop-xe/thuong-hieu/detail/${th.id}">
                    <button>detail</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${list.totalPages-1<0?0:list.totalPages-1}" varStatus="loop">
            <li class="page-item"><a class="page-link"
                                     href="/shop-xe/thuong-hieu/hien-thi?page=${loop.index}">${loop.index+1}</a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>