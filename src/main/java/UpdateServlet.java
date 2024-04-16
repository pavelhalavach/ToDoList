import dbStuff.DBList;
import dbStuff.DBMethods;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@MultipartConfig
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBMethods method = new DBMethods();
        Part attach = request.getPart("attach");
        method.update(Integer.parseInt(request.getParameter("id")),
                request.getParameter("title"),request.getParameter("desc"), attach.getInputStream(),request.getParameter("dueDate"));
        PrintWriter out = response.getWriter();


        out.println("<html>");
        out.println("<h1> Updated. </h1>");
        out.println("<p>" + "<a href=\"" + response.encodeURL("/main") +
                "\">Go back to main menu</a>" + "</p>");
        out.println("</html>");
        out.println("</html>");
    }
}