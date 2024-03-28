import dbStuff.DBMethods;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "GetOneServlet", value = "/GetOneServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBMethods method = new DBMethods();
        method.delete(request.getParameter("title"));
        PrintWriter out = response.getWriter();


        out.println("<html>");
        out.println("<h1> Successfully deleted! </h1>");
        out.println("<p>" + "<a href=\"" + response.encodeURL("/main") +
                "\">Go back to main menu</a>" + "</p>");
        out.println("</html>");

    }
}