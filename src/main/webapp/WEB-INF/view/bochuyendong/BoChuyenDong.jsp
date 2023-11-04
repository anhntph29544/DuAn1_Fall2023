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
<table>
    <form:form method="post" action="/bo-chuyen-dong/add" modelAttribute="m1">
        Mã:<form:input path="ma"/><br>
        Tên:<form:input path="ten"/><br>
        Trạng Thái:<form:radiobutton path="trangThai" value="1" checked="1"/>Hoạt Động
        <form:radiobutton path="trangThai" value="0"/>Không Hoạt Động</br>
        <form:button type="submit">ADD</form:button>
    </form:form>
</table>
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
    <c:forEach var="m" items="${listM}" varStatus="d">
        <tr>
            <td>${d.index+1}</td>
            <td>${m.ma}</td>
            <td>${m.ten}</td>
            <td>${m.trangThai==1?"Hoạt Động":"Không Hoạt Động"}</td>
            <td>
                <a href="/bo-chuyen-dong/detail/${m.id}">
                    <button>Detail</button>
                </a>
                <a href="/bo-chuyen-dong/view-update/${m.id}">
                    <button>Update</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>