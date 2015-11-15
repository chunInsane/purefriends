<%--
  Created by IntelliJ IDEA.
  User: zhangliang
  Date: 15/11/13
  Time: 上午10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>purefriends后台登录</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/normalize.css">
</head>
<body>
<div class="head">
  <img src="" alt="">
  <span class="word-lg word-700 color-white">PureFriends Admin</span>
</div>
<div class="form">
  <form action="" method="POST">
    <input type="text" name="username" value="" placeholder="E-mail" maxlength=20 minlength=6>
    <input type="password" name="password" value=""	placeholder="password" maxlength=10 minlength=6>
    <button type="submit">登录</button>
  </form>
</div>
<jsp:include page="../footer.jsp"/>
</body>

<style>
  body{
    background:#222;
    background-size: 100% ;
  }
  .form{
    position:relative;
    width: 400px;
    margin: 200px auto;
  }
  .head{
    position: absolute;
    top:120px;
    left:30%;
    text-shadow:2px 2px 4px #222;
  }
</style>
</html>
