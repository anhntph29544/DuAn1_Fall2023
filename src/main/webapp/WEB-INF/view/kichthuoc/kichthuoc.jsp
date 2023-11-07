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

<form action="/kich-thuoc/add" method="post"  modelAttribute ="kt">
    Ma: <input type="text" name="ma" value="${kt.ma}">
    <br/>
    Ten: <input type="text" name="ten" value="${kt.ten}">
    <br>
    Trang Thai:<input type="radio" name="trangThai" checked value="0" ${kt.trangThai=="0"?'Checked':''}/>hoat dong
    <input type="radio" name="trangThai" value="1" ${kt.trangThai=="1"?'Checked':''}/>khong hoat dong
    <br>
    <button type="submit">add</button>
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
    <c:forEach items="${list}" var="kt" varStatus="stt">
        <tr>
            <th scope="row">${stt.index+1}</th>
            <td>${kt.ma}</td>
            <td>${kt.ten}</td>
            <td>${kt.trangThai}</td>
            <td>
                <a href="/kich-thuoc/view-update/${kt.id}">
                    <button>update</button>
                </a>
                <a href="/kich-thuoc/detail/${kt.id}">
                    <button>detail</button>
                </a>
                <a href="/kich-thuoc/delete/${kt.id}">
                    <button>delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>