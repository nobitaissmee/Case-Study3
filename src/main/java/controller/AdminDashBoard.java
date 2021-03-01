package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminDashBoard", urlPatterns = "/dashboard")
public class AdminDashBoard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int status= (int) session.getAttribute("status");
        if (username == null || username.isEmpty()) {
            response.sendRedirect("authentication");
        } else {
                request.setAttribute("status",status);
                RequestDispatcher dispatcher = request.getRequestDispatcher("blog/admin-dashboard.jsp");
                dispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
