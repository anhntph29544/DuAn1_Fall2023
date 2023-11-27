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
    <style>
        body{
            margin: 0px 20px;
        }
        h1, h3 {
            text-align: center;
        }

        .tonginput {
            margin: 50px 10px;
            text-align: center;
            height: auto;
            width: 1010px;
            display: flex;
            justify-content: space-between;
        }

        .them {
            width: 500px;
            height: auto;
            margin-bottom: 20px;
            border: 1px solid #000000;
        }

        .timkiem {
            width: 500px;
            height: auto;
            margin-bottom: 20px;
            border: 1px solid #000000;
        }
    </style>

</head>
<body>
<h1>Quản Lý Voucher</h1>
<div class="tonginput">
    <div class="timkiem">
        <form action="/voucher/search" method="get">
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addo7">Ngày Bắt Đầu</span>
                <input type="date" name="ngayBD" class="form-control" placeholder="Username"
                       aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon8">Ngày Kết Thúc</span>
                <input type="date" name="ngayKT" class="form-control" placeholder="Username"
                       aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="btn-group" role="group" aria-label="Basic example">
                <button type="submit" class="btn btn-primary">Tìm Kiếm</button>
            </div>
        </form>
    </div>
    <div class="them">
        <form action="/voucher/add" method="post" modelAttribute="vc">
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Số Lượng</span>
                <input type="text" name="soLuong" value="${vc.soLuong}" class="form-control" placeholder="Username"
                       aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon2">Giá Trị</span>
                <input type="text" name="giaTri" value="${vc.giaTri}" class="form-control" placeholder="Username"
                       aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon3">Ngày Bắt Đầu</span>
                <input type="date" name="ngayBD" value="${vc.ngayBD}" class="form-control" placeholder="Username"
                       aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon4">Ngày Kết Thúc</span>
                <input type="date" name="ngayKT" value="${vc.ngayKT}" class="form-control" placeholder="Username"
                       aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="btn-group" role="group" aria-label="Basic example">
                <button type="submit" class="btn btn-primary">Thêm</button>
            </div>
        </form>
    </div>
</div>
<h3>Danh Sách Vorcher</h3>
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
                    <button class="btn btn-primary">Update</button>
                </a>
                <a href="/voucher/detail/${vc.id}">
                    <button class="btn btn-primary">Detail</button>
                </a>
                <a href="/voucher/delete/${vc.id}">
                    <button class="btn btn-primary">Xóa</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="page">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach begin="0" end="${list.totalPages-1<0?0:list.totalPages-1}" varStatus="loop">
                <c:if test="${list.totalPages-1>=0}">
                    <li class="page-item"><a class="page-link"
                                             href="/voucher/hien-thi?page=${loop.index}">${loop.index+1}</a></li>
                </c:if>
            </c:forEach>
        </ul>
    </nav>
</div>
</body>
</html>