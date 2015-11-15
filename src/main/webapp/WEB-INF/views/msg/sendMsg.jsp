<%--
  Created by IntelliJ IDEA.
  User: zhangliang
  Date: 15/11/14
  Time: 下午2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" autoFlush="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>新建信件</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/normalize.css">
  <link rel="alternate icon" type="img/gif" href="<%=request.getContextPath()%>/resources/img/logo.gif">
</head>
<body>
<jsp:include page="../head.jsp"/>
<div class="container">
  <div class="mess-btn col-2-5">
    <ul>
      <li><a href="<%=request.getContextPath()%>/msg/unread/${loginUser.id}">未读信件</a></li>
      <li><a href="<%=request.getContextPath()%>/msg/readed/${loginUser.id}">已读信件</a></li>
      <li><a href="<%=request.getContextPath()%>/msg/sended/${loginUser.id}">已发信件</a></li>
      <li><a href="<%=request.getContextPath()%>/notification/unread/${loginUser.id}">系统通知</a></li>
      <li><a href="<%=request.getContextPath()%>/msg/sendMsg/${loginUser.id}/-1">新建信件</a></li>
    </ul>
  </div>
  <div class="notification col-7-5 bg-color-white">
    <div class="notice">
      <div class="friends-title">
        <h2>发送信件</h2>
      </div>
      <div class="mess-box">
        <form action="<%=request.getContextPath()%>/msg/toSendMsg/${loginUser.id}" method="POST">
          <c:if test="${toUser eq null}">
            <input type="text" name="email" value="" placeholder="联系人账号" required><!--  cols="20"  -->
          </c:if>
          <c:if test="${toUser ne null}">
            <input type="text" name="email" value="${toUser.email}" placeholder="联系人账号" required><!--  cols="20"  -->
          </c:if>
          <input type="text" name="title" value="" placeholder="主题" required>
          <textarea name="content" rows="6" id="" required placeholder="内容"></textarea>
          <button type="submit">发送</button>
        </form>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
<style>
  body{
    padding-top: 60px;
    /*background: url('./img/home-bg.png');*/
    background:#F5F5F5;
  }
  .container{
    background: #F8F8F8;
    box-shadow: 0px 0px 1px 1px #ccc;
  }
  .mess-btn{
    background-color: #F8F8F8;
    display:inline-block;
  }
  .mess-btn ul{
    margin: 0;
    list-style: none;
    padding:0px;
    /*		border-top: 1px solid #D5D5D5;
            border-left: 1px solid #D5D5D5;
        border-right:1px solid #D5D5D5;*/
  }
  .mess-btn ul li{
    display:block;
    padding:0px 0px;
    text-align: center;
    border-bottom:1px solid #D5D5D5;
  }
  .mess-btn ul li:hover{
    background-color: rgba(0,0,0,0.05);
  }
  .mess-btn ul li a{
    height:60px;
    color:#222;
    display:inline-block;
    width: 100%;
    vertical-align: middle;
    line-height: 60px;
    border-right: 1px solid #D5D5D5;
  }

  /*mess-box start*/
  .mess-box{
    /*border:1px solid #D5D5D5;*/
    border:none;
    overflow:hidden;
    padding:0px;
    margin: 5px 0px;
    border-radius: 2px;
    height:auto;
  }
  .mess-box textarea{
    padding:5px;
    text-align: left;
    display:block;
    height:auto;
    border:1px solid #D5D5D5;
    border-radius:5px;
    box-shadow: inset 0 1px 3px rgba(0,0,0,.2),0 1px 0 rgba(255,255,255,.1);/*important*/
    outline: none;
  }
  .mess-box input{
    padding:5px !important;
    text-align: left;
    display:block;
    padding:0px;
    border:1px solid #D5D5D5;
    border-radius:5px;
    box-shadow: inset 0 1px 3px rgba(0,0,0,.2),0 1px 0 rgba(255,255,255,.1);/*important*/
    outline:none;
  }
  .mess-box button{
    background-color: #222;
    background-image:-webkit-linear-gradient(top,#fff,#ddd);
    border-radius: 5px;
    border: 1px solid #ccc;
    box-shadow: 1px 1px 1px 0px #888;
    color:#444;
    display:block;
    height:30px;
    line-height: 30px;
    margin:10px auto;
    text-align: center;
    vertical-align: middle;
    width:100px;
  }
  /*mess-box end*/

  .notification{
    display:inline-block;
    min-height: 500px;
    float:right;
  }
  .notice{
    padding:30px;
  }
</style>
</html>