package controller;

import model.Category;
import model.Post;
import model.StatisticDTO;
import service.CategoryService;
import service.PostService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = "/home")
public class HomeController extends HttpServlet {
    PostService postService=new PostService();
    CategoryService categoryService=new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> listTop2 =postService.findTop2();
        List<Post> listTop6=postService.findTop6();
        List<Post> listTop6Down=postService.findTop6Down();

        Post postTop1Views=postService.findTop1Views();

        List<Post> listTop3Views=postService.findTop3Views();
        List<Post> listTop4Views=postService.findTop4Views();
        List<Post> listTop2Tournaments=postService.findTop2Tournaments();

        Post postReviewTop=postService.findTop1ReviewViews();
        Post postGameplayTop=postService.findTop1GameplayViews();
        Post postHighlightTop=postService.findTop1HighlightViews();

        System.out.println(postReviewTop);

        List<Category> listCategory=categoryService.findAll();

        List<StatisticDTO> listSumCategory=postService.sumCategory();


        request.setAttribute("listTop2",listTop2);
        request.setAttribute("listTop6",listTop6);
        request.setAttribute("listTop6Down",listTop6Down);

        request.setAttribute("postTop1Views",postTop1Views);

        request.setAttribute("listTop3Views",listTop3Views);
        request.setAttribute("listTop4Views",listTop4Views);
        request.setAttribute("listTop2Tournaments",listTop2Tournaments);

        request.setAttribute("postReviewTop",postReviewTop);
        request.setAttribute("postGameplayTop",postGameplayTop);
        request.setAttribute("postHighlightTop",postHighlightTop);

        request.setAttribute("listCategory",listCategory);

        request.setAttribute("listSumCategory",listSumCategory);



        RequestDispatcher dispatcher=request.getRequestDispatcher("blog/home.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
