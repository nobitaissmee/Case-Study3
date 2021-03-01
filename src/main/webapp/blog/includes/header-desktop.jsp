<%--
  Created by IntelliJ IDEA.
  User: Nobita
  Date: 2/27/2021
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<header class="header-desktop">
    <div class="section__content section__content--p30">
        <div class="container-fluid">
            <div class="header-wrap">
                <form class="form-header" action="" method="POST">
                </form>
                <div class="header-button">
                    <div class="noti-wrap">
                    </div>
                    <div class="account-wrap">
                        <div class="account-item clearfix js-item-menu">
                            <div class="image">
                                <img src="${pageContext.servletContext.contextPath}/admin-assets/images/icon/avatar-01.jpg" alt="${sessionScope.user.fullname}" />
                            </div>
                            <div class="content">
                                <a class="js-acc-btn" href="#">${sessionScope.user.fullname}</a>
                            </div>
                            <div class="account-dropdown js-dropdown">
                                <div class="info clearfix">
                                    <div class="image">
                                        <a href="#">
                                            <img src="${pageContext.servletContext.contextPath}/admin-assets/images/icon/avatar-01.jpg" alt="John Doe" />
                                        </a>
                                    </div>
                                    <div class="content">
                                        <h5 class="name">
                                            <a href="#">${sessionScope.user.fullname}</a>
                                        </h5>
                                        <span class="email">${sessionScope.username}</span>
                                    </div>
                                </div>
                                <div class="account-dropdown__body">
                                    <div class="account-dropdown__item">
                                        <a href="#">
                                            <i class="fa fas-cogs"></i>Setting</a>
                                    </div>
                                </div>
                                <div class="account-dropdown__footer">
                                    <a href="authentication?action=logout">
                                        <i class="fas fa-sign-out-alt"></i>Logout</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
