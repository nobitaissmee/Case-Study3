<%--
  Created by IntelliJ IDEA.
  User: Nobita
  Date: 2/28/2021
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>VALORANT BLOG</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:700%7CNunito:300,600" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet"
          href="${pageContext.servletContext.contextPath}/ui-assets/css/bootstrap.min.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/ui-assets/css/font-awesome.min.css">

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath}/ui-assets/css/style.css"/>
</head>
<body>
<!-- Header -->
<header id="header">
    <!-- Nav -->
    <div id="nav">
        <!-- Main Nav -->
        <div id="nav-fixed">
            <div class="container">
                <!-- logo -->
                <div class="nav-logo">
                    <a href="home" class="logo"><img
                            src="${pageContext.servletContext.contextPath}/ui-assets/img/logo.png" alt="" style="width: 114px;height: 61px"></a>
                </div>
                <!-- /logo -->

                <!-- nav -->
                <ul class="nav-menu nav navbar-nav">
                    <li><a href="#">News</a></li>
                    <li><a href="#">Preview</a></li>
                    <li class="cat-1"><a href="#">Video</a></li>
                    <li class="cat-2"><a href="#">Gameplay</a></li>
                    <li class="cat-3"><a href="#">Live</a></li>
                    <li class="cat-4"><a href="#">Tournaments</a></li>
                </ul>
                <!-- /nav -->

                <!-- search & aside toggle -->
                <div class="nav-btns">
                    <button class="aside-btn"><i class="fa fa-bars"></i></button>
                </div>
                <!-- /search & aside toggle -->
            </div>
        </div>
        <!-- /Main Nav -->

        <!-- Aside Nav -->
        <div id="nav-aside">
            <!-- nav -->
            <div class="section-row">
                <ul class="nav-aside-menu">
                    <li><a href="home">Home</a></li>
                    <li><a href="about.html">About Us</a></li>
                    <li><a href="#">Join Us</a></li>
                    <li><a href="#">Advertisement</a></li>
                    <li><a href="contact.html">Contacts</a></li>
                </ul>
            </div>
            <!-- /nav -->

            <!-- widget posts -->
            <div class="section-row">
                <h3>Recent Posts</h3>
                    <c:forEach items="${listTop3Views}" var="post">
                        <div class="post post-widget">
                            <a class="post-img" href="#"><img
                                    src="${pageContext.servletContext.contextPath}/${post.image}" alt=""></a>
                            <div class="post-body">
                                <h3 class="post-title"><a href="#">${post.title}</a></h3>
                            </div>
                        </div>
                    </c:forEach>
                <!-- /widget posts -->

                <!-- social links -->
                <div class="section-row">
                    <h3>Follow us</h3>
                    <ul class="nav-aside-social">
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                    </ul>
                </div>
                <!-- /social links -->

                <!-- aside nav close -->
                <button class="nav-aside-close"><i class="fa fa-times"></i></button>
                <!-- /aside nav close -->
            </div>
            <!-- Aside Nav -->
        </div>
    </div>
    <!-- /Nav -->
</header>
<!-- /Header -->

