package controller;

import model.Category;
import model.Post;
import service.CategoryService;
import service.PostService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminPost", urlPatterns = "/admin-post")
public class AdminPost extends HttpServlet {

    PostService postService=new PostService();
    CategoryService categoryService=new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddView(request, response);
                break;
            case "edit":
                showEditView(request, response);
                break;
            case "delete":
                doDeletePost(request, response);
                break;
            default:
                showListView(request, response);
                break;

        }
    }

    private void showAddView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Post post=new Post();
        List<Category> categoryList=categoryService.findAll();
        request.setAttribute("post",post);
        request.setAttribute("list",categoryList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("blog/admin-post-add.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        Post post=postService.findById(id);
        List<Category> categoryList=categoryService.findAll();
        if(post !=  null){
            request.setAttribute("post",post);
            request.setAttribute("list",categoryList);
            RequestDispatcher dispatcher=request.getRequestDispatcher("blog/admin-post-edit.jsp");
            dispatcher.forward(request,response);
        }else {
            response.sendRedirect("404");
        }
    }

    private void doDeletePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        postService.remove(id);
        request.setAttribute("message","Delete Success");
        showListView(request,response);
    }

    private void showListView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> postList = postService.findAll();
        request.setAttribute("list",postList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("blog/admin-post-list.jsp");
        dispatcher.forward(request,response);
    }

    @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
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
        String title = request.getParameter("title");
        String shortContent = request.getParameter("shortContent");
        String longContent=request.getParameter("longContent");
        String image=request.getParameter("image");
        int idCategory= Integer.parseInt(request.getParameter("category"));
        postService.save(new Post(title,shortContent,longContent,image,new Category(idCategory)));

        request.setAttribute("message","Add Success!");
        showAddView(request, response);
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String shortContent = request.getParameter("shortContent");
        String longContent=request.getParameter("longContent");
        String image=request.getParameter("image");
        int idCategory= Integer.parseInt(request.getParameter("category"));
        postService.save(new Post(id,title,shortContent,longContent,image,new Category(idCategory)));

        request.setAttribute("message","Edit Success!");
        showEditView(request, response);
    }
}
