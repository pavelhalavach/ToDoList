import dbStuff.DBMethods;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        DBMethods method = new DBMethods();

        out.println("<html>");
        out.println("<h1> ToDo List </h1>");
//       GetAllServlet
        out.println("<p>" + "<a href=\"" + response.encodeURL("/list-of-tasks") +
                "\">Show all tasks to do</a>" + "</p>");
//        GetOne.jsp -> GetOneServlet
        out.println("<p>" + "<a href=\"" + response.encodeURL("/task-info") +
                "\">Show info about one task by title</a>" + "</p>");
//        Insert.jsp -> InsertServlet
        out.println("<p>" + "<a href=\"" + response.encodeURL("/new-task") +
                "\">Add new task</a>" + "</p>");
//        Update.jsp -> UpdateServlet
        out.println("<p>" + "<a href=\"" + response.encodeURL("/task-update") +
                "\">Update a task</a>" + "</p>");
//        Delete.jsp -> DeleteServlet
        out.println("<p>" + "<a href=\"" + response.encodeURL("/task-removal") +
                "\">Delete a task</a>" + "</p>");
        out.println("</html>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}