<!-- section -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- post -->
            <c:forEach items="${listTop2}" var="post">
                <div class="col-md-6">
                    <div class="post post-thumb">
                        <a class="post-img" href="#"><img
                                src="${pageContext.servletContext.contextPath}/${post.image}" alt=""></a>
                        <div class="post-body">
                            <div class="post-meta">
                                <a class="post-category cat-2" href="#">${post.category.name}</a>
                                <span class="post-date">${post.pulishDate}</span>
                            </div>
                            <h3 class="post-title"><a href="#">${post.title}</a></h3>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <!-- /post -->
        </div>
        <!-- /row -->

        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="section-title">
                    <h2>Recent Posts</h2>
                </div>
            </div>

            <!-- post -->
            <c:forEach begin="0" end="5" var="index" >
                <c:set var="post" value='${listTop6.get(index)}' />
                <div class="col-md-4">
                    <div class="post">
                        <a class="post-img" href="#"><img
                                src="${pageContext.servletContext.contextPath}/${post.image}" alt=""></a>
                        <div class="post-body">
                            <div class="post-meta">
                                <a class="post-category cat-1" href="category.html">${post.category.name}</a>
                                <span class="post-date">${post.pulishDate}</span>
                            </div>
                            <h3 class="post-title"><a href="#">${post.title}</a></h3>
                        </div>
                    </div>
                </div>
                <c:if test="${index == 2}">
                    <div class="clearfix visible-md visible-lg"></div>
                </c:if>
            </c:forEach>
            <!-- /post -->
        </div>
        <!-- /row -->

        <!-- row -->
        <div class="row">
            <div class="col-md-8">
                <div class="row">
                    <!-- post -->
                    <div class="col-md-12">
                        <div class="post post-thumb">
                            <a class="post-img" href="#"><img
                                    src="${pageContext.servletContext.contextPath}/${postTop1Views.image}" alt=""></a>
                            <div class="post-body">
                                <div class="post-meta">
                                    <a class="post-category cat-3"
                                       href="category.html">${postTop1Views.category.name}</a>
                                    <span class="post-date">${postTop1Views.pulishDate}</span>
                                </div>
                                <h3 class="post-title"><a href="#">${postTop1Views.title}</a></h3>
                            </div>
                        </div>
                    </div>
                    <!-- /post -->

                    <!-- post -->
                    <c:forEach begin="0" end="5" var="index" >
                        <c:set var="post" value='${listTop6Down.get(index)}' />
                        <div class="col-md-6">
                            <div class="post">
                                <a class="post-img" href="#"><img
                                        src="${pageContext.servletContext.contextPath}/${post.image}" alt=""></a>
                                <div class="post-body">
                                    <div class="post-meta">
                                        <a class="post-category cat-4" href="category.html">${post.category.name}</a>
                                        <span class="post-date">${post.pulishDate}</span>
                                    </div>
                                    <h3 class="post-title"><a href="#">${post.title}</a></h3>
                                </div>
                            </div>
                        </div>
                        <c:if test="${index == 1 || index == 3}">
                            <div class="clearfix visible-md visible-lg"></div>
                        </c:if>
                    </c:forEach>
                    <!-- /post -->
                </div>
            </div>

            <div class="col-md-4">
                <!-- post widget -->
                <div class="aside-widget">
                    <div class="section-title">
                        <h2>Most Read</h2>
                    </div>
                    <c:forEach items="${listTop4Views}" var="post">
                        <div class="post post-widget">
                            <a class="post-img" href="#"><img
                                    src="${pageContext.servletContext.contextPath}/${post.image}" alt=""></a>
                            <div class="post-body">
                                <h3 class="post-title"><a href="#">${post.title}</a></h3>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <!-- /post widget -->

                <!-- post widget -->
                <div class="aside-widget">
                    <div class="section-title">
                        <h2>Tournaments Posts</h2>
                    </div>
                    <c:forEach items="${listTop2Tournaments}" var="post">
                        <div class="post post-thumb">
                            <a class="post-img" href="#"><img
                                    src="${pageContext.servletContext.contextPath}/${post.image}" alt=""></a>
                            <div class="post-body">
                                <div class="post-meta">
                                    <a class="post-category cat-3" href="category.html">${post.category.name}</a>
                                    <span class="post-date">${post.pulishDate}</span>
                                </div>
                                <h3 class="post-title"><a href="#">${post.title}</a></h3>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <!-- /post widget -->

                <!-- ad -->
                <div class="aside-widget text-center">
                    <a href="#" style="display: inline-block;margin: auto;">
                        <img class="img-responsive"
                             src="${pageContext.servletContext.contextPath}/ui-assets/img/ad-1.jpg" alt="">
                    </a>
                </div>
                <!-- /ad -->
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /section -->

<!-- section -->
<div class="section section-grey">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="section-title text-center">
                    <h2>Top View Posts</h2>
                </div>
            </div>

            <!-- post -->
            <div class="col-md-4">
                <div class="post">
                    <a class="post-img" href="#"><img
                            src="${pageContext.servletContext.contextPath}/${postGameplayTop.image}" alt=""></a>
                    <div class="post-body">
                        <div class="post-meta">
                            <a class="post-category cat-2" href="category.html">${postGameplayTop.category.name}</a>
                            <span class="post-date">${postGameplayTop.pulishDate}</span>
                        </div>
                        <h3 class="post-title"><a href="#">${postGameplayTop.title}</a></h3>
                    </div>
                </div>
            </div>
            <!-- /post -->

            <!-- post -->
            <div class="col-md-4">
                <div class="post">
                    <a class="post-img" href="#"><img
                            src="${pageContext.servletContext.contextPath}/${postReviewTop.image}" alt=""></a>
                    <div class="post-body">
                        <div class="post-meta">
                            <a class="post-category cat-3" href="category.html">${postReviewTop.category.name}</a>
                            <span class="post-date">${postReviewTop.pulishDate}</span>
                        </div>
                        <h3 class="post-title"><a href="#">${postReviewTop.title}</a></h3>
                    </div>
                </div>
            </div>
            <!-- /post -->

            <!-- post -->
            <div class="col-md-4">
                <div class="post">
                    <a class="post-img" href="#"><img
                            src="${pageContext.servletContext.contextPath}/${postHighlightTop.image}" alt=""></a>
                    <div class="post-body">
                        <div class="post-meta">
                            <a class="post-category cat-1" href="category.html">${postHighlightTop.category.name}</a>
                            <span class="post-date">${postHighlightTop.pulishDate}</span>
                        </div>
                        <h3 class="post-title"><a href="#">${postHighlightTop.title}</a></h3>
                    </div>
                </div>
            </div>
            <!-- /post -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /section -->

