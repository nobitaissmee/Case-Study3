<%--
  Created by IntelliJ IDEA.
  User: Nobita
  Date: 2/27/2021
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="menu-sidebar d-none d-lg-block">
    <div class="logo">
        <a href="dashboard">
            <img src="${pageContext.servletContext.contextPath}/admin-assets/images/icon/logo.png" alt="Cool Admin" />
        </a>
    </div>
    <div class="menu-sidebar__content js-scrollbar1">
        <nav class="navbar-sidebar">
            <ul class="list-unstyled navbar__list">
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
        </nav>
    </div>
</aside>
