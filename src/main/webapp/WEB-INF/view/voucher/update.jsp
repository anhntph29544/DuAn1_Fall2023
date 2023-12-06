<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        h1 {
            color: #007bff;
            margin-bottom: 20px;
            text-align: center;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
            width: 350px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #495057;
        }

        input[type="date"],
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        button {
            background-color: #28a745;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }

        /* Optional: Add some spacing between the forms */
        form + form {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<form action="/voucher/update" method="post"  modelAttribute ="vc">
    Mã: <input type="text" name="ma" value="${vc.ma}">
    <br>
    Số lượng: <input type="text" name="soLuong" value="${vc.soLuong}">
    <br/>
    Giá trị: <input type="text" name="giaTri" value="${vc.giaTri}">
    <br>
    Ngày Bắt Đầu: <input type="date" name="ngayBD" value="${vc.ngayBD}">
    <br>
    Ngày Kết Thúc: <input type="date" name="ngayKT" value="${vc.ngayKT}">
    <br>
    <button type="submit">update</button>
</form>
</body>
</html>