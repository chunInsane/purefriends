<%--
  Created by IntelliJ IDEA.
  User: zhangliang
  Date: 15/11/14
  Time: 下午3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ page isELIgnored="false" autoFlush="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>UserHome</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/normalize.css">
  <link rel="alternate icon" type="img/gif" href="<%=request.getContextPath()%>/resources/img/logo.gif">
</head>
<jsp:include page="../head.jsp"/>
<div class="container">
  <div class="info">
    <div class="friends-title">
      <h2>查找用户</h2><span>共${fn:length(resultUsers)}位</span>
    </div>
    <div class="user-friends">
      <ol>
        <c:forEach items="${resultUsers}" var="user">
          <li>
            <span class="col-3">${user.nickname}</span><span class="col-5">${user.email}</span><span class="col-2"><a href="<%=request.getContextPath()%>/user/showOtherInfo/${user.id}">查看</a><a href="<%=request.getContextPath()%>/notification/requestFriend/${loginUser.id}/${user.id}">加为好友</a></span>
          </li>
        </c:forEach>
      </ol>
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
  .info{
    padding:40px;
    overflow: hidden;
  }
  .user-portrait{
    display:inline-block;
    height:180px;
    overflow:hidden;
    padding:3px;
    /*position:relative;*/
    /*width: 180px;*/
  }
  .img{
    border: 1px solid #ddd;
    width:180px;
  }
  .user-info{
    /*margin-left: 5%;*/
    /*position: absolute;*/
    display:inline-block;
    top:0;
    vertical-align: top;
  }
  .user-name{
    width:100%;
    min-height: 65px;
    border-bottom: 1px solid #ddd;
    width:100%;
    display:block;
  }
  .user-name h2{
    display:inline-block;
    vertical-align: middle;
  }
  #change-btn{
    padding:16px 0;
    display:inline-block;
    /*margin-left: 40%;*/
  }
  #change-btn a{
    display:inline-block;
    width:100%;
    padding:6px 10px;
    vertical-align: middle;
    border: 1px solid #ccc;
    text-align: center;
    border-radius: 5px;
    color:#000;
    box-shadow: 1px 1px 1px 0px #888;
    background-image:-webkit-linear-gradient(top,#fff,#ddd);
  }
  #name{
    font-size: 22px;
    font-weight: 400;
    width:100%;
  }
  .system-info{
    list-style: none;
    display:inline-block;
    padding:0px;
    margin-bottom: 0px;
  }
  .system-info li{
    display:inline-block;
    float: left;
    width:100px;
    margin-bottom: 0px;
  }
  .system-info li a{
    padding:10px 20px 10px 0px;
  }
  .system-info li a strong{
    font-size: 22px;
    font-weight: 400 !important;
  }
  .user-info-details{
    margin-top: 6px;
  }
  .user-friends{
    width:100%;
    display:block;
    border:1px solid #eee;
  }
  .friends-title{
    margin-top: 20px;
    border-bottom: 2px solid #C70C0C;
  }
  .friends-title h2{
    font-weight: 400 !important;
    display:inline-block;
    margin: 8px 0;
  }
  .friends-title span{
    margin-left: 20px;
  }
  .friends-title ol{
    display:block;
    overflow:hidden;
  }
  .user-friends span{
    /*width:30%;*/
    display:inline-block;
  }
  .user-friends span a{
    /*width:30%;*/
    display:inline-block;
    width:50%;
    color:#222;
    text-decoration: none;
  }
  ol li{
    padding:4px 0 4px 10px;
  }
  .user-friends ol li:nth-child(odd){
    background:#EEE;
  }
</style>
</html>