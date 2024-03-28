import dbStuff.DBList;
import dbStuff.DBMethods;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//@WebServlet(name = "GetAllServlet", value = "/GetAllServlet")
public class GetAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBMethods method = new DBMethods();
        ArrayList<DBList> items = method.getAll();

        PrintWriter out = response.getWriter();


        out.println("<html>");
        out.println("<h1> Get All </h1>");
        for (DBList item : items){
            out.println("<p>" + item + "</p>");
        }
        out.println("<p>" + "<a href=\"" + response.encodeURL("/main") +
                "\">Go back to main menu</a>" + "</p>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}