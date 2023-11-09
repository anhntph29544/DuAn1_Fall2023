<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Danh sách nhân viên | Quản trị Admin</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="/doc/css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <!-- or -->
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.4/xlsx.full.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.4/dist/sweetalert2.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.4/dist/sweetalert2.all.min.js"></script>
    <script src="/js/swal.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
</head>
<body onload="time()" class="app sidebar-mini rtl">
<!-- Navbar-->
<header class="app-header">
    <!-- Sidebar toggle button-->
    <a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">
        <!-- User Menu-->
        <li><a class="app-nav__item" href="/index.html"><i class='bx bx-log-out bx-rotate-180'></i></a></li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user">
        <img class="app-sidebar__user-avatar" src="#" width="50px" alt="User Image">
        <div>
            <p class="app-sidebar__user-name"><b>Dự Hiếu</b></p>
            <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
        </div>
    </div>
    <hr>
    <ul class="app-menu">
        <li><a class="app-menu__item haha" href="phan-mem-ban-hang.html"><i class='app-menu__icon bx bx-cart-alt'></i>
            <span class="app-menu__label">POS Bán Hàng</span></a></li>
        <li><a class="app-menu__item " href="index.html"><i class='app-menu__icon bx bx-tachometer'></i><span
                class="app-menu__label">Bảng điều khiển</span></a></li>
        <li><a class="app-menu__item active" href="/nhan-vien/hien-thi"><i class='app-menu__icon bx bx-id-card'></i>
            <span class="app-menu__label">Quản lý nhân viên</span></a></li>
        <li><a class="app-menu__item" href="/khach-hang/hien-thi"><i class='app-menu__icon bx bx-user-voice'></i><span
                class="app-menu__label">Quản lý khách hàng</span></a></li>
        <li><a class="app-menu__item" href="table-data-product.html"><i
                class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
        </li>
        <li><a class="app-menu__item" href="table-data-oder.html"><i class='app-menu__icon bx bx-task'></i><span
                class="app-menu__label">Quản lý đơn hàng</span></a></li>
        <li><a class="app-menu__item" href="table-data-banned.html"><i class='app-menu__icon bx bx-run'></i><span
                class="app-menu__label">Quản lý nội bộ</span></a></li>
        <li><a class="app-menu__item" href="table-data-money.html"><i class='app-menu__icon bx bx-dollar'></i><span
                class="app-menu__label">Bảng kê lương</span></a></li>
        <li><a class="app-menu__item" href="quan-ly-bao-cao.html"><i
                class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
        </li>
        <li><a class="app-menu__item" href="page-calendar.html"><i class='app-menu__icon bx bx-calendar-check'></i><span
                class="app-menu__label">Lịch công tác </span></a></li>
        <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-cog'></i><span class="app-menu__label">Cài
                đặt hệ thống</span></a></li>
    </ul>
