<%--
  Created by IntelliJ IDEA.
  User: Nobita
  Date: 2/24/2021
  Time: 11:19 AM
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
    <title>Admin Category Manage</title>

    <!-- Fontfaces CSS-->
    <c:import url="css/fontfaces.jsp"></c:import>
    <!-- Bootstrap CSS-->
    <link href="${pageContext.servletContext.contextPath}/admin-assets/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <c:import url="css/vendor.jsp"></c:import>
    <!-- Main CSS-->
    <link href="${pageContext.servletContext.contextPath}/admin-assets/css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition" style="opacity: 1">
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
                            <h3 class="title-5 m-b-35">Category Manager</h3>
                        </div>
                        <div class="table-data__tool">
                            <div class="table-data__tool-left">
                                <a href="admin-category?action=add"
                                   class="au-btn au-btn-icon au-btn--green au-btn--small"> <i
                                        class="fa fas-plus"></i>add category
                                </a>

                            </div>
                            <div class="table-data__tool-right"></div>
                        </div>
                    </div>
<%--                    <div class="row">--%>
<%--                        <c:if test="${message!=null}">--%>
<%--                            <div class="col-12 col-md-12">--%>
<%--                                <div class="alert alert-primary"><i>${message}</i></div>--%>
<%--                            </div>--%>
<%--                        </c:if>--%>
<%--                    </div>--%>
                    <div class="row">
                        <div class="table-responsive table-responsive-data2">
                            <table class="table table-data2">
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Description</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items='${requestScope["list"]}' var='cate'>
                                <tr class="tr-shadow">
                                    <td>${cate.name}</td>
                                    <td>${cate.description}</td>
                                    <td>
                                        <div class="table-data-feature">

                                            <a href="admin-category?action=edit&id=${cate.id}"
                                               class="item" data-toggle="tooltip" data-placement="top"
                                               title="Edit"> <i class="fas fa-edit"></i>
                                            </a> <a href="admin-category?action=delete&id=${cate.id}"
                                                    class="item" data-toggle="tooltip" data-placement="top"
                                                    title="Delete"> <i class="fas fa-trash-alt"></i>
                                        </a>
                                        </div>
                                    </td>

                                </tr>
                                <tr class="spacer"></tr>
                                </c:forEach>
                            </table>
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
