<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
  <head>
    <base href="<%=basePath%>">
 	<title>系统登录</title>
 	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
$(function(){
	$(".screenbg ul li").each(function(){
		$(this).css("opacity","0");
	});
	$(".screenbg ul li:first").css("opacity","1");
	var index = 0;
	var t;
	var li = $(".screenbg ul li");	
	var number = li.size();
	function change(index){
		li.css("visibility","visible");
		li.eq(index).siblings().animate({opacity:0},3000);
		li.eq(index).animate({opacity:1},3000);
	}
	function show(){
		index = index + 1;
		if(index<=number-1){
			change(index);
		}else{
			index = 0;
			change(index);
		}
	}
	t = setInterval(show,8000);
	//根据窗口宽度生成图片宽度
	var width = $(window).width();
	$(".screenbg ul img").css("width",width+"px");
});
</script>

</head>

<body>

<div class="login-box">
	<h1>工作进度管理系统登录</h1>
	<form method="post" action="${pageContext.request.contextPath}/login.do?flag=login">
		<div class="name">
			<label>账号：</label>
			<input type="text" name="userId" tabindex="1" placeholder="请输入用户编号" required pattern="([L]*[H]*(\d{4}))"/>
		</div>
		<div class="password">
			<label>密  码：</label>
			<input type="password" name="password" maxlength="16" tabindex="2" placeholder="请输入用户密码" required/>
		</div>
		<div class="code">
			<label>请选择角色：</label>
			<select name="role" required>
			  <option></option>
			  <option value="1">管理员</option>
			  <option value="2">经理</option>
			  <option value="3">职工</option>
			</select>
		</div>
		<div class="remember">
			<input type="checkbox" id="remember" tabindex="4">
			<label>记住密码</label>
		</div>
		<div class="login">
			<button type="submit" tabindex="5">登录</button>
		</div>
	</form>
</div>

<div class="screenbg">
	<ul>
		<li><a href="javascript:;"><img src="images/2.jpg"></a></li>
	</ul>
</div>
</body>
</html>