<!-- section -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-8">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-title">
                            <h2>Most Read</h2>
                        </div>
                    </div>
                    <!-- post -->
                    <c:forEach items="${listTop4Views}" var="post">
                        <div class="col-md-12">
                            <div class="post post-row">
                                <a class="post-img" href="#"><img
                                        src="${pageContext.servletContext.contextPath}/${post.image}" alt=""></a>
                                <div class="post-body">
                                    <div class="post-meta">
                                        <a class="post-category cat-2" href="category.html">${post.category.name}</a>
                                        <span class="post-date">${post.pulishDate}</span>
                                    </div>
                                    <h3 class="post-title"><a href="#">${post.title}</a></h3>
                                    <p>${post.shortContent}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- /post -->
                    <div class="col-md-12">
                        <div class="section-row">
                            <button class="primary-button center-block">Load More</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <!-- ad -->
                <div class="aside-widget text-center">
                    <a href="#" style="display: inline-block;margin: auto;">
                        <img class="img-responsive"
                             src="${pageContext.servletContext.contextPath}/ui-assets/img/ad-1.jpg" alt="">
                    </a>
                </div>
                <!-- /ad -->

                <!-- catagories -->
                <div class="aside-widget">
                    <div class="section-title">
                        <h2>Catagories</h2>
                    </div>
                    <div class="category-widget">
                        <ul>
                            <c:forEach begin="0" end="3" var="index">
                                <c:set var="cate" value="${listSumCategory.get(index)}"/>
                                <li><a href="#" class="cat-${index + 1}">${cate.category.name}<span>${cate.counter}</span></a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- /catagories -->

                <!-- tags -->
                <div class="aside-widget">
                    <div class="tags-widget">
                        <ul>
                            <c:forEach items="${listCategory}" var="cate">
                                <li><a href="#">${cate.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- /tags -->
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /section -->

<!-- Footer -->
<footer id="footer">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-5">
                <div class="footer-widget">
                    <div class="footer-logo">
                        <a href="home" class="logo"><img
                                src="${pageContext.servletContext.contextPath}/ui-assets/img/logo.png" alt="" style="width: 114px;height: 61px"></a>
                    </div>
                    <ul class="footer-nav">
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Advertisement</a></li>
                    </ul>
                    <div class="footer-copyright">
								<span>&copy;
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i
                                            class="fa fa-heart-o" aria-hidden="true"></i> by <a
                                            href="https://colorlib.com" target="_blank">Colorlib</a>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></span>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="row">
                    <div class="col-md-6">
                        <div class="footer-widget">
                            <h3 class="footer-title">About Us</h3>
                            <ul class="footer-links">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Join Us</a></li>
                                <li><a href="#">Contacts</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="footer-widget">
                            <h3 class="footer-title">Catagories</h3>
                            <ul class="footer-links">
                                <c:forEach items="${listSumCategory}" var="cate">
                                    <li><a href="#">${cate.category.name}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-3">
                <div class="footer-widget">
                    <h3 class="footer-title">Join our Newsletter</h3>
                    <div class="footer-newsletter">
                        <form>
                            <input class="input" type="email" name="newsletter" placeholder="Enter your email">
                            <button class="newsletter-btn"><i class="fa fa-paper-plane"></i></button>
                        </form>
                    </div>
                    <ul class="footer-social">
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                    </ul>
                </div>
            </div>
            x
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</footer>
<!-- /Footer -->

<!-- jQuery Plugins -->

<script src="${pageContext.servletContext.contextPath}/ui-assets/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/ui-assets/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/ui-assets/js/main.js"></script>
<script
        src="https://kit.fontawesome.com/a66a112bc4.js"
        crossorigin="anonymous"
></script>

</body>
</html>

