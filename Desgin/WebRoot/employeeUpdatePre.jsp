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
    <div align="center">
    <h3>请你修改任务状态信息</h3>
    <form action="${pageContext.request.contextPath}/task.do?flag=empUpdateTaskPre&id=${task.id}" method="post">
    <table>
    <tr><td>任务编号:</td><td><input type="text" readonly="readonly" name="taskId" value="${task.taskId}"/></td></tr>
    <tr><td>任务名称:</td><td><input type="text" readonly="readonly" name="taskName" value="${task.taskName}"/></td></tr>
    <tr><td>任务内容:</td><td><textarea name="content" rows="5" cols="25" readonly="readonly"><c:out value="${task.content}"></c:out></textarea></td>
    <tr><td>分配人编号:</td><td><input type="text" readonly="readonly" name="fenId" value="${task.fenId}"/></td></tr>
    <tr><td>分配人名称:</td><td><input type="text" readonly="readonly" name="fener" value="${task.fener}"/></td></tr>
    <tr><td>任务创建日期:</td><td><input type="date" readonly="readonly" name="startTime" value="${task.startTime}"/></td></tr>
    <tr><td>任务完成日期:</td><td><input type="date" readonly="readonly" name="endTme" value="${task.endTme}"/></td></tr>
    <tr><td>任务分配日期:</td><td><input type="date" readonly="readonly" name="fenTime" value="${task.fenTime}"/></td></tr>
    <tr><td>完成度:</td><td><input type="text" name="percentage" placeholder="请输入任务完成度" required></td></tr>
    <tr><td>任务状态:</td><td>
       <select name="type" required>
       <option></option>
       <option value="开始">开始</option>
       <option value="进行中">进行中</option>
       <option value="完成">完成</option>
       </select>
    </td></tr>    
    </table>
    <input type="reset" class="btn btn-primary btn2" value="重置" /> 
    <input type="submit" class="btn btn-primary btn2" value="提交任务" />                 
    </form>
    </div>
    <!--/main-->
</div>
</body>
</html>
