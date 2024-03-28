<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 3/27/2024
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get One</title>
</head>
<body>
    <h1>
        Get One
    </h1>

    <%@page import="java.util.ArrayList" %>
    <%@ page import="dbStuff.DBMethods" %>
    <%@ page import="dbStuff.DBList" %>
    <%
        DBMethods method = new DBMethods();
        ArrayList<DBList> items = method.getAll();
    %>

<%--    <form action="/get-one" method="post" >--%>
<%--        Title: <input type="text" name = "title"/>--%>
<%--        <input type="submit" value="Submit" />--%>
<%--    </form>--%>

    <form action="/task-info-given" method="post" >
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
