$(document).ready(function(){
    $('#quick_create_sp').submit(async function(e){
        e.preventDefault();
        const url = 'http://localhost:8080/shop-xe/api/san-pham-chi-tiet/sp';
        // $.ajax({
        //     type: 'POST',
        //     url,
        //     dataType: 'json',
        //     data: $('#quick_create_sp').serialize(),
        //     success: function (){
        //         alert("Thành công")
        //     }
        // });

        const data = {
            ten: $("#quick_create_sp #ten").val(),
            trangThai: $("#quick_create_sp #trangThaiSP1").val() == 0 ? 0 : 1
        };
        try {
            const response = await fetch(url, {
                method: 'POST',
                mode: "cors",
                headers: {
                    "Content-Type": "application/json",
                },
                body: data
            });
            console.log(response)
        } catch (e) {
            console.error(e)
        }
    });
});

