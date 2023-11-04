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

<form action="/kich-thuoc/update/${kt.id}" method="post"  modelAttribute ="kt">
    ID: <input type="text" name="id" value="${kt.id}">
    <br/>
    Ma: <input type="text" name="ma" value="${kt.ma}">
    <br/>
    Ten: <input type="text" name="ten" value="${kt.ten}">
    <br>
    Trang Thai:<input type="radio" name="trangThai" checked value="0" ${kt.trangThai=="0"?'Checked':''}/>hoat dong
    <input type="radio" name="trangThai" value="1" ${kt.trangThai=="1"?'Checked':''}/>khong hoat dong
    <br>
    <button type="submit">update</button>
</form>
</body>
</html>