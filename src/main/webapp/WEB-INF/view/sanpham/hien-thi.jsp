<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSPCT.content}" var="spct">
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>