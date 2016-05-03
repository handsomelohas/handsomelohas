<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>工作进度管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
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
                <li><a href="employee.jsp">公司职工</a></li>
                <li><a href="password1.jsp">修改密码</a></li>
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
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="employee.jsp"><i class="icon-font">&#xe008;</i>职工个人信息</a></li>
                        <li><a href="employeetask.jsp"><i class="icon-font">&#xe005;</i>个人任务</a></li>
                        <li><a href="updateemployee.jsp"><i class="icon-font">&#xe006;</i>修改个人资料</a></li>
                        <li><a href="showtask1.jsp"><i class="icon-font">&#xe052;</i>任务公示</a></li>
                        <li><a href="loadtask.jsp"><i class="icon-font">&#xe033;</i>任务提交</a></li>
                        <li><a href="showaudittask.jsp"><i class="icon-font">&#xe004;</i>任务评价查看</a></li>
                        <li><a href="message.jsp"><i class="icon-font">&#xe012;</i>公司信息</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <center>
    <h3>请修改个人的信息</h3>
    <form action="" method="post">
    <table>
         <tr><td>职工编号:</td><td><input type="text" name="" value="L888"/></td></tr>
         <tr><td>职工密码:</td><td><input type="password" name="" /></td></tr>
         <tr><td>职工名字:</td><td><input type="text" name="" value="小华"/></td></tr>
         <tr><td>职工性别:</td><td><input type="text" name="" value="男" /></td></tr>
         <tr><td>职工年龄:</td><td><input type="text" name="" value="23"/></td></tr>
         <tr><td>职工部门:</td><td><input type="text" name="" value="开发部"/></td></tr>
         <tr><td>职工职位:</td><td><input type="text" name="" value="程序员"/></td></tr>	
         <tr><td>职工入职日期:</td><td><input type="text" name="" value="2014/6/8"/></td></tr>
    </table>  
      <input type="reset" class="btn btn-primary btn2" value="重置" /> 
      <input type="submit" class="btn btn-primary btn2" value="修改" />                 
    </form>
    </center>
    <!--/main-->
</div>
</body>
</html>