<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 3/28/2024
  Time: 1:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
    <h1>
        Delete
    </h1>

    <%@page import="java.util.ArrayList" %>
    <%@ page import="dbStuff.DBMethods" %>
    <%@ page import="dbStuff.DBList" %>
    <%
        DBMethods method = new DBMethods();
        ArrayList<DBList> items = method.getAll();
    %>

    <form action="/task-removal-done" method="post" >
        Title:
        <select name = "title">
            <% for (DBList value : items) { %>
            <option value="<%= value %>"><%= value %></option>
            <% } %>
        </select>
        <input type="submit" value="Submit" />
    </form>

    <p>
        <a href="/main">Go back to main menu</a>
    </p>

</body>
</html>
