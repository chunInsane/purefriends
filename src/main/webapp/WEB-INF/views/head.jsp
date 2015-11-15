<%--
  Created by IntelliJ IDEA.
  User: zhangliang
  Date: 15/11/13
  Time: 下午7:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" autoFlush="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>PureFriends</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/normalize.css">
  <link rel="alternate icon" type="img/gif" href="<%=request.getContextPath()%>/resources/img/logo.gif">
</head>
<body>
<!-- 导航栏 开始-->
<nav class="nav">
  <a href="#" class="nav-logo word-sm word-700">PUREFRIENDS</a>
  <ul class="nav-item">
    <li class="nav-link border-right"><a href="<%=request.getContextPath()%>/user/home/${loginUser.id}">我的主页</a></li>
    <li class="nav-link border-left border-right"><a href="#">好友</a></li>
    <li class="nav-link border-left"><a href="<%=request.getContextPath()%>/msg/unread/${loginUser.id}">信箱</a></li>
  </ul>
  <ul class="nav-search">
    <li class="col-6">
      <div class="search">
        <form action="<%=request.getContextPath()%>/user/searchUser" method="GET">
          <input type="text" name="keyword" value="" placeholder="查找用户" id="searchInput">
        </form>
      </div>
    </li>
    <li class="col-4 text-left"><a href="<%=request.getContextPath()%>/user/logout" class="text-left">退出</a></li>
  </ul>
</nav>
<div id="subnav-up"></div>
<!-- 导航栏 结束 -->
</body>
</html>
