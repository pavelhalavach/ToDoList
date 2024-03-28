import dbStuff.DBMethods;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBMethods method = new DBMethods();
        PrintWriter out = response.getWriter();
        String title = request.getParameter("title");
        String desc = request.getParameter("desc");
        String dueDate = request.getParameter("dueDate");
        method.insertNew(title, desc, dueDate);


        out.println("<html>");
        out.println("<h1> Insert new </h1>");
        out.println("<p> title: " + title + ", desc: " + desc + ", dueDate: " + dueDate + "</p>");
        out.println("<p>" + "<a href=\"" + response.encodeURL("/main") +
                "\">Go back to main menu</a>" + "</p>");
        out.println("</html>");


    }

}