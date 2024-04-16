<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 3/28/2024
  Time: 2:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <h1>Update</h1>

    <%@ page import="java.util.ArrayList" %>
    <%@ page import="dbStuff.DBMethods" %>
    <%@ page import="dbStuff.DBList" %>
    <%
        DBMethods method = new DBMethods();
        ArrayList<DBList> items = method.getAll();
    %>

    <p> Choose what task to update</p>
    <% if(request.getParameter("title") == null) { %>
        <form action="/task-update" method="post" >
            Title:
            <select name = "title">
                <% for (DBList value : items) { %>
                <option value="<%= value %>"><%= value %></option>
                <% } %>
            </select> <br></br>
            <input type="submit" value="Submit" />
        </form>
    <% } else {%>
        <form action="/task-update" method="post" >
            Title:
            <select name = "title">
                <% for (DBList value : items) { %>
                <option value="<%= value %>"><%= value %></option>
                <% } %>
            </select> <br></br>
            <input type="submit" value="Submit" />
        </form>
    <% DBList list = method.getOne(request.getParameter("title"));%>
    <hr></hr>
    <p>Options you can change:</p>
        <form action="/task-update-done" method="post" enctype="multipart/form-data">
            <br></br> Id: <input type="text" name = "id" value = '<%=list.getId()%>' readonly/>
            <br></br> Title: <input type="text" name = "title" value = '<%=list.getTitle()%>' required/>
            <br></br> Description: <input type="text" name = "desc" value = '<%=list.getDesc()%>' required/>
            <br></br> Attachment: <input type = "file" name = "attach"/>
            <br></br> DueDate: <input type="date" name = "dueDate" value="<%=list.getDueDate()%>"/>
            <br></br> <input type="submit"  value="Submit"/>
        </form>
    <%}%>

    <p>
        <a href="/main">Go back to main menu</a>
    </p>


</body>
</html>
