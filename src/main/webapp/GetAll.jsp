<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 3/27/2024
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get All</title>
</head>
<body>
    <h1> GET ALL</h1>
    <%@ page import="dbStuff.DBMethods"%>
    <% DBMethods method = new DBMethods();%>
    <% method.getAll();%>

    <p>
        <a href="/main">Go back to main menu</a>
    </p>
</body>
</html>
