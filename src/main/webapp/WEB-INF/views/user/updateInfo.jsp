<%--
  Created by IntelliJ IDEA.
  User: zhangliang
  Date: 15/11/13
  Time: 下午9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" autoFlush="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>修改个人信息</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/normalize.css">
  <link rel="alternate icon" type="img/gif" href="<%=request.getContextPath()%>/resources/img/logo.gif">
</head>
<body>
<jsp:include page="../head.jsp"/>
<div class="container">
  <div class="info-box">
    <div class="friends-title">
      <h2>修改个人信息</h2>
    </div>
    <div class="form">
      <sf:form action="/user/toUpdateInfo/${user.id}" method="POST" modelAttribute="user">
        <sf:input type="hidden" path="id"/>
        <div class="input-info">
          <label for="email">email</label>
          <sf:input type="text" class="input" required="required" placeholder="email" readonly="true" path="email"/>
        </div>
        <div class="input-info">
          <label for="nickname">nickname</label>
          <sf:input type="text" class="input" required="required" placeholder="nickname" path="nickname"/>
        </div>
        <div class="input-info">
          <label for="gender">gender</label>
          <sf:select path="gender" class="input" required="required">
            <option value="1" selected>male</option>
            <option value="0">female</option>
          </sf:select>
        </div>
        <div class="input-info">
          <label for="area">area</label>
          <sf:input type="text" class="input" placeholder="area" path="area"/>
        </div>
        <div class="input-info">
          <label for="marriage">marriage</label>
          <sf:select path="marriage" class="input" required="required">
            <option value="0" selected>unmarriaged</option>
            <option value="1">marriaged</option>
          </sf:select>
        </div>
        <div class="input-info">
          <label for="height">height</label>
          <sf:input type="number" class="input" placeholder="height" path="height"/>
        </div>
        <div class="input-info">
          <label for="education">education</label>
          <sf:input type="text" class="input" placeholder="education" path="education"/>
        </div>
        <div class="input-info">
          <label for="wage">wage</label>
          <sf:input type="text" class="input" placeholder="wage" path="wage"/>
        </div>
        <div class="input-info">
          <label for="phone">phone</label>
          <sf:input type="text" class="input" placeholder="phone" path="phone"/>
        </div>
        <div class="input-info">
          <label for="hobby">hobby</label>
          <sf:input type="text" class="input" placeholder="hobby" path="hobby"/>
        </div>
        <div class="input-info">
          <label for="info">profile</label>
          <sf:input type="text" class="input" placeholder="profile" path="info"/>
        </div>
        <div class="input-info">
          <label for=""></label>
          <input type="submit"  class="submit" value="确认修改"/>
        </div>
      </sf:form>

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
</style>
</html>
