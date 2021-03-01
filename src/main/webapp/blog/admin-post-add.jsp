<%--
  Created by IntelliJ IDEA.
  User: Nobita
  Date: 2/24/2021
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <title>Admin Add Post</title>

    <!-- Fontfaces CSS-->
    <c:import url="css/fontfaces.jsp"></c:import>
    <!-- Bootstrap CSS-->
    <link href="${pageContext.servletContext.contextPath}/admin-assets/vendor/bootstrap-4.1/bootstrap.min.css"
          rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <c:import url="css/vendor.jsp"></c:import>
    <!-- Main CSS-->
    <link href="${pageContext.servletContext.contextPath}/admin-assets/css/theme.css" rel="stylesheet" media="all">

    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
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
                            <h3 class="title-5 m-b-35">Post Manager</h3>
                        </div>
                        <div class="table-data__tool">
                            <div class="table-data__tool-left">
                                <a href="admin-post"
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
                            <form action="${pageContext.servletContext.contextPath}/admin-post?action=add" method="post"
                                  class="form-horizontal">
                                <div class="card-header">
                                    <strong>Add Post</strong>
                                </div>
                                <div class="card-body card-block">
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="title" class=" form-control-label">Title</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" id="title" name="title" placeholder="Title"
                                                   required value="${post.title}" class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="shortContent" class=" form-control-label">Short Content</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" id="shortContent" name="shortContent"
                                                   placeholder="Short Content" value="${post.shortContent}"
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="longContent" class=" form-control-label">Long Content</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                        <textarea name="longContent" id="longContent" rows="9"
                                                  placeholder="Long Content"
                                                  class="form-control">${post.longContent}</textarea>
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="image" class=" form-control-label">Image</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" id="image" name="image"
                                                   placeholder="Image" value="${post.image}"
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="category" class=" form-control-label">Category</label>
                                        </div>

                                        <div class="col-12 col-md-9">
                                            <select name="category" id="category" class="form-control" required>
                                                <c:forEach items="${list}" var="cate">
                                                    <option selected>Chose Category</option>
                                                    <option value="${cate.id}">${cate.name}</option>
                                                </c:forEach>
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
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<script src="">$('#longContent').summernote({
    tabsize: 2,
    height: 200
})</script>
</body>
</html>
<!-- end document-->
