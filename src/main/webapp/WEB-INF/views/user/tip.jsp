<%--
  Created by IntelliJ IDEA.
  User: zhangliang
  Date: 15/11/13
  Time: 下午3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" autoFlush="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>提示页面</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/normalize.css">
</head>
<body>
<jsp:include page="../head.jsp"/>
<div  class="page">
    <p>${tip}</p>
</div>
<div class="reply">
    <a href="<%=request.getContextPath()%>/user/home/${loginUser.id}">个人主页</a>
</div>
</body>
<style>
    body{
        background-color: #E7E7E7;
        padding-top: 50px;
    }
    .page{
        position:relative;
        width:100%;
        min-height: 300px;
        display: block;
        background: url(/resources/img/notice.jpg) no-repeat;
        background-attachment: fixed;
        background-size: 100% auto;
    }
    .page p{
        display:block;
        position:absolute;
        right:0px;
        width:40%;
        text-align: left;
        margin:0px;
        height:100%;
        font-size: 30px;
        line-height: 200px;
        word-wrap:break-word;
    }

    .reply{
        display:block;
        position:absolute;
        bottom:30px;
        width:100%;
        text-align: center;
    }
    .reply a{
        background-color: #222;
        background-image:-webkit-linear-gradient(top,#fff,#ddd);
        border-radius: 5px;
        border: 1px solid #ccc;
        box-shadow: 1px 1px 1px 0px #888;
        color:#000;
        display:inline-block;
        height:30px;
        line-height: 30px;
        padding:0px;
        text-align: center;
        vertical-align: middle;
        width:100px;
    }
</style>
</html>