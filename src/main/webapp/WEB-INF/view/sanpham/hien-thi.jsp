<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        body {
            margin: auto;
        }
    </style>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<div class="ql" style="padding: 20px">
    <h2 style="text-align: center">SẢN PHẨM</h2>
    <div class="row">
        <div class="col-md-6">
            <span style="font-weight: bold">
                <i class="bi bi-funnel-fill"></i> Bộ lọc
            </span>
        </div>
        <div class="col-md-6">
            <span style="font-weight: bold">
                Thêm sản phẩm
            </span>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6" style="border: 1px solid black;padding: 10px;">
            <form action="/shop-xe/san-pham" class="row">
                <div class="col-md-4">
                    <label>Tên sản phẩm</label>
                    <input type="text" name="tenSearch" class="form-control me-2" placeholder="Nhập tên sản phẩm"
                           value="${tenSearch}">
                </div>
                <div class="col-md-4">
                    <label>Trạng thái sản phẩm</label>
                    <select name="trangThaiSearch" class="form-select">
                        <option value="3" ${trangThaiSearch==3?"selected":""} selected></option>
                        <option value="0" ${trangThaiSearch==0?"selected":""}>Hoạt động</option>
                        <option value="1" ${trangThaiSearch==1?"selected":""}>Không hoạt động</option>
                    </select>
                </div>
                <div class="col-md-12" style="padding-top: 10px">
                    <button type="submit" class="btn btn-primary"><i class="bi bi-search"></i> Tìm kiếm</button>
                </div>
            </form>
            <a href="/shop-xe/san-pham">
                <button class="btn btn-danger"><i class="bi bi-x-lg"></i> Xoá lọc</button>
            </a>
        </div>
        <div class="col-md-6" style="padding: 10px;border: 1px solid black;">
            <form:form action="/shop-xe/san-pham/add" modelAttribute="sp1" method="post">
                <div class="mb-3">
                    <label class="col-form-label">Tên</label>
                    <form:input path="ten" type="text" class="form-control"/><br>
                    <div class="form-text"><form:errors path="ten"/></div>
                    <div class="form-text" ${tenError==null?"hidden":""}>
                            ${tenError}
                    </div>
                </div>
                <label class="form-label">Trạng thái</label>
                <div class="mb-3 form-check">
                    <form:radiobutton path="trangThai" class="form-check-input" value="0"
                                      id="trangThaiSP1"
                                      checked="true"/>
                    <label class="form-check-label" for="trangThaiSP1">Hoạt động</label>
                </div>
                <div class="mb-3 form-check">
                    <form:radiobutton path="trangThai" class="form-check-input" value="1"
                                      id="trangThaiSP2"/>
                    <label class="form-check-label" for="trangThaiSP2">Không hoạt động</label>
                </div>
                <form:button type="submit" class="btn btn-primary"
                             onclick="return confirm('Bạn có chắc không?')">Thêm</form:button>
            </form:form>
        </div>
    </div>
    <div style="font-weight: bold; margin-top: 10px;" class="row">
        <div class="col-md-9">
            <span><i class="bi bi-card-list"></i> Danh sách sản phẩm</span>
        </div>
        <div class="col-md-3">
            <a href="/shop-xe/san-pham-chi-tiet/hien-thi">
                <button class="btn btn-primary">DS sản phẩm chi tiết</button>
            </a>
        </div>
    </div>
    <table class="table table-bordered" style="margin-top: 5px">
        <thead class="table-secondary">
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên sản phẩm</th>
            <th>Trạng thái</th>
            <th>hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSP.content}" var="sp" varStatus="stt">
            <tr>
                <td>${stt.index+1}</td>
                <td>${sp.ma}</td>
                <td>${sp.ten}</td>
                <td>${sp.trangThai==0? "Hoạt động" : "Không hoạt động"}</td>
                <td>
                    <a href="/shop-xe/san-pham-chi-tiet/hien-thi?tenSearch=${sp.ma}">
                        <button class="btn btn-warning"><i class="bi bi-eye"></i> Chi tiết</button>
                    </a>
                    <a href="/shop-xe/san-pham/view-update/${sp.id}">
                        <button class="btn btn-success">Sửa sản phẩm</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach begin="0" end="${listSP.totalPages-1<0?0:listSP.totalPages-1}" varStatus="loop">
                <c:if test="${listSP.totalPages-1>=0}">
                    <li class="page-item">
                        <c:if test="${tenSearch!=''}">
                            <a class="page-link"
                               href="/shop-xe/san-pham?tenSearch=${tenSearch}&trangThaiSearch=${trangThaiSearch}&page=${loop.index}">
                                    ${loop.index+1}
                            </a>
                        </c:if>
                        <c:if test="${tenSearch==''}">
                            <a class="page-link"
                               href="/shop-xe/san-pham?page=${loop.index}">
                                    ${loop.index+1}
                            </a>
                        </c:if>
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </nav>
</div>
</body>
</html>