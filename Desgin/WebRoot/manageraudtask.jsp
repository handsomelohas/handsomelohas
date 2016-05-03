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
    <h3>请输入你要评价信息</h3>
    <form action="${pageContext.request.contextPath}/task.do?flag=ManagerAudTask&id=${task.id}" method="post">
    <table>
    <tr><td>任务编号:</td><td><input type="text" readonly="readonly" name="taskId" value="${task.taskId}"/></td></tr>
    <tr><td>任务名称:</td><td><input type="text" readonly="readonly" name="taskName" value="${task.taskName}"/></td></tr>   
    <tr><td>职工编号:</td><td><input type="text" readonly="readonly" name="emploeeId" value="${task.emploeeId}"/></td></tr>
    <tr><td>职工名称:</td><td><input type="text" readonly="readonly" name="employeeName" value="${task.employeeName}"/></td></tr>
    <tr><td>任务级别:</td><td><input type="text" readonly="readonly" name="grade" value="${task.grade}"/></td></tr>
    <tr><td>任务状态:</td><td><input type="text" readonly="readonly" name="type" value="${task.type}"/></td></tr>
    <tr><td>完成度:</td><td><input type="text" readonly="readonly" name="percentage" value="${task.percentage}"/></td></tr>
    <tr><td>评价内容:</td><td><textarea name="audcontent" rows="5" cols="25" placeholder="请输入任务评价内容" required></textarea></td>
    <tr><td>任务得分:</td><td><input type="text" name="goal" placeholder="请输入职工应得的任务分数" required pattern="\d{2}"/></td></tr>
    <tr><td>满意度:</td>
    <td>
     <select name="satisfaction" required>
     	 <option></option>
         <option value="非常满意">非常满意</option>
         <option value="满意">满意</option>
         <option value="一般满意">一般满意</option>
         <option value="良好">良好</option>
         <option value="合格">合格</option>
         <option value="不合格">不合格</option>
         </select>
    </td></tr>
    <tr><td>选择评价状态:</td>
    <td>
     <select name="audtype" required>
     	 <option></option>
         <option value="已评">已评</option>
         </select>
    </td></tr>
    <tr><td>评价日期:</td><td><input type="date" name="audtime" required/></td>
    </tr>                 
    </table>         
    <input type="reset" class="btn btn-primary btn2" value="重置" /> 
    <input type="submit" class="btn btn-primary btn2" value="评价" />                 
    </form>
    </div>
    <!--/main-->
</div>
</body>
</html>
