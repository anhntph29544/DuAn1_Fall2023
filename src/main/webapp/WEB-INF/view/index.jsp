<!DOCTYPE html>
<html lang="vi">
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Đăng nhập | Trang Đăng Nhập Mới</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Sử dụng Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Sử dụng Font Awesome cho biểu tượng -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- CSS tùy chỉnh -->
    <style>
        body {
            background-color: #f0f0f0;
        }

        .login-container {
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 30px;
            max-width: 400px;
            margin: 0 auto;
            margin-top: 100px;
        }

        .login-title {
            font-size: 24px;
            text-align: center;
        }

        .login-input {
            border-radius: 25px;
            padding: 10px;
            margin: 10px 0;
        }

        .login-btn {
            background: #007bff;
            color: #fff;
            border: none;
            border-radius: 25px;
            padding: 10px 20px;
        }

        .login-btn:hover {
            background: #0056b3;
        }

        /* Tùy chỉnh nút hiển thị mật khẩu */
        .show-password-button {
            position: absolute;
            top: 50%;
            right: 10px;
            transform: translateY(-50%);
            cursor: pointer;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="login-container">
        <h2 class="login-title">Đăng nhập</h2>
        <f:form class="login-form" action="/shop-xe/login" method="post">
            <div class="form-group">
                <input type="text" class="form-control login-input" placeholder="Email đăng nhập" name="username">
            </div>
            <div class="form-group position-relative">
                <input type="password" class="form-control login-input" placeholder="Mật khẩu" id="password" name="password">
                <i class="fa fa-eye-slash show-password-button" id="togglePassword"></i>
            </div>
            <button type="submit" class="btn btn-primary login-btn">Đăng nhập</button>
        </f:form>
        <div class="text-center mt-3">
            <a href="/forgot.html">Bạn quên mật khẩu?</a>
        </div>
    </div>
</div>

<!-- Sử dụng Bootstrap và jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    const passwordField = document.getElementById("password");
    const togglePassword = document.getElementById("togglePassword");

    togglePassword.addEventListener("click", function () {
        if (passwordField.type === "password") {
            passwordField.type = "text";
            togglePassword.classList.remove("fa-eye-slash");
            togglePassword.classList.add("fa-eye");
        } else {
            passwordField.type = "password";
            togglePassword.classList.remove("fa-eye");
            togglePassword.classList.add("fa-eye-slash");
        }
    });
</script>
</body>
</html>
