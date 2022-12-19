<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add User</title>
</head>
<body>
    <form action="home/addUser" method="post">
        id: <input type="text" name="userId"> <br/>
        name: <input type="text" name="userName"> <br/>
        <input type="submit" value="add">
    </form>
</body>
</html>