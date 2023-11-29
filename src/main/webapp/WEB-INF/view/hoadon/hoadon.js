$(document).ready(
    function () {
        $("#tao-hoa-don").submit(function (event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPost();
        });

        //Do post
        function ajaxPost() {
            // PREPARE FORM DATA
            var data = {
                tinhTrang: 0
            };
            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "http://localhost:8080/hoa-don/add",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    if (result.status == "success") {
                        console.log("-------------post---------------");
                        console.log(data);
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
        function ajaxGet() {
            let chuaTT = "Chưa Thanh Toán";
            let chuaTTVN = decodeURIComponent(escape(chuaTT));
            let daTT = "Đã Thanh Toán";
            let daTTVN = decodeURIComponent(escape(daTT));
            let huy = "Hủy";
            let huydt = decodeURIComponent(escape(huy));
            let click = "Nút đã được click";
            let clickct = decodeURIComponent(escape(click));
            $.ajax({

                type: "GET",
                url: "http://localhost:8080/hoa-don/get",
                success: function (result) {
                    const hd = result.data;
                    if (result.status == "success") {
                        var newTbody = document.getElementById("hoa-don-cho");
                        var newTR = document.createElement("nav-item");
                        var newTD1 = document.createElement("nav-link");
                        // var newTD2 = document.createElement("td");
                        // var newTD3 = document.createElement("td");
                        // var newTD4 = document.createElement("td");
                        // var newTD5 = document.createElement("td");
                        var newTDVal1 = document.createTextNode(hd.ma);
                        // var newTDVal2 = document.createTextNode("");
                        // var newTDVal3 = document.createTextNode("");
                        // var newTDVal4 = document.createTextNode(hd.tinhTrang == 0 ? chuaTTVN : daTTVN);
                        // var newTDVal5 = document.createElement("button");
                        // newTDVal5.innerText = huydt; // Đặt nội dung của nút ở đây
                        // newTDVal5.classList.add("btn", "btn-info"); // Thêm các lớp CSS để tạo nút giống như btn btn-primary
                        // newTDVal5.addEventListener("click", function () {
                        //     // Xử lý sự kiện khi nút được click
                        //
                        //     alert(clickct);
                        // });
                        // newTD1.setAttribute("value", sp.id);
                        newTD1.appendChild(newTDVal1);
                        // newTD2.appendChild(newTDVal4);
                        // newTD3.appendChild(newTDVal3);
                        // newTD4.appendChild(newTDVal2);
                        // newTD5.appendChild(newTDVal1);
                        newTR.insertBefore(newTD1, newTR.firstChild);
                        // newTR.insertBefore(newTD2, newTR.firstChild);
                        // newTR.insertBefore(newTD3, newTR.firstChild);
                        // newTR.insertBefore(newTD4, newTR.firstChild);
                        // newTR.insertBefore(newTD5, newTR.firstChild);
                        newTbody.insertBefore(newTR, newTbody.firstChild);
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

    }
)