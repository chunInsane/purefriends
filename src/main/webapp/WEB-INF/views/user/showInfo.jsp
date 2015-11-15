<%--
  Created by IntelliJ IDEA.
  User: zhangliang
  Date: 15/11/13
  Time: 下午10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" autoFlush="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>详细资料</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/normalize.css">
  <link rel="alternate icon" type="img/gif" href="<%=request.getContextPath()%>/resources/img/logo.gif">
</head>
<body>
<jsp:include page="../head.jsp"></jsp:include>
<div class="container">
  <div class="info-box">
    <div class="friends-title">
      <h2>${loginUser.nickname}(${loginUser.id})详细资料</h2><a href="<%=request.getContextPath()%>/user/updateInfo/${loginUser.id}" id="changeUserInfoBtn">修改个人信息</a>
    </div>
    <div class="form">
      <form action="#" method="POST">
        <div class="input-info">
          <label for="">email</label>
          <input type="text"  class="input" value="${loginUser.email}" name="" required placeholder="" disabled>
        </div>
        <div class="input-info">
          <label for="">nickname</label>
          <input type="text"  class="input" value="${loginUser.nickname}" name="" required placeholder="" disabled>
        </div>
        <div class="input-info">
          <label for="">gender</label>
          <c:if test="${loginUser.gender eq 1}">
            <input type="text"  class="input" value="male" name="" required placeholder="" disabled>
          </c:if>
          <c:if test="${loginUser.gender eq 0}">
            <input type="text"  class="input" value="female" name="" required placeholder="" disabled>
          </c:if>
        </div>
        <div class="input-info">
          <label for="">area</label>
          <input type="text"  class="input" value="${loginUser.area}" name="" required placeholder="" disabled>
        </div>
        <div class="input-info">
          <label for="">marriage</label>
          <c:if test="${loginUser.marriage eq 1}">
            <input type="text"  class="input" value="已婚" name="" required placeholder="" disabled>
          </c:if>
          <c:if test="${loginUser.marriage eq 0}">
            <input type="text"  class="input" value="单身" name="" required placeholder="" disabled>
          </c:if>
        </div>
        <div class="input-info">
          <label for="">height</label>
          <input type="text"  class="input" value="${loginUser.height}cm" name="" required placeholder="" disabled>
        </div>
        <div class="input-info">
          <label for="">education</label>
          <input type="text"  class="input" value="${loginUser.education}" name="" required placeholder="" disabled>
        </div>
        <div class="input-info">
          <label for="">wage</label>
          <input type="text"  class="input" value="${loginUser.wage}RMB" name="" required placeholder="" disabled>
        </div>
        <div class="input-info">
          <label for="">phone</label>
          <input type="text"  class="input" value="${loginUser.phone}" name="" required placeholder="" disabled>
        </div>
        <div class="input-info">
          <label for="">hobby</label>
          <input type="text"  class="input" value="${loginUser.hobby}" name="" required placeholder="" disabled>
        </div>
        <div class="input-info">
          <label for="">profile</label>
          <input type="text"  class="input" value="${loginUser.info}" name="" required placeholder="" disabled>
        </div>
      </form>

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
  input{
    outline: none;
    border-top:none;
    border-left:none;
    border-right:none;
    border-bottom: 1px solid #DDD;
    margin-bottom:5px !important;
    margin-top:5px !important;
  }
  select {
    background-color: rgba(255,255,255,1);
    /*border-radius: 5px;*/
    border:1px solid #DDD;
    display: block;
    margin-bottom:5px !important;
    margin-left: auto !important;
    margin-right: auto !important;
    margin-top:5px !important;
    padding: 10px 0px;
    text-align: center;
    width: 300px;
    color:rgba(25,25,25,1) !important;
  }
  .form{
    width:40%;
    margin:0 auto;
    padding:0px;
  }
  .form label{
    display:inline-block;
    text-align: right;
    width:20%;
  }
  .form .input{
    /*margin:0px;*/
    width:78%;
    display:inline-block;
    padding: 5px 0px;
  }
  .form .submit{
    width:78%;
    display:inline-block;
    padding: 5px 0px;
    /*background-color: #C70C0C;*/
    background-image: -webkit-linear-gradient(top,#C70C0C,#a70C0C);
    border-radius: 15px;
    border:1px solid #666;
    box-shadow: 0px 1px 1px 1px rgba(0,0,0,0.2);
    color:#FFF !important;
  }
  .info-box{
    padding:30px;
  }
  .user-friends{
    width:100%;
    display:block;
    border:1px solid #eee;
  }
  .friends-title{
    margin-top: 0px;
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
  #changeUserInfoBtn{
    display:inline-block;
    float:right;
    /*line-height: 50px;*/
    padding: 5px 10px;
    /*background-color: #C70C0C;*/
    background-image: -webkit-linear-gradient(top,#C70C0C,#a70C0C);
    border-radius: 15px;
    border:none;
    box-shadow: 0px 1px 1px 1px rgba(0,0,0,0.1);
    color:#FFF !important;
    /*vertical-align: middle;*/
  }
</style>
</html>