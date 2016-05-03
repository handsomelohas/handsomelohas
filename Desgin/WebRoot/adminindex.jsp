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
                <li><a href="admin.jsp">管理员</a></li>
                <li><a href="${pageContext.request.contextPath}/login.do?flag=goupdatepw&userId=${loginuser.userId}">修改密码</a></li>
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
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=showTask"><i class="icon-font">&#xe052;</i>任务信息公示</a></li>
                        <li><a href="${pageContext.request.contextPath}/employee.do?flag=showEmp"><i class="icon-font">&#xe033;</i>职工的信息检视</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>您好！欢迎使用工作任务进度管理系统</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>工作任务进度管理系统介绍</h1>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">本系统名称</label><span class="res-info">工作任务进度管理系统</span>
                    </li>
                    <li>
                        <label class="res-lab">系统介绍</label><span class="res-info">此系统让公司更快更好管理项目,从而提高工作效率</span>
                    </li>
                    <li>
                        <label class="res-lab">LHS设计-版本</label><span class="res-info">v-5.0</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>版权介绍</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">本系统版权持有人：</label><span class="res-info">在路上～漫爆</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>