// $(document).ready(function(){
//     $('#quick_create_sp').submit(async function(e){
//         e.preventDefault();
//         const url = 'http://localhost:8080/shop-xe/api/san-pham-chi-tiet/sp';
//         // $.ajax({
//         //     type: 'POST',
//         //     url,
//         //     dataType: 'json',
//         //     data: $('#quick_create_sp').serialize(),
//         //     success: function (){
//         //         alert("Thành công")
//         //     }
//         // });
//
//         const data = {
//             ten: $("#quick_create_sp #ten").val(),
//             trangThai: $("#quick_create_sp #trangThaiSP1").val() == 0 ? 0 : 1
//         };
//         try {
//             const response = await fetch(url, {
//                 method: 'POST',
//                 mode: "cors",
//                 headers: {
//                     "Content-Type": "application/json",
//                 },
//                 body: data
//             });
//             console.log(response)
//         } catch (e) {
//             console.error(e)
//         }
//     });
// });
$(document).ready(
    function () {
        const spModal= new bootstrap.Modal('#sanPham');
        const msModal= new bootstrap.Modal('#mauSac');
        const kdxModal= new bootstrap.Modal('#kieuDangXe');
        const ktModal= new bootstrap.Modal('#kichThuoc');
        const thModal= new bootstrap.Modal('#thuongHieu');
        // Sản phẩm
        $("#quick_create_sp").submit(function (event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPostSP();
        });

        //Do post
        function ajaxPostSP() {
            // PREPARE FORM DATA
            var data = {
                ten: $("#quick_create_sp #tenSP").val(),
                trangThai: $("#quick_create_sp input[name='trangThai']:checked").val()
            };
            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "http://localhost:8080/shop-xe/san-pham-chi-tiet/sp/add",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    if (result.status == "success") {
                        console.log("-------------post---------------");
                        console.log(data);
                        spModal.hide();
                        alert("Success")
                        ajaxGetSP();
                    } else {
                        alert("Fail")
                        console.log("fail");
                    }
                    console.log(result);
                },
                error: function (e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });
        }

        // DO GET
        function ajaxGetSP() {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/shop-xe/san-pham-chi-tiet/sp/getAll",
                success: function (result) {
                    const sp = result.data;
                    if (result.status == "success") {
                        if (sp.trangThai==0){
                            var select= document.getElementById("form_sp");
                            var newOption= document.createElement("option");
                            var newOptionVal= document.createTextNode(sp.ten);
                            newOption.setAttribute("value", sp.id);
                            newOption.appendChild(newOptionVal);
                            select.insertBefore(newOption, select.firstChild);
                        }
                        console.log("-------------get---------------");
                        console.log(result.data);
                    } else {
                        console.log("Fail: ", result);
                    }
                },
                error: function (e) {
                    console.log("ERROR: ", e);
                }
            });
        }
        // End sản phẩm

        // Màu sắc
        $("#quick_create_ms").submit(function (event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPostMS();
        });

        //Do post
        function ajaxPostMS() {
            // PREPARE FORM DATA
            var data = {
                ten: $("#quick_create_ms #tenMS").val(),
                trangThai: $("#quick_create_ms input[name='trangThai']:checked").val()
            };
            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "http://localhost:8080/shop-xe/san-pham-chi-tiet/ms/add",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    if (result.status == "success") {
                        console.log("-------------post---------------");
                        console.log(data);
                        msModal.hide();
                        alert("Success")
                        ajaxGetMS();
                    } else {
                        alert("Fail")
                        console.log("fail");
                    }
                    console.log(result);
                },
                error: function (e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });
        }

        // DO GET
        function ajaxGetMS() {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/shop-xe/san-pham-chi-tiet/ms/getAll",
                success: function (result) {
                    const ms = result.data;
                    if (result.status == "success") {
                        if (ms.trangThai==0){
                            var select= document.getElementById("form_ms");
                            var newOption= document.createElement("option");
                            var newOptionVal= document.createTextNode(ms.ten);
                            newOption.setAttribute("value", ms.id);
                            newOption.appendChild(newOptionVal);
                            select.insertBefore(newOption, select.firstChild);
                        }
                        console.log("-------------get---------------");
                        console.log(result.data);
                    } else {
                        console.log("Fail: ", result);
                    }
                },
                error: function (e) {
                    console.log("ERROR: ", e);
                }
            });
        }
        //End màu sắc

        // Kiểu dáng xe
        $("#quick_create_kdx").submit(function (event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPostKDX();
        });

        //Do post
        function ajaxPostKDX() {
            // PREPARE FORM DATA
            var data = {
                ten: $("#quick_create_kdx #tenKDX").val(),
                trangThai: $("#quick_create_kdx input[name='trangThai']:checked").val()
            };
            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "http://localhost:8080/shop-xe/san-pham-chi-tiet/kdx/add",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    if (result.status == "success") {
                        console.log("-------------post---------------");
                        console.log(data);
                        kdxModal.hide();
                        alert("Success")
                        ajaxGetKDX();
                    } else {
                        alert("Fail")
                        console.log("fail");
                    }
                    console.log(result);
                },
                error: function (e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });
        }

        // DO GET
        function ajaxGetKDX() {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/shop-xe/san-pham-chi-tiet/kdx/getAll",
                success: function (result) {
                    const kdx = result.data;
                    if (result.status == "success") {
                        if (kdx.trangThai==0){
                            var select= document.getElementById("form_kdx");
                            var newOption= document.createElement("option");
                            var newOptionVal= document.createTextNode(kdx.ten);
                            newOption.setAttribute("value", kdx.id);
                            newOption.appendChild(newOptionVal);
                            select.insertBefore(newOption, select.firstChild);
                        }
                        console.log("-------------get---------------");
                        console.log(result.data);
                    } else {
                        console.log("Fail: ", result);
                    }
                },
                error: function (e) {
                    console.log("ERROR: ", e);
                }
            });
        }
        //End kiểu dáng xe

        // Kích thước
        $("#quick_create_kt").submit(function (event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPostKT();
        });

        //Do post
        function ajaxPostKT() {
            // PREPARE FORM DATA
            var data = {
                ten: $("#quick_create_kt #tenKT").val(),
                trangThai: $("#quick_create_kt input[name='trangThai']:checked").val()
            };
            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "http://localhost:8080/shop-xe/san-pham-chi-tiet/kt/add",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    if (result.status == "success") {
                        console.log("-------------post---------------");
                        console.log(data);
                        ktModal.hide();
                        alert("Success")
                        ajaxGetKT();
                    } else {
                        alert("Fail")
                        console.log("fail");
                    }
                    console.log(result);
                },
                error: function (e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });
        }

        // DO GET
        function ajaxGetKT() {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/shop-xe/san-pham-chi-tiet/kt/getAll",
                success: function (result) {
                    const kt = result.data;
                    if (result.status == "success") {
                        if (kt.trangThai==0){
                            var select= document.getElementById("form_kt");
                            var newOption= document.createElement("option");
                            var newOptionVal= document.createTextNode(kt.ten);
                            newOption.setAttribute("value", kt.id);
                            newOption.appendChild(newOptionVal);
                            select.insertBefore(newOption, select.firstChild);
                        }
                        console.log("-------------get---------------");
                        console.log(result.data);
                    } else {
                        console.log("Fail: ", result);
                    }
                },
                error: function (e) {
                    console.log("ERROR: ", e);
                }
            });
        }
        //End kích thước

        // Thương hiệu
        $("#quick_create_th").submit(function (event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPostTH();
        });

        //Do post
        function ajaxPostTH() {
            // PREPARE FORM DATA
            var data = {
                ten: $("#quick_create_th #tenTH").val(),
                trangThai: $("#quick_create_th input[name='trangThai']:checked").val()
            };
            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "http://localhost:8080/shop-xe/san-pham-chi-tiet/th/add",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    if (result.status == "success") {
                        console.log("-------------post---------------");
                        console.log(data);
                        thModal.hide();
                        alert("Success")
                        ajaxGetTH();
                    } else {
                        alert("Fail")
                        console.log("fail");
                    }
                    console.log(result);
                },
                error: function (e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });
        }

        // DO GET
        function ajaxGetTH() {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/shop-xe/san-pham-chi-tiet/th/getAll",
                success: function (result) {
                    const th = result.data;
                    if (result.status == "success") {
                        if (th.trangThai==0){
                            var select= document.getElementById("form_th");
                            var newOption= document.createElement("option");
                            var newOptionVal= document.createTextNode(th.ten);
                            newOption.setAttribute("value", th.id);
                            newOption.appendChild(newOptionVal);
                            select.insertBefore(newOption, select.firstChild);
                        }
                        console.log("-------------get---------------");
                        console.log(result.data);
                    } else {
                        console.log("Fail: ", result);
                    }
                },
                error: function (e) {
                    console.log("ERROR: ", e);
                }
            });
        }
        //End thương hiệu
    })
