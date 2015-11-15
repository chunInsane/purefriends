<%--
  Created by IntelliJ IDEA.
  User: zhangliang
  Date: 15/11/14
  Time: 下午4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" autoFlush="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>系统通知</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/normalize.css">
  <link rel="alternate icon" type="img/gif" href="<%=request.getContextPath()%>/resources/img/logo.gif">
</head>
<body>
<jsp:include page="../head.jsp" />
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
        <h2>系统通知</h2>
      </div>
      <c:forEach items="${notifications}" var="notification">
        <div class="mess-box" onclick="showDetails();" id="m1">
          <dl>
            <dt data-id="${notification.id}" data-type="${notification.type}">${notification.title} <span>${notification.createTime}</span></dt>
            <dd>${notification.content}</dd>
          </dl>
        </div>
      </c:forEach>
    </div>
  </div>
</div>
<div id="Modal">
  <div class="close" onclick="closeModal();">关闭</div>
  <div class="mess-details-box">
    <h3></h3>
    <p></p>
    <div class="reply">
      <a href="#" onclick="closeModal();" id="confirm">接收</a>
      <a href="#" onclick="closeModal();" id="refuse">拒绝</a>
    </div>
  </div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
<script>
  window.onload = function(){

  };
  var modal = document.getElementById("Modal");
  function showDetails(e){
    var target =  event.target;
    var title = target.innerHTML;
    var details = target.parentNode.childNodes[3].innerHTML;
    var id = target.getAttribute("data-id");//联系人id
    var type = target.getAttribute("data-type");//消息类型

    if (type != "1") {
      document.getElementById("confirm").style.display = "none";
      document.getElementById("refuse").style.display = "none";
    }

    var confirm = document.getElementById("confirm").getAttribute("href");
    var refuse = document.getElementById("refuse").getAttribute("href");
    /*确认与拒绝链接*/
    confirm = "/notification/acceptRequest/"+id;
    refuse = "/notification/refuseRequest/"+id;

    // alert(confirm+","+refuse);

    document.getElementById("confirm").setAttribute("href",confirm);
    document.getElementById("refuse").setAttribute("href",refuse);

    // modal.childNodes[3].childNodes[1].nodeName  ===>h3
    // modal.childNodes[3].childNodes[3].nodeName  ===>p
    modal.childNodes[3].childNodes[1].innerHTML = title;
    modal.childNodes[3].childNodes[3].innerHTML = details;
    modal.style.display = "block";

    // ajax start
    if (type != "1") {
      var xmlhttp;
      if (window.XMLHttpRequest)
      {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
      }
      else
      {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
      xmlhttp.onreadystatechange=function(){
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
        }
      }
      xmlhttp.open("GET","/notification/changeStatus/"+id,true);
      xmlhttp.send();
    }
    // ajax end
  }

  function closeModal(){
    // alert("sss");
    modal.style.height = "400px";
    modal.style.display = "none";
  }
</script>
<style>
  body{
    padding-top: 60px;
    /*background: url('./img/home-bg.png');*/
    background:#F5F5F5;
  }
  /*模态框开始*/
  #Modal{
    background-color: rgba(255,255,255,1);
    border-radius: 10px;
    border:1px solid #AAAAAA;
    box-shadow: 0px 2px 5px 4px rgba(0,0,0,0.5);
    height:400px;
    left:20%;
    overflow:hidden;
    position: fixed;
    top:100px;
    width:60%;
    display:none;
    transition-timing-function: ease;
    -moz-transition-timing-function: ease; /* Firefox 4 */
    -webkit-transition-timing-function: ease; /* Safari 和 Chrome */
    -o-transition-timing-function: ease; /* Opera */
    transition-duration: 1s;
    -moz-transition-duration: 1s; /* Firefox 4 */
    -webkit-transition-duration: 1s; /* Safari 和 Chrome */
    -o-transition-duration: 1s; /* Opera */
  }
  #Modal .close{
    display:block;
    font-weight: 600;
    height:40px;
    line-height: 40px;
    position:absolute;
    right:0px;
    text-shadow:-1px 1px 0px rgba(255,255,255,1);
    top:0px;
    width:40px;
    cursor: pointer;
    z-index: 999;
  }
  #Modal .mess-details-box{
    display:block;
    padding:0px;
    margin:0px;
  }
  #Modal .mess-details-box h3{
    background-image: -webkit-linear-gradient(top,#EEEEEE,#D5D5D5);
    border-bottom: 1px solid #AAA;
    height:40px;
    line-height: 40px;
    margin:0px;
    padding:0px 20px 0px 20px;
    text-shadow:-1px 1px 0px rgba(255,255,255,1);
  }
  #Modal .mess-details-box p{
    padding:0px 20px 0px 20px;
    word-wrap:break-word;

  }
  #Modal .mess-details-box .reply{
    display:block;
    position:absolute;
    bottom:10px;
    width:100%;
    text-align: center;
  }
  #Modal .mess-details-box .reply a{
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
  /*模态框结束*/

  .container{
    background: #F8F8F8;
    box-shadow: 0px 0px 1px 1px #ccc;
  }

  /*消息栏开始*/
  .mess-btn{
    background-color: #F8F8F8;
    display:inline-block;
  }
  .mess-btn ul{
    margin: 0;
    list-style: none;
    padding:0px;
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
  .mess-box dt{
    cursor:pointer;
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
  /*.mess-box dl:hover dd{
      height:100px;
      width:100%;
  }*/
  .notification{
    display:inline-block;
    min-height: 500px;
    float:right;
  }
  .notice{
    padding:30px;
  }
  /*消息栏结束*/
</style>
</html>