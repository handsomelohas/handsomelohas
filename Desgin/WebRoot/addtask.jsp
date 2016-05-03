<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=showTask"><i class="icon-font">&#xe052;</i>任务信息检视</a></li>
                        <li><a href="${pageContext.request.contextPath}/employee.do?flag=showEmp"><i class="icon-font">&#xe033;</i>职工的信息检视</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div align="center">
    <h3>请输入你要创建的任务信息</h3>
    <form action="${pageContext.request.contextPath}/task.do?flag=addTask" method="post">
    <table>
    <tr><td>任务编号:</td><td><input type="text" name="taskId" placeholder="请输入任务编号" required pattern="([T]*[S]*(\d{4}))"/></td></tr>
    <tr><td>任务名称:</td><td><input type="text" name="taskName" placeholder="请输入任务名称" required/></td></tr>
    <tr><td>任务内容:</td><td><textarea name="content" rows="5" cols="25" placeholder="请输入任务内容介绍" required></textarea></td>
    <tr><td>创建人编号:</td><td><input type="text" name="founderId" value="${loginuser.userId}" required pattern="([L]*[H]*(\d{4}))"/></td></tr>
    <tr><td>创建人名称:</td><td><input type="text" name="founder" value="${loginuser.userName}"/></td></tr>
    <tr><td>负责人编号:</td><td>
    <select name="fenId">
    <c:forEach items="${role2}" var="emp">
       <option value="${emp.userId}">${emp.userId}</option>
    </c:forEach>
    </select>
    </td></tr>
    <tr><td>负责人名称:</td><td>
    <select name="fener">
    <c:forEach items="${role2}" var="emp">
       <option value="${emp.userName}">${emp.userName}</option>
    </c:forEach>
    </select>
    </td></tr>
    <tr><td>任务创建日期:</td><td><input type="date" name="startTime" required/></td></tr>
    <tr><td>任务完成日期:</td><td><input type="date" name="endTme" required/></td></tr>
    <tr><td>任务的级别:</td><td>
       <select name="grade" required>
       <option></option>
       <option value="1">困难</option>
       <option value="2">一般困难</option>
       <option value="3">正常</option>
       <option value="4">容易</option>
       <option value="5">简单</option>
       </select>
    </td></tr>
    <tr><td>任务状态:</td><td>
       <select name="type" required>
       <option></option>
       <option value="未分配">未分配</option>
       </select>
    </td></tr>                  
    </table>         
    <input type="reset" class="btn btn-primary btn2" value="重置" /> 
    <input type="submit" class="btn btn-primary btn2" value="创建任务" />                 
    </form>
    </div>
    <!--/main-->
</div>
</body>
</html>
