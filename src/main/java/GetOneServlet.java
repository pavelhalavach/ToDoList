import dbStuff.DBList;
import dbStuff.DBMethods;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "GetOneServlet", value = "/GetOneServlet")
public class GetOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBMethods method = new DBMethods();
        DBList list = method.getOne(request.getParameter("title"));
        PrintWriter out = response.getWriter();


        out.println("<html>");
        out.println("<h1> Get One </h1>");
        out.println("<p>" + "id: "+list.getId()+", title: "+
                list.getTitle()+", desc: "+ list.getDesc()+
                ", attach: "+ list.getAttach()+", dueDate: "+
                list.getDueDate()+", createdAt: " + list.getCreatedAt() + "</p>");
        out.println("<p>" + "<a href=\"" + response.encodeURL("/main") +
                "\">Go back to main menu</a>" + "</p>");
        out.println("</html>");

    }
}