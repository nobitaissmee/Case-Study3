<%--
  Created by IntelliJ IDEA.
  User: Nobita
  Date: 2/27/2021
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header-mobile d-block d-lg-none">
    <div class="header-mobile__bar">
        <div class="container-fluid">
            <div class="header-mobile-inner">
                <a class="logo" href="dashboard">
                    <img src="${pageContext.servletContext.contextPath}/admin-assets/images/icon/logo.png" alt="CoolAdmin" />
                </a>
                <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                </button>
            </div>
        </div>
    </div>
    <nav class="navbar-mobile">
        <div class="container-fluid">
            <ul class="navbar-mobile__list list-unstyled">

                <li>
                    <a href="admin-category">
                        <i class="fas fa-chart-bar"></i>Category Manage</a>
                </li>
                <li>
                    <a href="admin-post">
                        <i class="fas fa-table"></i>Post Manage</a>
                </li>
                <c:if test="${status == 1}">
                    <li>
                        <a href="admin-user">
                            <i class="far fa-check-square"></i>User Manage</a>
                    </li>
                </c:if>
                <li>
                    <a href="home">
                        <i class="fas fa-home"></i>Home</a>
                </li>

            </ul>
        </div>
    </nav>
</header>
