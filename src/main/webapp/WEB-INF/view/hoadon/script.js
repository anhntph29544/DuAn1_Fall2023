// script.js file

function domReady(fn) {
    if (
        document.readyState === "complete" ||
        document.readyState === "interactive"
    ) {
        setTimeout(fn, 1000);
    } else {
        document.addEventListener("DOMContentLoaded", fn);
    }
}

domReady(function () {

    // If found you qr code
    function onScanSuccess(decodeText, decodeResult) {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/hoa-don/them-san-pham-qr",
            data: JSON.stringify(decodeText),
            dataType: 'json',
            success: location.replace("http://localhost:8080/tao-hoa-don/hien-thi")
        });
    }

    let htmlscanner = new Html5QrcodeScanner(
        "my-qr-reader",
        { fps: 5, qrbos: 250 }
    );
    htmlscanner.render(onScanSuccess);
});
