<%--
  Created by IntelliJ IDEA.
  User: zhangliang
  Date: 15/11/14
  Time: 上午11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" autoFlush="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>已读信件</title>
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
        <h2>已读信件</h2>
      </div>
      <c:forEach items="${messages}" var="message">
      <div class="mess-box">
        <dl>
          <dt>${message.title} < ${message.fromUserName}> <span>${message.createTime}</span></dt>
          <dd>${message.content}</dd>
        </dl>
      </div>
      </c:forEach>
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
  .mess-box{
    border:1px solid #D5D5D5;
    overflow:hidden;
    padding:0px;
    margin: 5px 0px;
    border-radius: 2px;
  }


  /*	dd{
      transition: all 1s;
      -webkit-transition:all 1s;
  }*/
  .mess-box dt{
    display:block;
    width:100%;
    background-image: -webkit-linear-gradient(top,#F6F6F6,#F1F1F1);
    padding:4px 0px;
    overflow:hidden;
    border-bottom: 1px solid #D5D5D5;
  }
  .mess-box dd{
    display:block;
    width:100%;
    word-wrap: break-word;
    height:0px;
    /*width:0px;*/
    transition-timing-function: ease;
    -moz-transition-timing-function: ease; /* Firefox 4 */
    -webkit-transition-timing-function: ease; /* Safari 和 Chrome */
    -o-transition-timing-function: ease; /* Opera */
    transition-duration: 1s;
    -moz-transition-duration: 1s; /* Firefox 4 */
    -webkit-transition-duration: 1s; /* Safari 和 Chrome */
    -o-transition-duration: 1s; /* Opera */
  }
  .mess-box dl:hover dd{
    height:100px;
    width:100%;
  }
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