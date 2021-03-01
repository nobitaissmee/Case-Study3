package controller;

import model.Category;
import service.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCategory", urlPatterns = "/admin-category")
public class AdminCategory extends HttpServlet {

    private final CategoryService categoryService=new CategoryService();

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
                doDeleteCategory(request,response);
                break;
            default:
                showListView(request,response);
                break;
        }
    }

    private void showAddView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category cate=new Category();
        request.setAttribute("cate",cate);
        RequestDispatcher dispatcher=request.getRequestDispatcher("blog/admin-category-add.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        Category cate=categoryService.findById(id);
        if(cate !=  null){
            request.setAttribute("cate",cate);
            RequestDispatcher dispatcher=request.getRequestDispatcher("blog/admin-category-edit.jsp");
            dispatcher.forward(request,response);
        }else {
            response.sendRedirect("404");
        }
    }

    private void doDeleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        categoryService.remove(id);
        request.setAttribute("message","Delete Success");
        showListView(request,response);
    }

    private void showListView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("list",categoryList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("blog/admin-category-list.jsp");
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
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Category cate = new Category(name,description);
        categoryService.save(cate);

        request.setAttribute("message","Add Success!");
        showAddView(request, response);
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int id = Integer.parseInt(request.getParameter("id"));
        Category cate = new Category(id,name,description);

        categoryService.update(cate);

        request.setAttribute("message","Update Success!");
        showEditView(request, response);
    }
}
