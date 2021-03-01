package controller;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AuthenticationController", urlPatterns = "/authentication")
public class AuthenticationController extends HttpServlet {
    UserService userService = new UserService();

    public AuthenticationController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "login";
        }
        switch (action) {
            case "login":
                showLoginForm(request, response);
                break;
            case "logout":
                showLogout(request,response);
                break;
            case "register":
                showRegisterForm (request,response);
                break;
        }
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        session.invalidate();
        RequestDispatcher dispatcher= request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request,response);
    }


    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher=request.getRequestDispatcher("register.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "login";
        }
        switch (action) {
            case "login":
                doLogin(request, response);
                break;
            case "register":
                doAdd(request,response);
                break;
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        User user= userService.findUserByUANDP(username,password);
        HttpSession session =request.getSession();
        if(user != null && user.getStatus() != 3){
            session.setAttribute("username",user.getUsername());
            session.setAttribute("user",user);
            session.setAttribute("status",user.getStatus());
            response.sendRedirect("home");
        } else {
            session.setAttribute("message","Username or password illegal.Please try again");
            response.sendRedirect("authentication");
        }
    }


    private void doAdd(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList=userService.findAll();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String fullname=request.getParameter("fullname");

        User user=new User(username,password,fullname);

        HttpSession session=request.getSession();
        for(User user1:userList){
            if(user1.getUsername().equals(user.getUsername())){
                session.invalidate();
                request.setAttribute("message","UserName existed!");
                showRegisterForm(request,response);
                break;
            }
        }
        userService.save(user);
        showLoginForm(request,response);
    }
}