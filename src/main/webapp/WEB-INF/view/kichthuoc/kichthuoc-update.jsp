<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form action="/shop-xe/kich-thuoc/update" method="post"  modelAttribute ="kt1">
    Mã: <form:input path="ma"/>
    <br/>
    Tên: <form:input path="ten"/>
    <br>
    Trạng Thái:
    <form:radiobutton path="trangThai" value="0" checked="true"/>Hoạt động
    <form:radiobutton path="trangThai" value="1"/>Không hoạt động
    <br>
    <form:button type="submit">Update</form:button>
</form:form>
</body>
</html>