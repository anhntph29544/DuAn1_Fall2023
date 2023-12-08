<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <title>Màn hình Thống Kê Doanh số</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<h1>Thống Kê Doanh Số</h1>
<table>
    <form action="/thong-ke/hien-thi" class="row">
        <div class="col-md-2">
            <label>Từ Ngày</label>
            <input type="date" name="ngayTT1" class="form-control me-2"
                   value="${ngayTT1}">
            <label>Đến Ngày</label>
            <input type="date" name="ngayTT2" class="form-control me-2"
                   value="${ngayTT2}">
            <button class="btn btn-secondary" type="submit">Thống Kê</button>
        </div>
    </form>
</table>

<h2>Biểu Đồ Doanh Số</h2>
<h5>Từ Ngày ${ngayTT1} Đến Ngày ${ngayTT2}</h5>
<canvas id="myChart" width="50" height="50"></canvas>
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: [         ${tongTien}
<%--                                &lt;%&ndash; Dữ liệu nhãn từ danhSachThongKe &ndash;%&gt;--%>
<%--                                <c:forEach items="${danhSachThongKe}" var="item" varStatus="status">--%>
<%--                                "${item.tenSanPham}"<c:if test="${!status.last}">, </c:if>--%>
<%--                                </c:forEach>--%>
            ],
            datasets: [{
                label: 'Doanh số',
                data: [
                    <%-- Dữ liệu doanh số từ danhSachThongKe --%>
                    ${tongTien}
                    <%--                    <c:forEach items="${tongTien}" var="item" varStatus="status">--%>
                    <%--                    ${item.tongTien}--%>
                    <c:if test="${!status.last}"></c:if>
<%--                    </c:forEach>--%>
                ],
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
</script>
</body>
</html>
