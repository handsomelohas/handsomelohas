<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <h4>任务信息的公示</h4>
            任务编号：<input type="text" name="" /><input class="btn btn-primary btn2" name="sub" value="查询" type="submit">
    <table border="1px">
    <tr><td>序号</td><td>任务编号</td><td>任务名称</td><td>创建人编号</td>
    <td>任务的创建人</td><td>任务创建日期</td><td>任务完成日期</td>
    <td>任务的级别</td><td>任务的负责人</td><td>操作</td></tr>
    <c:forEach items="${tasklist}" var="task">
    <tr>
    <td>${task.id}</td><td>${task.taskId}</td><td>${task.taskName}</td><td>${task.founderId}</td>
    <td>${task.founder}</td><td>${task.startTime}</td><td>${task.endTme}</td>
    <td>${task.grade}</td><td>${task.employeeName}</td>
    <td><a onclick="return abc()" href="${pageContext.request.contextPath}/task.do?flag=delTask&id=${task.id}" class="btn btn-primary btn2">删除</a></td>
    </tr>
    </c:forEach>
    </table>
         <c:if test="${pageNow>1 }">
       <a href="${pageContext.request.contextPath}/task.do?flag=showTask&pageNow=${pageNow-1 }"><input type="button" class="btn btn-primary btn2" value="上一页" /></a>  
    </c:if>
    <c:forEach var="i" begin="1" end="${pageCount}" >
        <a href="${pageContext.request.contextPath}/task.do?flag=showTask&pageNow=${i}">[${i }]</a>
    </c:forEach>
     <c:if test="${pageNow<pageCount }">
      <a href="${pageContext.request.contextPath}/task.do?flag=showTask&pageNow=${pageNow+1 }"><input type="button" class="btn btn-primary btn2" value="下一页" /></a>
    </c:if>
               当前页面${pageNow }/总页数${pageCount }<br>
              跳转到第<input type="text" id="pageNow" name="pageNow">页 <input  type="button" class="btn btn-primary btn2" onclick=go() value="跳转">                
    </center>
    <!--/main-->
</div>
</body>
</html>