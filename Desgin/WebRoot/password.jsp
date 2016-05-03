<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
    <title>工作进度管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
    <script type="text/javascript">
     	function checkPasswords() {
        var pass1 = document.getElementById("password1");
        var pass2 = document.getElementById("password2");
 
        if (pass1.value != pass2.value)
            pass1.setCustomValidity("两次输入的密码不匹配");
        else
            pass1.setCustomValidity("");
    	}
    </script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <ul class="navbar-list clearfix">
                <li><a class="on">工作进度管理系统</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="admin.jsp">管理员</a></li>
                <li><a href="password.jsp">修改密码</a></li>
                <li><a href="login.jsp">注销用户</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <i class="icon-font">&#xe003;</i>常用操作
                    <ul class="sub-menu">
                        <li><a href="${pageContext.request.contextPath}/employee.do?flag=addEmpUi"><i class="icon-font">&#xe008;</i>用户注册</a></li>
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=addTaskUi"><i class="icon-font">&#xe005;</i>任务创建</a></li>
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=showTask"><i class="icon-font">&#xe052;</i>任务信息检视</a></li>
                        <li><a href="${pageContext.request.contextPath}/employee.do?flag=showEmp"><i class="icon-font">&#xe033;</i>职工的信息检视</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div align="center">
    <h3>请输入修改密码信息</h3>
    <form action="${pageContext.request.contextPath}/login.do?flag=updatepassword" method="post">
    <table>
    <tr><td><label for="userId">用户编号:</label></td>
    <td><input readonly="readonly" type="text" name="userId" value="${loginuser.userId}"/></td>
    <tr><td><label for="password">旧密码:</label></td>
    <td><input readonly="readonly" type="password" value="${loginuser.password}"/></td>
    <tr><td><label for="password1">新密码:</label></td>
    <td><input type="password" id="password1" name="password1" onchange="checkPasswords()" placeholder="请输入新密码" required></td></tr>
    <tr><td><label for="password2">确认密码:</label></td>
    <td><input type="password" id="password2" name="password" onchange="checkPasswords()" placeholder="请输入确认密码" required></td></tr>       
    </table>
    <input type="reset" class="btn btn-primary btn2" value="重置" /> 
    <input type="submit" class="btn btn-primary btn2" onclick="document.passwordChange.password1.checkValidity()" value="修改密码" />
    </form>
    </div>
    <!--/main-->
</div>
</body>
</html>