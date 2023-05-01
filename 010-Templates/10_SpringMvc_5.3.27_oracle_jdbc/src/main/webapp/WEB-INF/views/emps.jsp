<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Emps</title>
</head>
<body>

    <h1>Employees</h1>
    <c:forEach var="emp" items="${emps}">
        <p>name: ${emp}</p>
    </c:forEach>

    <a href="./">home</a>
</body>
</html>
