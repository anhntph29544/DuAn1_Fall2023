<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sản phẩm chi tiết</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <script>
        function goBack() {
            window.history.back()
        }
    </script>
    <style>
        body {
            margin: auto;
        }
    </style>
</head>
<body>
<%@include file="../include/header.jsp"%>
<div style="padding: 20px">
    <h3 style="text-align: center">SẢN PHẨM CHI TIẾT</h3>
    <a href="/shop-xe/san-pham-chi-tiet/view-add">
        <button class="btn btn-primary">Thêm sản phẩm chi tiết</button>
    </a>
    <div style="margin-top: 10px">
        <span style="font-weight: bold"><i class="bi bi-funnel-fill"></i> Bộ lọc</span>
    </div>
    <%--    lọc theo tên và trạng thái--%>
    <div class="row">
        <div class="col-md-6" style="border: 1px solid black;padding: 10px;">
            <form action="/shop-xe/san-pham-chi-tiet/hien-thi" class="row">
                <div class="col-md-6">
                    <label>Mã sản phẩm</label>
                    <input type="text" name="tenSearch" class="form-control me-2" placeholder="Nhập mã sản phẩm"
                           value="${tenSearch}">
                </div>
                <div class="col-md-6">
                    <label>Trạng thái sản phẩm</label>
                    <select name="trangThai" class="form-select">
                        <option value="3" ${trangThai==3?"selected":""} selected></option>
                        <option value="0" ${trangThai==0?"selected":""}>Hoạt động</option>
                        <option value="1" ${trangThai==1?"selected":""}>Không hoạt động</option>
                    </select>
                </div>
                <div class="col-md-12" style="padding-top: 10px">
                    <button type="submit" class="btn btn-primary"><i class="bi bi-search"></i> Tìm kiếm</button>
                </div>
            </form>
        </div>
        <%--        lọc theo màu sắc và size--%>
        <%--        <div class="col-md-6" style="border: 1px solid black;padding: 10px;">--%>
        <%--            <div class="row">--%>
        <%--                <div class="col-md-6">--%>
        <%--                    <label>Màu sắc</label>--%>
        <%--                    <select name="size" class="form-select" onchange="#">--%>
        <%--                        <option value=""></option>--%>
        <%--                        <c:forEach items="${listMS}" var="ms">--%>
        <%--                            <option value="${ms}" >${ms.ten}</option>--%>
        <%--                        </c:forEach>--%>
        <%--                    </select>--%>
        <%--                </div>--%>
        <%--                <div class="col-md-6">--%>
        <%--                    <label>Size</label>--%>
        <%--                    <select name="size" class="form-select">--%>
        <%--                        <option value=""></option>--%>
        <%--                        <c:forEach items="${listKT}" var="kt">--%>
        <%--                            <option value="${kt}">${kt.ten}</option>--%>
        <%--                        </c:forEach>--%>
        <%--                    </select>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--            </a>--%>
        <%--        </div>--%>
        <c:if test="${messege!=0}">
            <div class="alert alert-${messege==1?"success":"danger"}" role="alert">
                    ${messege==1?"Lưu thành công":"Lưu thất bại"}
            </div>
        </c:if>
        <div style="margin-top: 10px;" class="col-md-12">
            <a href="/shop-xe/san-pham-chi-tiet/hien-thi">
                <button class="btn btn-danger"><i class="bi bi-x-lg"></i> Xoá lọc</button>
            </a>
        </div>
        <div style="font-weight: bold; margin-top: 10px;" class="row">
            <div class="col-md-10">
                <span><i class="bi bi-card-list"></i> DS sản phẩm chi tiết</span>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th>STT</th>
                <th>Mã</th>
                <th>Hình ảnh</th>
                <th>Tên sản phẩm</th>
                <th>Số lượng</th>
                <th>Kích thước</th>
                <th>Màu sắc</th>
                <th>Đơn giá</th>
                <th>Mô tả</th>
                <th>Trạng thái</th>
                <th>action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSPCT.content}" var="spct" varStatus="stt">
                <tr>
                    <td>${stt.index+1}</td>
                    <td>${spct.ma}</td>
                    <td>
                        <img src='<c:url value="/getimage/${spct.hinhAnh}"></c:url>' style="max-width: 100px">
                    </td>
                    <td>${spct.sp.ten}</td>
                    <td>${spct.soLuong}</td>
                    <td>${spct.kt.ten}</td>
                    <td>${spct.ms.ten}</td>
                    <td>${spct.gia}</td>
                    <td>${spct.moTa}</td>
                    <td>${spct.trangThai==0? "Hoạt động" : "Không hoạt động"}</td>
                    <td>
                        <a href="/shop-xe/san-pham-chi-tiet/view-update/${spct.id}">
                            <button class="btn btn-warning"><i class="bi bi-eye"></i> Chi tiết</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="0" end="${listSPCT.totalPages-1<0?0:listSPCT.totalPages-1}" varStatus="loop">
                    <c:if test="${listSPCT.totalPages-1>=0}">
                        <li class="page-item">
                            <c:if test="${tenSearch!=''}">
                                <a class="page-link"
                                   href="/shop-xe/san-pham-chi-tiet/hien-thi?tenSearch=${tenSearch}&trangThai=${trangThai}&page=${loop.index}">
                                        ${loop.index+1}
                                </a>
                            </c:if>
                            <c:if test="${tenSearch==''}">
                                <a class="page-link"
                                   href="/shop-xe/san-pham-chi-tiet/hien-thi?page=${loop.index}">
                                        ${loop.index+1}
                                </a>
                            </c:if>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </nav>
    </div>
    <button onclick="goBack()" class="btn btn-danger">Quay lại</button>
</body>
</html>