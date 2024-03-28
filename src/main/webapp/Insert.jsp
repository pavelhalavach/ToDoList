<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 3/27/2024
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
    <h1>
        Add
    </h1>

    <form action="/new-task-done" method="post">
        Title: <input type="text" name = "title" required/>
        <br></br> Description: <input type="text" name = "desc" required/>
        <br></br> Attachment(пока не работает. не разобрался как файлы сохранять в базе данных): <input type = "file" name = "attach" size = "50" />
        <br></br> DueDate: <input type="date" name = "dueDate"/>
        <br></br> <input type="submit"  value="Submit" />
    </form>

    <p>
        <a href="/main">Go back to main menu</a>
    </p>
</body>
</html>
