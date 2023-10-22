<!-- The isELIgnored="false" attribute ensures that EL expressions are evaluated.
    such as ${users}, ${1 + 1}... -->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!-- For c: taglib to work -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <h1>Users</h1>

    <c:forEach var="usr" items="${users}">
        <p>name: ${usr}</p>
    </c:forEach>

    <p>1 + 1 would equal to ${ 1 + 1 }</p>
</body>
</html>
