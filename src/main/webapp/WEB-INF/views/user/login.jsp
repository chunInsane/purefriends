<%--
  Created by IntelliJ IDEA.
  User: zhangliang
  Date: 15/11/12
  Time: 下午8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>purefriends用户登录</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/normalize.css">
</head>
<body>
<div class="head-logo">
  <img src="" alt="">
  <span class="word-lg word-700 color-white">PureFriends</span>
</div>
<!-- 登录开始 -->
<div id="form-login">
  <form action="<%=request.getContextPath()%>/user/toLogin" method="POST">
    <input type="email" name="email" value="" placeholder="E-mail" maxlength=20 minlength=6 required>
    <input type="password" name="password" value=""	placeholder="password" maxlength=10 minlength=6 required>
    <button type="submit" class="btn">登录</button>
  </form>
</div>
<!-- 登录结束 -->
<!-- 注册开始 -->
<div id="form-register">
  <form action="<%=request.getContextPath()%>/user/toRegister" method="POST">
    <input type="email" name="email" value="" id="email" placeholder="邮箱注册" maxlength=20 minlength=6 required>
    <input type="password" name="password" value="" id="psw1"	placeholder="密码" maxlength=10 minlength=6 required>
    <input type="password" name="repassword" value="" id="psw2"	placeholder="确认密码" maxlength=10 minlength=6 required>
    <button type="submit" class="btn" id="register-btn" disabled="true">注册</button>
  </form>
</div>
<!-- 注册结束 -->
<button  onclick="index();" id="change">注册新帐号</button><!-- onclick="hideRegister();" -->
<jsp:include page="../footer.jsp"/>
</body>

<style>
  body{
    background: url('<%=request.getContextPath()%>/resources/img/bg.jpg') no-repeat;
    background-size: 100% 100%;
  }
  #form-login{
    position:relative;
    width: 400px;
    margin: 200px auto;
  }
  #form-register{
    display:none;
    position:relative;
    width: 400px;
    margin: 200px auto;
  }
  .head-logo{
    position: absolute;
    top:120px;
    left:30%;
    text-shadow:2px 2px 4px #222;
  }
  .center{
    display:block;
    text-align: center;
    margin:0 auto;
  }
  #change{
    position:fixed;
    bottom:10%;
    left:5%;
    color:rgba(255,255,255,1);
    border: none;
    padding:8px 14px;
    background-color: rgba(0,0,0,0.3);
  }
</style>
<script>
  var login =  document.getElementById("form-login");
  var register =  document.getElementById("form-register");
  var change = document.getElementById("change");
  var a = 1;

  function index(){
    if ( a % 2 == 1) {
      hideLogin();
      a++;
    }else if(a % 2 == 0){
      hideRegister();
      a--;
    }
  }


  function hideLogin(){
    login.style.display = "none";
    register.style.display = "block";
    change.innerHTML = "登录";
  }

  function hideRegister(){
    login.style.display = "block";
    register.style.display = "none";
    change.innerHTML = "注册新帐号";
  }

  window.onload = function(){
    // setTimeout(check,100);
    check();
  };

  function check(){
    var email = document.getElementById("email").value;
    var psw1 = document.getElementById("psw1").value;
    var psw2 = document.getElementById("psw2").value;
    var btn = document.getElementById("register-btn");
    if (psw1 === psw2 && psw1 != "") {
      btn.removeAttribute("disabled","false");
      btn.style.background = "royalblue";
    }else{
      btn.setAttribute("disabled","true");
      btn.style.background = "gray";
    }
    setTimeout(check,100);
  }
</script>
</html>