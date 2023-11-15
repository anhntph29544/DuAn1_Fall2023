$(document).ready(function(){
    $('#sp1').submit(function(e){
        console.log($('#sp1').serialize())
        e.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/shop-xe/san-pham-chi-tiet/sp/add',
            dataType: 'json',
            data: $('#sp1').serialize(),
            success: function (){
                alert("Thành công")
            }
        });
    });
});

