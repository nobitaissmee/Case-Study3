package controller;

import model.Category;
import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminUser", urlPatterns = "/admin-user")
public class AdminUser extends HttpServlet {
    UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action== null){
            action="";
        }
        switch (action){
            case "add":
                showAddView(request,response);
                break;
            case "edit":
                showEditView(request,response);
                break;
            case "delete":
                doDeleteUser(request,response);
                break;
            default:
                showListView(request,response);
                break;
        }
    }

    private void showAddView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        request.setAttribute("user",user);
        RequestDispatcher dispatcher=request.getRequestDispatcher("blog/admin-user-add.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        User user=userService.findById(id);
        if(user !=  null){
            request.setAttribute("user",user);
            RequestDispatcher dispatcher=request.getRequestDispatcher("blog/admin-user-edit.jsp");
            dispatcher.forward(request,response);
        }else {
            response.sendRedirect("404");
        }
    }

    private void doDeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        userService.remove(id);
        request.setAttribute("message","Delete Success");
        showListView(request,response);
    }

    private void showListView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList=userService.findAll();
        request.setAttribute("list",userList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("blog/admin-user-list.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");
        if (username == null || username.isEmpty()) {
            response.sendRedirect("authentication");
        }

        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "add":
                doAdd(request, response);
                break;
            case "edit":
                doEdit(request, response);
                break;
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String fullname=request.getParameter("fullname");

        int status= Integer.parseInt(request.getParameter("status"));

        User user=new User(username,password,fullname,status);

        userService.saveWithStatus(user);
        showAddView(request,response);
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String fullname=request.getParameter("fullname");

        int status= Integer.parseInt(request.getParameter("status"));

        User user=new User(username,password,fullname,status);

        userService.saveWithStatus(user);
        showEditView(request,response);
    }
}
