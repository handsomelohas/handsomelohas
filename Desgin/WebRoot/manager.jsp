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
                <li><a href="manager.jsp">经理</a></li>
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
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=showTask1&userId=${loginuser.userId}"><i class="icon-font">&#xe008;</i>任务信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=showFenTask&userId=${loginuser.userId}"><i class="icon-font">&#xe052;</i>任务信息检视</a></li>
                        <li><a href="${pageContext.request.contextPath}/employee.do?flag=showEmp2&userId=${loginuser.userId}"><i class="icon-font">&#xe033;</i>职工信息检视</a></li>
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=showLookTask&userId=${loginuser.userId}"><i class="icon-font">&#xe004;</i>职工任务跟踪</a></li>
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=showAudTask&userId=${loginuser.userId}"><i class="icon-font">&#xe012;</i>职工任务评论</a></li>
                        <li><a href="${pageContext.request.contextPath}/message.do?flag=goShowManMessage&userId=${loginuser.userId}"><i class="icon-font">&#xe012;</i>公司信息</a></li>
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
        <div class="result-wrap" align="center">
            <div class="result-title">
                <h1>个人信息</h1>
            </div>
            <div class="result-content">
               <table>
			   <tr><td>经理编号》》》》》》》》》》》》</td><td>${loginuser.userId}</td></tr>
			   <tr><td>经理名称》》》》》》》》》》》》</td><td>${loginuser.userName}</td></tr>  
			   </table>
            </div>
        </div>
       
    <!--/main-->
</div>
</body>
</html>