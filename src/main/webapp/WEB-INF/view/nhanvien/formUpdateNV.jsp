<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<f:form action="/nhan-vien/update/${nhanVien.idNhanVien}" modelAttribute="nhanVien" method="post" enctype="multipart/form-data">
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
            <f:radiobutton path="gioiTinh" value="1" label="nam" cssClass="form-check-input" />
            <label class="form-check-label">Nam</label>
        </div>
        <div class="form-check">
            <f:radiobutton path="gioiTinh" value="0" label="nữ" cssClass="form-check-input" />
            <label class="form-check-label">Nữ</label>
        </div>
    </div>
    <div class="form-group col-md-4">
        <label class="control-label">Email</label>
        <f:input path="email" cssClass="form-control" required="true" />
        <small class="text-danger"><f:errors path="email" /></small>
    </div>
    <div class="form-group col-md-3">
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
    <div class="form-group">
        <label class="control-label">Chức Vụ</label>
        <f:select path="chucVu" class="form-select">
            <c:forEach items="${chucVu}" var="cv">
                <f:option value="${cv.idChucVu}">${cv.tenChucVu}</f:option>
            </c:forEach>
        </f:select>
    </div>
    <div class="form-group col-md-4">
        <label class="control-label">Trạng thái</label>
        <div class="form-check">
            <f:radiobutton path="trangThai" value="1" cssClass="form-check-input" />
            <label class="form-check-label">hoạt động</label>
        </div>
        <div class="form-check">
            <f:radiobutton path="trangThai" value="0" cssClass="form-check-input" />
            <label class="form-check-label">dừng hoạt động</label>
        </div>
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
        <button type="submit" class="btn btn-info" onclick="if (!(confirm('Bạn có muốn sửa nhân viên này không?'))) return false">Lưu lại</button>
        <a class="btn btn-cancel" href="/nhan-vien/hien-thi" onclick="if (!(confirm('Bạn có muốn thoát không?'))) return false">Hủy bỏ</a>
    </div>
</f:form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script>
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
            district.length = 1;
            ward.length = 1;
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
        district.onchange = function () {
            ward.length = 1;
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
</body>
</html>