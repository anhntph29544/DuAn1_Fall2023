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
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

    <script language="javascript" type="text/javascript"><%@include file="spct-add.js" %></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

    <style>
        i {
            font-size: 30px;
        }
        body {
            margin: auto;
        }
    </style>
    <script>
        function goBack() {
            window.history.back()
        }
    </script>
</head>
<body>
<%@include file="../include/header.jsp"%>
<div class="ql" style="padding: 20px">
    <h3 style="text-align: center">THÊM SẢN PHẨM CHI TIẾT</h3>
    <form:form method="post" action="/shop-xe/san-pham-chi-tiet/add" modelAttribute="spct1" enctype="multipart/form-data">
        <%--thông tin sản phẩm--%>
        <div class="col-md-12 row">
            <div class="col-md-3">
                    <%--mã sản phẩm chi tiết--%>
                <div class="mb-3">
                    <label class="form-label">Mã sản phẩm chi tiết</label>
                    <form:input class="form-control" path="ma" disabled="true"/>
                </div>
                    <%--sản phẩm--%>
                <div class="mb-3">
                    <label class="form-label">Tên sản phẩm</label>
                    <div class="col-md-12 row">
                        <div class="col-md-11">
                            <form:select path="sp" class="form-select" id="form_sp">
                                <c:forEach items="${listSP}" var="sp">
                                    <form:option value="${sp}">${sp.ten}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-md-1">
                            <a data-bs-toggle="modal" data-bs-target="#sanPham">
                                <i class="bi bi-plus-circle-dotted"></i>
                            </a>
                        </div>
                    </div>
                </div>
                    <%--đơn giá--%>
                <div class="mb-3">
                    <label class="form-label">Đơn giá</label>
                    <form:input class="form-control" id="productID" path="gia" type="number"/>
                    <div class="form-text"><form:errors path="gia"/></div>
                </div>
            </div>
            <div class="col-md-3">
                    <%--số lượng--%>
                <div class="mb-3">
                    <label class="form-label">Số lượng</label>
                    <form:input class="form-control" path="soLuong" type="number"/>
                    <div class="form-text"><form:errors path="soLuong"/></div>
                </div>
                    <%--mô tả--%>
                <div class="mb-3">
                    <label class="form-label">Mô tả</label>
                    <form:input class="form-control" path="moTa"/>
                    <div class="form-text"><form:errors path="moTa"/></div>
                </div>
                <div class="mb-3">
                    <label class="form-label">Màu sắc</label>
                    <div class="col-md-12 row">
                        <div class="col-md-11">
                            <form:select path="ms" class="form-select" id="form_ms">
                                <c:forEach items="${listMS}" var="ms">
                                    <form:option value="${ms}">${ms.ten}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-md-1">
                            <a data-bs-toggle="modal" data-bs-target="#mauSac">
                                <i class="bi bi-plus-circle-dotted"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="mb-3">
                    <label class="form-label">Kiểu dáng xe</label>
                    <div class="col-md-12 row">
                        <div class="col-md-11">
                            <form:select path="kdx" class="form-select" id="form_kdx">
                                <c:forEach items="${listKDX}" var="kdx">
                                    <form:option value="${kdx}">${kdx.ten}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-md-1">
                            <a data-bs-toggle="modal" data-bs-target="#kieuDangXe">
                                <i class="bi bi-plus-circle-dotted"></i>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <label class="form-label">Kích thước</label>
                    <div class="col-md-12 row">
                        <div class="col-md-11">
                            <form:select path="kt" class="form-select" id="form_kt">
                                <c:forEach items="${listKT}" var="kt">
                                    <form:option value="${kt}">${kt.ten}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-md-1">
                            <a data-bs-toggle="modal" data-bs-target="#kichThuoc">
                                <i class="bi bi-plus-circle-dotted"></i>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <label class="form-label">Thương hiệu</label>
                    <div class="col-md-12 row">
                        <div class="col-md-11">
                            <form:select path="th" class="form-select" id="form_th">
                                <c:forEach items="${listTH}" var="th">
                                    <form:option value="${th}">${th.ten}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-md-1">
                            <a data-bs-toggle="modal" data-bs-target="#thuongHieu">
                                <i class="bi bi-plus-circle-dotted"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                    <%--hinh anh--%>
                <div class="mb-3">
                    <label class="form-label">Hình ảnh</label>
                    <input type="file" name="photo" accept="image/gif, image/png, image/jpeg"/>
                </div>
                    <%--trạng thái--%>
                <div class="mb-3">
                    <label class="form-label">Trạng thái</label>
                    <div class="mb-3 form-check">
                        <form:radiobutton path="trangThai" class="form-check-input" value="0" id="trangThaiSPCT1"
                                          checked="true"/>
                        <label class="form-check-label" for="trangThaiSPCT1">Hoạt động</label>
                    </div>
                    <div class="mb-3 form-check">
                        <form:radiobutton path="trangThai" class="form-check-input" value="1" id="trangThaiSPCT2"/>
                        <label class="form-check-label" for="trangThaiSPCT2">Không hoạt động</label>
                    </div>
                </div>
            </div>
        </div>
        <div style="text-align: right">
            <button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có chắc không?')">
                <i class="bi bi-plus-square" style="font-size: 20px"></i> Thêm
            </button>
        </div>
    </form:form>
    <%-- Thêm sản phẩm --%>
    <div class="modal fade" id="sanPham" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Thêm sản phẩm</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id='quick_create_sp'>
                        <div class="mb-3">
                            <label class="col-form-label">Tên</label>
                            <input id="tenSP" name="ten" type="text" class="form-control"/><br>
                        </div>
                        <label class="form-label">Trạng thái</label>
                        <div class="mb-3 form-check">
                            <input type="radio" name="trangThai" class="form-check-input" value="0"
                                   id="trangThaiSP1"
                                   checked="true"/>
                            <label class="form-check-label" for="trangThaiSP1">Hoạt động</label>
                        </div>
                        <div class="mb-3 form-check">
                            <input type="radio" name="trangThai" class="form-check-input" value="1"
                                   id="trangThaiSP2"/>
                            <label class="form-check-label" for="trangThaiSP2">Không hoạt động</label>
                        </div>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                        <button type="submit" class="btn btn-primary">Thêm</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%-- End thêm sản phẩm   --%>
    <%-- Màu sắc --%>
    <div class="modal fade" id="mauSac" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Thêm màu sắc</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id='quick_create_ms'>
                        <div class="mb-3">
                            <label class="col-form-label">Tên</label>
                            <input id="tenMS" name="ten" type="text" class="form-control"/><br>
                        </div>
                        <label class="form-label">Trạng thái</label>
                        <div class="mb-3 form-check">
                            <input type="radio" name="trangThai" class="form-check-input" value="0"
                                   id="trangThaiMS1"
                                   checked="true"/>
                            <label class="form-check-label" for="trangThaiMS1">Hoạt động</label>
                        </div>
                        <div class="mb-3 form-check">
                            <input type="radio" name="trangThai" class="form-check-input" value="1"
                                   id="trangThaiMS2"/>
                            <label class="form-check-label" for="trangThaiMS2">Không hoạt động</label>
                        </div>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                        <button type="submit" class="btn btn-primary">Thêm</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%--  End thêm màu sắc  --%>
    <%-- Kiểu dáng xe --%>
    <div class="modal fade" id="kieuDangXe" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Thêm kiểu dáng xe</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id='quick_create_kdx'>
                        <div class="mb-3">
                            <label class="col-form-label">Tên</label>
                            <input id="tenKDX" name="ten" type="text" class="form-control"/><br>
                        </div>
                        <label class="form-label">Trạng thái</label>
                        <div class="mb-3 form-check">
                            <input type="radio" name="trangThai" class="form-check-input" value="0"
                                   id="trangThaiKDX1"
                                   checked="true"/>
                            <label class="form-check-label" for="trangThaiKDX1">Hoạt động</label>
                        </div>
                        <div class="mb-3 form-check">
                            <input type="radio" name="trangThai" class="form-check-input" value="1"
                                   id="trangThaiKDX2"/>
                            <label class="form-check-label" for="trangThaiKDX2">Không hoạt động</label>
                        </div>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                        <button type="submit" class="btn btn-primary">Thêm</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%--  End kiểu dáng xe  --%>
    <%-- Kích thước --%>
    <div class="modal fade" id="kichThuoc" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Thêm kích thước</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id='quick_create_kt'>
                        <div class="mb-3">
                            <label class="col-form-label">Tên</label>
                            <input id="tenKT" name="ten" type="text" class="form-control"/><br>
                        </div>
                        <label class="form-label">Trạng thái</label>
                        <div class="mb-3 form-check">
                            <input type="radio" name="trangThai" class="form-check-input"
                                   value="0" id="trangThaiKT1" checked="true"/>
                            <label class="form-check-label" for="trangThaiKT1">Hoạt động</label>
                        </div>
                        <div class="mb-3 form-check">
                            <input type="radio" name="trangThai" class="form-check-input" value="1"
                                   id="trangThaiKT2"/>
                            <label class="form-check-label" for="trangThaiKT2">Không hoạt động</label>
                        </div>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                        <button type="submit" class="btn btn-primary">Thêm</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%--  End kích thước  --%>
    <%-- Thương hiệu --%>
    <div class="modal fade" id="thuongHieu" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Thêm thương hiệu</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id='quick_create_th'>
                        <div class="mb-3">
                            <label class="col-form-label">Tên</label>
                            <input id="tenTH" name="ten" type="text" class="form-control"/><br>
                        </div>
                        <label class="form-label">Trạng thái</label>
                        <div class="mb-3 form-check">
                            <input type="radio" name="trangThai" class="form-check-input"
                                   value="0" id="trangThaiTH1" checked="true"/>
                            <label class="form-check-label" for="trangThaiTH1">Hoạt động</label>
                        </div>
                        <div class="mb-3 form-check">
                            <input type="radio" name="trangThai" class="form-check-input" value="1"
                                   id="trangThaiTH2"/>
                            <label class="form-check-label" for="trangThaiTH2">Không hoạt động</label>
                        </div>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                        <button type="submit" class="btn btn-primary">Thêm</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%--  End thương hiệu  --%>
    <button onclick="goBack()" class="btn btn-danger">Quay lại</button>
</div>
</body>
</html>