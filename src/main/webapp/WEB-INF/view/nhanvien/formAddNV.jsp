<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm nhân viên | Quản trị Admin</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="/doc/css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <!-- or -->
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <script src="/js/swal.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script>

        function readURL(input, thumbimage) {
            if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
                var reader = new FileReader();
                reader.onload = function (e) {
                    $("#thumbimage").attr('src', e.target.result);
                }
                reader.readAsDataURL(input.files[0]);
            }
            else { // Sử dụng cho IE
                $("#thumbimage").attr('src', input.value);

            }
            $("#thumbimage").show();
            $('.filename').text($("#uploadfile").val());
            $('.Choicefile').css('background', '#14142B');
            $('.Choicefile').css('cursor', 'default');
            $(".removeimg").show();
            $(".Choicefile").unbind('click');

        }
        $(document).ready(function () {
            $(".Choicefile").bind('click', function () {
                $("#uploadfile").click();

            });
            $(".removeimg").click(function () {
                $("#thumbimage").attr('src', '').hide();
                $("#myfileupload").html('<input type="file" id="uploadfile"  onchange="readURL(this);" />');
                $(".removeimg").hide();
                $(".Choicefile").bind('click', function () {
                    $("#uploadfile").click();
                });
                $('.Choicefile').css('background', '#14142B');
                $('.Choicefile').css('cursor', 'pointer');
                $(".filename").text("");
            });
        })
    </script>
    <style>
        .Choicefile {
            display: block;
            background: #14142B;
            border: 1px solid #fff;
            color: #fff;
            width: 150px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
            padding: 5px 0px;
            border-radius: 5px;
            font-weight: 500;
            align-items: center;
            justify-content: center;
        }

        .Choicefile:hover {
            text-decoration: none;
            color: white;
        }

        #uploadfile,
        .removeimg {
            display: none;
        }

        #thumbbox {
            position: relative;
            width: 100%;
            margin-bottom: 20px;
        }

        .removeimg {
            height: 25px;
            position: absolute;
            background-repeat: no-repeat;
            top: 5px;
            left: 5px;
            background-size: 25px;
            width: 25px;
            /* border: 3px solid red; */
            border-radius: 50%;

        }

        .removeimg::before {
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            content: '';
            border: 1px solid red;
            background: red;
            text-align: center;
            display: block;
            margin-top: 11px;
            transform: rotate(45deg);
        }

        .removeimg::after {
            /* color: #FFF; */
            /* background-color: #DC403B; */
            content: '';
            background: red;
            border: 1px solid red;
            text-align: center;
            display: block;
            transform: rotate(-45deg);
            margin-top: -2px;
        }
    </style>
</head>

