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
                <li><a href="${pageContext.request.contextPath}/login.do?flag=goupdatepw2&userId=${loginuser.userId}">修改密码</a></li>
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
                        <li><a href="${pageContext.request.contextPath}/employee.do?flag=goEmpUi&userId=${loginuser.userId}"><i class="icon-font">&#xe008;</i>职工个人信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=showEmpTask&userId=${loginuser.userId}"><i class="icon-font">&#xe005;</i>个人任务</a></li>
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=showSubmitTask&userId=${loginuser.userId}"><i class="icon-font">&#xe052;</i>每天任务提交</a></li>
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=showSubmitFinshTask&userId=${loginuser.userId}"><i class="icon-font">&#xe033;</i>任务完成公示</a></li>
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=showEmpAudTask&userId=${loginuser.userId}"><i class="icon-font">&#xe004;</i>任务评价查看</a></li>
                        <li><a href="${pageContext.request.contextPath}/message.do?flag=goShowEmpMessage"><i class="icon-font">&#xe012;</i>公司信息</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <center>
    <h3>很遗憾，操作失败</h3>
    </center>
    <!--/main-->
</div>
</body>
</html>