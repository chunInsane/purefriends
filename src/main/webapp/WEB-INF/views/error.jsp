<%--
  Created by IntelliJ IDEA.
  User: whx
  Date: 2015/7/13
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" autoFlush="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>错误页面</title>
  <link rel="stylesheet" href="./style.css">
  <link rel="stylesheet" href="./normalize.css">
</head>
<body>
<jsp:include page="head.jsp"/>
<div  class="error-page">
  <dl>
    <dt>
				<pre>
          .----.
       _.'__    `.
   .--($)($$)---/#\
 .' @          /###\
 :         ,   #####
  `-..__.-' _.-\###/
        `;_:    `"'
      .'"""""`.
     /,      ,  \
    //         \  \.  __   __   __   __    #
    `-._______.-'    /  \ /  \ |__| |__   #
    ___`. | .'___    \__/ \__/ |     __|  #
   (______|______)                        @
				</pre>
    出错啦 ^__^
    </dt>
    <dd>${exception.message}</dd>
  </dl>


</div>
<div class="reply">
  <a href="#">回到首页</a>
</div>
<jsp:include page="footer.jsp"/>
</body>
<style>
  body{
    background-color: #F5F5F5;
    padding-top: 50px;
  }
  .error-page{
    display: block;
    height:400px;
    margin:0px auto !important;
    width: 500px;
  }
  .error-page dt{
    font-size: 30px;
  }
  .error-page dt pre{
    font-size:14px;
    color:#C70C0C;
    font-weight: 700;
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