
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
        // DO GET
        function ajaxGet() {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/hoa-don/get",
                success: function (result) {
                    const hd = result.data;
                    if (result.status == "success") {
                        var newTbody= document.getElementById("hoa-don-cho");
                        var newTR = document.createElement("tr");
                        var newTD1= document.createElement("td");
                        var newTD2= document.createElement("td");
                        var newTD3= document.createElement("td");
                        var newTD5= document.createElement("td");
                        var newTDVal1= document.createTextNode(hd.ma);
                        var newTDVal2= document.createTextNode("");
                        var newTDVal3= document.createTextNode("");
                        var newTDVal5= document.createTextNode(hd.tinhTrang==0?"Chưa Thanh Toán":"Đã Thanh Toán");
                        // newTD1.setAttribute("value", sp.id);
                        newTD1.appendChild(newTDVal5);
                        newTD2.appendChild(newTDVal3);
                        newTD3.appendChild(newTDVal2);
                        newTD5.appendChild(newTDVal1);
                        newTR.insertBefore(newTD1, newTR.firstChild);
                        newTR.insertBefore(newTD2, newTR.firstChild);
                        newTR.insertBefore(newTD3, newTR.firstChild);
                        newTR.insertBefore(newTD5, newTR.firstChild);
                        newTbody.insertBefore(newTR,newTbody.firstChild);
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