</aside>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb side">
            <li class="breadcrumb-item active"><a href="/nhan-vien/hien-thi"><b>Danh sách nhân viên</b></a></li>
        </ul>
        <div id="clock"></div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <div class="row element-button">
                        <div class="col-sm-2">
                            <a class="btn btn-add btn-sm" href="/nhan-vien/showFormForAdd" title="Thêm"><i class="fas fa-plus"></i>
                                Tạo mới nhân viên</a>
                        </div>
                    </div>
                    <table class="table table-hover table-bordered js-copytextarea" cellpadding="0" cellspacing="0" border="0"
                           id="sampleTable">
                        <thead>
                        <tr>
                            <th width="20">STT</th>
                            <th width="20">Ảnh thẻ</th>
                            <th width="20">Mã NV</th>
                            <th width="100">email</th>
                            <th width="150">Họ và tên</th>
                            <th width="150">Ngày sinh</th>
                            <th width="150">Giới Tính</th>
                            <th>Chức vụ</th>
                            <th width="150">SĐT</th>
                            <th width="100">Trạng Thái</th>
                            <th width="100">Thao Tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="nv" varStatus="status">
                            <tr>
                                <td>${num*sizePage + status.index + 1}</td>
                                <td>
                                    <img src="${nv.image}" />
                                </td>
                                <td>${nv.ma}</td>
                                <td>${nv.email}</td>
                                <td>${nv.hoTen}</td>
                                <td>${nv.ngaySinh}</td>
                                <td>${nv.gioiTinh == 0 ? 'nam' : 'nữ'}</td>
                                <td>${nv.chucVu.tenChucVu}</td>
                                <td>${nv.sdt}</td>
                                <td>${nv.trangThai == 0 ? 'Làm viêc' : 'Nghỉ việc'}</td>
                                <td class="table-td-center">
                                    <a href="/nhan-vien/delete/${nv.idNhanVien}" class="btn btn-primary btn-sm trash"
                                       type="button" title="Xóa" onclick="if (!(confirm('Bạn có muốn xóa nhân viên này không?'))) return false">
                                        <i class="fas fa-trash-alt"></i>
                                    </a>
                                    <a href="/nhan-vien/detail/${nv.idNhanVien}" class="btn btn-primary btn-sm edit"
                                       type="button" title="Sửa" onclick="if (!(confirm('Bạn có muốn sửa nhân viên này không?'))) return false">
                                        <i class="fas fa-edit"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="row">
                    <div class="col-sm-12 col-md-5">
                        <div class="dataTables_info" id="sampleTable_info" role="status" aria-live="polite">
                            Hiện thể hiện từ
                            <c:choose>
                                <c:when test="${list.size() > 0}">
                                    <c:out value="${(num * sizePage) + 1}" />
                                </c:when>
                                <c:otherwise>0</c:otherwise>
                            </c:choose>
                            đến
                            <c:choose>
                                <c:when test="${list.size() > 0}">
                                    <c:out value="${(num * sizePage) + list.size()}" />
                                </c:when>
                                <c:otherwise>0</c:otherwise>
                            </c:choose>
                            <span> của </span>
                            <c:out value="${total * sizePage}" />
                            <span> danh mục</span>
                        </div>
                    </div>
<%--                    <div class="col-sm-12 col-md-7">--%>
<%--                        <div class="dataTables_paginate paging_simple_numbers" id="sampleTable_paginate">--%>
<%--                            <ul class="pagination">--%>
<%--                                <li class="paginate_button page-item previous"--%>
<%--                                    <c:if test="${num == 0}">class="disabled"</c:if>--%>

<%--                                    <a href="/nhan-vien/hien-thi&num=0" aria-controls="sampleTable" tabindex="0"--%>
<%--                                       class="page-link">Lùi</a>--%>
<%--                                </li>--%>
<%--                                <c:forEach begin="0" end="${total - 1}" var="pageIndex" varStatus="loop">--%>
<%--                                    <li class="paginate_button page-item"--%>
<%--                                        <c:if test="${pageIndex == num}">class="active"</c:if>--%>
<%--                                    >--%>
<%--                                        <a href="<c:url value='/nhan-vien/hien-thi'>&num=${pageIndex}</c:url>" aria-controls="sampleTable" tabindex="0"--%>
<%--                                           class="page-link"><c:out value="${pageIndex + 1}" /></a>--%>
<%--                                    </li>--%>
<%--                                </c:forEach>--%>
<%--                                <li class="paginate_button page-item next"--%>
<%--                                    <c:if test="${num == total - 1}">class="disabled"</c:if>--%>
<%--                                >--%>
<%--                                    <a href="<c:url value='/nhan-vien/hien-thi'>&num=${total - 1}</c:url>" aria-controls="sampleTable" tabindex="0"--%>
<%--                                       class="page-link">Tiếp</a>--%>
<%--                                </li>--%>
<%--                            </ul>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
            </div>
        </div>
    </div>
</main>
<!-- Essential javascripts for application to work-->
<script src="/js/swal.js"></script>
<script src="/doc/js/jquery-3.2.1.min.js"></script>
<script src="/doc/js/popper.min.js"></script>
<script src="/doc/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="src/jquery.table2excel.js"></script>
<script src="/doc/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="/doc/js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
</body>
</html>
