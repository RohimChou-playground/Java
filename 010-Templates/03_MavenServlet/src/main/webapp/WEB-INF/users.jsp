<%@ page import="java.util.*,com.rohim.models.User" %>
<html>
<head>
    <title>Users</title>
    <link href="static/main.css" rel="stylesheet">
</head>

<body>
    <a href="./">home</a>

    <h1>Users</h1>
    <% 
        List<User> users = (List<User>)request.getAttribute("users");
        for (User u : users) {
    %>
        <p> <%= u.getUid() %> : <%= u.getUname() %> </p>
    <%
        }
    %>

    <p>total users: ${ users.size() }</p>

    <form action="addUser" method="post">
        <div>id: <input type="text" name="uid" /></div>
        <div>name: <input type="text" name="uname" /></div>
        <input type="submit" value="add user" />
    </form>
</body>
</html>