<body class="app sidebar-mini rtl">
<main class="app-content">
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <h3 class="tile-title">Tạo mới nhân viên</h3>
                <div class="tile-body">
                    <f:form action="/nhan-vien/save" modelAttribute="nhanVien" method="post" enctype="multipart/form-data">
                            <div class="form-group col-md-4">
                                <label class="control-label">Mã nhân viên</label>
                                <f:input path="ma" cssClass="form-control" pattern="[A-Za-z0-9]+" />
                                <small class="text-danger"><f:errors path="ma" /></small>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Họ và tên</label>
                                <f:input path="hoTen" cssClass="form-control" required="true" pattern="^[A-Za-zÀ-ỹ ]+$" />
                                <small class="text-danger"><f:errors path="hoTen" /></small>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Giới tính</label>
                                <div class="form-check">
                                    <f:radiobutton path="gioiTinh" value="0" cssClass="form-check-input" />
                                    <label class="form-check-label">Nam</label>
                                </div>
                                <div class="form-check">
                                    <f:radiobutton path="gioiTinh" value="1" cssClass="form-check-input" />
                                    <label class="form-check-label">Nữ</label>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Email</label>
                                <f:input path="email" cssClass="form-control" required="true" />
                                <small class="text-danger"><f:errors path="email" /></small>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Số CCCD</label>
                                <f:input path="cccd" cssClass="form-control" required="true" />
                                <small class="text-danger"><f:errors path="cccd" /></small>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Số điện thoại</label>
                                <f:input path="sdt" cssClass="form-control" required="true" pattern="^\d{10,11}$" />
                                <small class="text-danger"><f:errors path="sdt" /></small>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Ngày sinh</label>
                                <f:input path="ngaySinh" cssClass="form-control" required="true" type="date"/>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Thành phố</label>
                                <f:select path="thanhPho" id="city" cssClass="form-select">
                                    <%--                                <f:options items="${cities}"  />--%>
                                    <option value="" selected>Chọn thành phố</option>
                                </f:select>
                            </div>
                            <div class="form-group col-md-4">
                                <label  class="control-label">Huyện</label>
                                <f:select path="huyen" id="district" cssClass="form-select">
                                    <%--                                <f:options items="${districts}" />--%>
                                    <option value="" selected>Chọn huyện</option>
                                </f:select>
                            </div>
                            <div class="form-group col-md-4">
                                <label  class="control-label">Xã</label>
                                <f:select path="xa" id="ward" cssClass="form-select">
                                    <%--                                <f:options items="${wards}" />--%>
                                    <option value="" selected>Chọn xã</option>
                                </f:select>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Số nhà</label>
                                <f:input path="soNha" cssClass="form-control" required="true" />
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Chức Vụ</label>
                                <f:select path="chucVu" class="form-select">
                                    <c:forEach items="${chucVu}" var="cv">
                                        <f:option value="${cv.idChucVu}">${cv.tenChucVu}</f:option>
                                    </c:forEach>
                                </f:select>
                            </div>
                        <div class="form-group col-md-12">
                            <label class="control-label">Ảnh 3x4 nhân viên</label>
                            <div id="myfileupload">
                                <input  type="file" name="imageFile" onchange="readURL(this);" />
                            </div>
                            <div id="thumbbox">
                                <img src="${nhanVien.image}" id="thumbimage" style="width: 90px; height: 120px;" />
                                <a class="removeimg" href="javascript:"></a>
                            </div>
                            <div id="boxchoice">
                                <a href="javascript:" class="Choicefile"><i class='bx bx-upload'></i></a>
                                <p style="clear:both"></p>
                            </div>
                        </div>
                        <div>
                            <f:button type="submit" cssClass="btn btn-info" onclick="if (!(confirm('Bạn có muốn thêm nhân viên mới không?'))) return false">Lưu lại</f:button>
                            <a class="btn btn-cancel" href="/nhan-vien/hien-thi" onclick="if (!(confirm('Bạn có muốn thoát không?'))) return false">Hủy bỏ</a>
                        </div>
                        <input type="hidden" name="trangThai" value="${nhanVien.trangThai}" />
                    </f:form>
                </div>
            </div>
        </div>
    </div>
</main>
<!-- Essential javascripts for application to work-->
<script src="/doc/js/jquery-3.2.1.min.js"></script>
<script src="/doc/js/popper.min.js"></script>
<script src="/doc/js/bootstrap.min.js"></script>
<script src="/doc/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="/doc/js/plugins/pace.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#thumbimage').attr('src', e.target.result).show();
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
    var citis = document.getElementById("city");
    var districts = document.getElementById("district");
    var wards = document.getElementById("ward");
    var Parameter = {
        url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json",
        method: "GET",
        responseType: "application/json",
    };
    var promise = axios(Parameter);
    promise.then(function (result) {
        renderCity(result.data);
    });

    function renderCity(data) {
        for (const x of data) {
            var opt = document.createElement('option');
            opt.value = x.Name;
            opt.text = x.Name;
            opt.setAttribute('data-id', x.Id);
            citis.options.add(opt);
        }
        citis.onchange = function () {
            districts.length = 1;
            wards.length = 1;
            if (this.options[this.selectedIndex].dataset.id != "") {
                const result = data.filter(n => n.Id === this.options[this.selectedIndex].dataset.id);

                for (const k of result[0].Districts) {
                    var opt = document.createElement('option');
                    opt.value = k.Name;
                    opt.text = k.Name;
                    opt.setAttribute('data-id', k.Id);
                    district.options.add(opt);
                }
            }
        };
        districts.onchange = function () {
            wards.length = 1;
            const dataCity = data.filter((n) => n.Id === citis.options[citis.selectedIndex].dataset.id);
            if (this.options[this.selectedIndex].dataset.id != "") {
                const dataWards = dataCity[0].Districts.filter(n => n.Id === this.options[this.selectedIndex].dataset.id)[0].Wards;

                for (const w of dataWards) {
                    var opt = document.createElement('option');
                    opt.value = w.Name;
                    opt.text = w.Name;
                    opt.setAttribute('data-id', w.Id);
                    wards.options.add(opt);
                }
            }
        };
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>

