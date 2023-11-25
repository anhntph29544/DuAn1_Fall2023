<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<div class="container" style="margin-top: 10px">
    <form action="/tao-hoa-don/add" method="post">
        <button class="btn btn-primary">tạo hoá đơn</button>
    </form>
    <br>
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <c:forEach items="${listHD}" var="hd" varStatus="stt">
            <li class="nav-item" role="presentation">
                <a href="/chon-hoa-don/hien-thi/${hd.id}">
                    <button class="nav-link ${hd.id==idHDSelect?'active':''}" data-bs-toggle="tab" type="button" role="tab">
                        Hoá đơn ${stt.index+1}
                    </button>
                </a>
            </li>
        </c:forEach>
    </ul>
    <h1>${idHDSelect}</h1>
</div>
</body>
</html>