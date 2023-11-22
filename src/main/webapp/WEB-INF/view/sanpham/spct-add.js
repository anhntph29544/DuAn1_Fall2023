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
        const myModal= new bootstrap.Modal('#sanPham');
        // SUBMIT FORM
        $("#quick_create_sp").submit(function (event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPost();
        });

        //Do post
        function ajaxPost() {
            // PREPARE FORM DATA
            var data = {
                ten: $("#quick_create_sp #ten").val(),
                trangThai: $("#quick_create_sp #trangThaiSP1").val() == 0 ? 0 : 1
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
                        myModal.hide();
                        alert("Success")
                        ajaxGet();
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
        function ajaxGet() {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/shop-xe/san-pham-chi-tiet/sp/getAll",
                success: function (result) {
                    const sp = result.data;
                    if (result.status == "success") {
                        var select= document.getElementById("form_sp");
                        var newOption= document.createElement("option");
                        var newOptionVal= document.createTextNode(sp.ten);
                        newOption.setAttribute("value", sp.id);
                        newOption.appendChild(newOptionVal);
                        select.insertBefore(newOption, select.firstChild);
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
    })
