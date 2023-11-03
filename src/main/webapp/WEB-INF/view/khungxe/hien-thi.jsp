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
<f:form action="/shop-xe/khung-xe/add" method="post" modelAttribute="kx1">
    ma: <f:input path="ma"/>
    <f:errors path="ma"/><br>
    ten: <f:input path="ten"/>
    <f:errors path="ten"/><br>
    trang thai: <f:radiobutton path="trangThai" value="0" checked="true"/>hoat dong
    <f:radiobutton path="trangThai" value="1"/>khong hoat dong <br>
    <f:button type="submit">add</f:button>
</f:form>
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
    <c:forEach items="${listKX}" var="kx" varStatus="stt">
        <tr>
            <th scope="row">${stt.index+1}</th>
            <td>${kx.ma}</td>
            <td>${kx.ten}</td>
            <td>${kx.trangThai}</td>
            <td>
                <a href="/shop-xe/khung-xe/view-update/${kx.id}">
                    <button>update</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>