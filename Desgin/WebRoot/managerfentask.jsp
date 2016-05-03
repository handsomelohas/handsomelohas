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
                <li><a href="manager.jsp">经理</a></li>
                <li><a href="${pageContext.request.contextPath}/login.do?flag=goupdatepw1&userId=${loginuser.userId}">修改密码</a></li>
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
    <div align="center">
    <h3>请输入你要分配的任务信息</h3>
    <form action="${pageContext.request.contextPath}/task.do?flag=fenTask&id=${task.id}" method="post">
    <table>
    <tr><td>任务编号:</td><td><input type="text" readonly="readonly" name="taskId" value="${task.taskId}"/></td></tr>
    <tr><td>任务名称:</td><td><input type="text" readonly="readonly" name="taskName" value="${task.taskName}"/></td></tr>
    <tr><td>任务内容:</td><td><textarea name="content" rows="5" cols="25" readonly="readonly"><c:out value="${task.content}"></c:out></textarea></td>
    <tr><td>创建人编号:</td><td><input type="text" readonly="readonly" name="founderId" value="${task.founderId}"/></td></tr>
    <tr><td>创建人名称:</td><td><input type="text" readonly="readonly" name="founder" value="${task.founder}"/></td></tr>
    <tr><td>分配人编号:</td><td><input type="text" readonly="readonly" name="fenId" value="${loginuser.userId}"/></td></tr>
    <tr><td>分配人名称:</td><td><input type="text" readonly="readonly" name="fener" value="${loginuser.userName}"/></td></tr>
    <tr><td>任务创建日期:</td><td><input type="date" readonly="readonly" name="startTime" value="${task.startTime}"/></td></tr>
    <tr><td>任务完成日期:</td><td><input type="date" readonly="readonly" name="endTme" value="${task.endTme}"/></td></tr>
    <tr><td>职工编号:</td><td>
    <select name="emploeeId">
    <c:forEach items="${role3}" var="emp">
       <option value="${emp.userId}">${emp.userId}</option>
    </c:forEach>
    </select>
    </td></tr>
    <tr><td>职工名称:</td><td>
    <select name="employeeName">
    <c:forEach items="${role3}" var="emp">
       <option value="${emp.userName}">${emp.userName}</option>
    </c:forEach>
    </select>
    </td></tr>
    <tr><td>任务分配日期:</td><td><input type="date" name="fenTime" required/></td></tr>
    <tr><td>任务状态:</td><td>
       <select name="type" required>
       <option></option>
       <option value="分配">分配</option>
       </select>
    </td></tr>   
    </table>
    <input type="reset" class="btn btn-primary btn2" value="重置" /> 
    <input type="submit" class="btn btn-primary btn2" value="分配任务" />                 
    </form>
    </div>
    <!--/main-->
</div>
</body>
</html>
