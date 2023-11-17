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
<h1>Quản Lý Voucher</h1>
<form action="/voucher/search" method="get">
    Ngày Bắt Đầu: <input type="date" name="ngayBD">
    Ngày Kết Thúc: <input type="date" name="ngayKT">
    <button type="submit">tim kiếm</button>
</form>
<form action="/voucher/add" method="post"  modelAttribute ="vc">
    Số lượng: <input type="text" name="soLuong" value="${vc.soLuong}">
    <br/>
    Giá trị: <input type="text" name="giaTri" value="${vc.giaTri}">
    <br>
    Ngày Bắt Đầu: <input type="date" name="ngayBD" value="${vc.ngayBD}">
    <br>
    Ngày Kết Thúc: <input type="date" name="ngayKT" value="${vc.ngayKT}">
<%--    <br>--%>
<%--    Trang Thai:<input type="radio" name="trangThai" checked value="0" ${vc.trangThai=="0"?'Checked':''}/>hoat dong--%>
<%--    <input type="radio" name="trangThai" value="1" ${vc.trangThai=="1"?'Checked':''}/>khong hoat dong--%>
    <br>
    <button type="submit">add</button>
</form>
<table class="table" border="1">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Số lượng</th>
        <th scope="col">Giá trị</th>
        <th scope="col">Ngày Bắt Đầu</th>
        <th scope="col">Ngày Kết Thúc</th>
        <th scope="col">trang thai</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list.content}" var="vc" varStatus="stt">
        <tr>
            <th scope="row">${stt.index+1}</th>
            <td>${vc.soLuong}</td>
            <td>${vc.giaTri}</td>
            <td>${vc.ngayBD}</td>
            <td>${vc.ngayKT}</td>
            <td>${vc.trangThai==0?"Hoạt Động":"Không Hoạt Động"}</td>
            <td>
                <a href="/voucher/view-update/${vc.id}">
                    <button>update</button>
                </a>
                <a href="/voucher/detail/${vc.id}">
                    <button>detail</button>
                </a>
                <a href="/voucher/delete/${vc.id}">
                    <button>delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${list.totalPages-1<0?0:list.totalPages-1}" varStatus="loop">
            <c:if test="${list.totalPages-1>=0}">
            <li class="page-item"><a class="page-link" href="/voucher/hien-thi?page=${loop.index}">${loop.index+1}</a></li>
            </c:if>
        </c:forEach>
    </ul>
</nav>
</body>
</html>