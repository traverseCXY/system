<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>

	<link rel="stylesheet" href="/static/css/bootstrap.css">

	<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>

	<link rel="stylesheet" type="text/css" href="/static/css/login.css"/>
</head>
<body >
 <div id="login_frame">    
   <p id="image_logo">
   		<img id="img" src="/static/image/logo.png">
   </p>     
   <form method="post" action="/sys_student/dologin">
    	<p>
    		<label class="label_input" style="background: skyblue">用户名</label>
   	 		<input type="text" id="username" value="${account}" name="account" class="text_field"/>
   		</p>        
    	<p>
    		<label class="label_input" style="background: skyblue">密码</label>
    		<input type="password" id="password" value="${password}" name="password" class="text_field"/>
    	</p>
    	<%--<input type="text" id="vc" name="vc" style="height:30px;width:100px;font-size:20px;"/>
    	<img id="imageVc" src="/static/kaptcha.jpg"/><br/>--%>
    	<div id="login_control">            
     		<input type="submit" id="btn_login"  style="background: skyblue" value="登录" />
       </div>   <br/>
	   <a style="color: red">${warning}</a>
    </form>
 </div>

 <script>
 var coder;
 var username;
 var password;
 window.onload=function(){
	/* function code(){
		/!* if($("#username").val()!=null&&$("#password").val()!=null){
		 	alert("登陆失败");
		 }*!/
		 $.post("checkcode",function(data){
			 coder=data;
		});
	}*/
	/* code();*/
	 
	 /*$("#imageVc").click(function(){
		 var name=$("#username").val();
		 var password=$("#password").val();
		 location.href="login?name="+name+"&password="+password;
	 });//end imageVc.click*/
 }
/* function login(){
		if($("#username").val()==""){
			alert("账号不能为空！");
			return false;
		}else if($("#password").val()==""){
			alert("密码不能为空！");
			return false;
		}/!*else if($("#vc").val()==""){
			alert("验证码不能为空！");
			return false;
		}else if($("#vc").val()!=coder.trim()){
			alert("验证码不对");
			$("#imageVc").click();
			return false;
		}*!/
	 }//end login();*/
	 /*$("#image_logo").click(function(){
		 	if($("#img").prop("src")=="/static/image/logo.png"||$("#img").prop("src")=="/static/image/logo.png"){
		 		$("#img").attr("src","/static/image/logoTwo.png");
		 	}else{
		 		$("#img").attr("src","/static/image/logo.png");
		 	}
	 });//end #image_logo.click*/
 </script>
</body>
</html>