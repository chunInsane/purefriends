<%--
  Created by IntelliJ IDEA.
  User: zhangliang
  Date: 15/11/12
  Time: 下午5:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>purefriends login</title>
</head>
<body>
    <div>
      <form action="/login" method="post">
        <h2>用户登录</h2>
        <label>Email:</label>
        <input type="email" name="email" placeholder="email address"/>
        <label>password:</label>
        <input type="password" name="password" placeholder="password"/>
        <button type="submit">sign in</button>
        <button type="reset">reset</button>
      </form>
    </div>
</body>
</html>
