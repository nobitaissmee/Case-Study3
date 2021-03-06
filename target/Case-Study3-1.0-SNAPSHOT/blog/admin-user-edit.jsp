<%--
  Created by IntelliJ IDEA.
  User: Nobita
  Date: 2/24/2021
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Admin Edit User</title>

    <!-- Fontfaces CSS-->
    <c:import url="css/fontfaces.jsp"></c:import>
    <!-- Bootstrap CSS-->
    <link href="${pageContext.servletContext.contextPath}/admin-assets/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <c:import url="css/vendor.jsp"></c:import>
    <!-- Main CSS-->
    <link href="${pageContext.servletContext.contextPath}/admin-assets/css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition" style="opacity: 1;">
<div class="page-wrapper">
    <!-- HEADER MOBILE-->
    <c:import url="includes/header.jsp"></c:import>
    <!-- END HEADER MOBILE-->

    <!-- MENU SIDEBAR-->
    <c:import url="includes/side-bar.jsp"></c:import>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container">
        <!-- HEADER DESKTOP-->
        <c:import url="includes/header-desktop.jsp"></c:import>
        <!-- HEADER DESKTOP-->

        <!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">

                    <div class="row">
                        <div class="col-12 col-md-12">
                            <h3 class="title-5 m-b-35">User Manager</h3>
                        </div>
                        <div class="table-data__tool">
                            <div class="table-data__tool-left">
                                <a href="admin-category"
                                   class="au-btn au-btn-icon au-btn--green au-btn--small"> <i
                                        class="zmdi zmdi-collection-item"></i>list
                                </a>

                            </div>
                            <div class="table-data__tool-right"></div>
                        </div>
                    </div>
                    <div class="row">
                        <c:if test="${message!=null}">
                            <div class="col-12 col-md-12">
                                <div class="alert alert-primary"><i>${message}</i></div>
                            </div>
                        </c:if>
                    </div>
                    <div class="row">
                        <!-- FORM ADD-->
                        <div class="col-12 col-md-12">
                            <form action="${pageContext.servletContext.contextPath}/admin-user?action=add" method="post" class="form-horizontal">
                                <div class="card-header">
                                    <strong>Edit User</strong>
                                </div>
                                <div class="card-body card-block">
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="username" class=" form-control-label">Username</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" id="username" name="username" placeholder="Username"
                                                   required value="${user.username}" class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="password" class=" form-control-label">Password</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="password" id="password" name="password" required
                                                   placeholder="Password" value="${user.password}"
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="fullname" class=" form-control-label">Fullname</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" id="fullname" name="fullname" required
                                                   placeholder="Fullname" value="${user.fullname}"
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="status" class=" form-control-label">Status</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <select name="status" id="status" class="form-control">
                                                <c:if test="${user.status == 1}">
                                                    <option value="1" selected>Admin</option>
                                                    <option value="2">Staff</option>
                                                    <option value="3">User</option>
                                                </c:if>
                                                <c:if test="${user.status == 2}">
                                                    <option value="1" >Admin</option>
                                                    <option value="2" selected>Staff</option>
                                                    <option value="3">User</option>
                                                </c:if>
                                                <c:if test="${user.status == 3}">
                                                    <option value="1" >Admin</option>
                                                    <option value="2">Staff</option>
                                                    <option value="3"selected>User</option>
                                                </c:if>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary btn-sm">
                                        <i class="fa fa-dot-circle-o"></i> Submit
                                    </button>
                                    <button type="reset" class="btn btn-danger btn-sm">
                                        <i class="fa fa-ban"></i> Reset
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="copyright">
                                <p>
                                    Copyright © 2018 Colorlib. All rights reserved. Template by <a
                                        href="https://colorlib.com">Colorlib</a>.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END MAIN CONTENT-->
        <!-- END PAGE CONTAINER-->
    </div>
</div>

<!-- Jquery JS-->
<script src="${pageContext.servletContext.contextPath}/admin-assets/vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="${pageContext.servletContext.contextPath}/admin-assets/vendor/bootstrap-4.1/popper.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/admin-assets/vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<c:import url="css/vendor-js.jsp"></c:import>
<!-- Main JS-->
<script src="${pageContext.servletContext.contextPath}/admin-assets/js/main.js"></script>
<script
        src="https://kit.fontawesome.com/a66a112bc4.js"
        crossorigin="anonymous"
></script>

</body>
</html>
<!-- end document-->
