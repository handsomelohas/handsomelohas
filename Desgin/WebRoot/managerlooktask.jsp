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
    <script type="text/javascript" language="javascript">

        function abc(){
           return  window.confirm("你真的要delete?");
        }
        function go(){
          var pageNow=document.getElementById("pageNow").value;
           pageCount=${pageCount};
          if(pageNow<=0 || pageNow>pageCount){
                window.alert("页数越界了，请重新输入");
                return false;
          }
          window.location.href="${pageContext.request.contextPath}/task.do?flag=showLookTask&userId=${loginuser.userId}&pageNow="+pageNow;
        };

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
    <center>
    <h4>职工任务信息跟踪</h4>
    <form action="${pageContext.request.contextPath}/task.do?flag=showQLookTask&userId=${loginuser.userId}" method="post">
            任务编号：<input type="text" name="taskId" />
    <input type="submit" class="btn btn-primary btn2" value="查询">
    </form>
    <table border="1px">
    <tr bgcolor="#76EE00">
    <td width=50px align="center">序号</td><td width=100px align="center">任务编号</td>
    <td width=205px align="center">任务名称</td><td width=150px align="center">任务内容</td>
    <td width=125px align="center">任务创建日期</td><td width=125px align="center">任务完成日期</td>
    <td width=100px align="center">任务的级别</td><td width=100px align="center">任务状态</td>
    <td width=125px align="center">职工编号</td><td width=125px align="center">职工名称</td>
    <td width=125px align="center">任务完成度</td>
    <td width=125px align="center">操作</td>
    </tr>
    <c:forEach items="${tasklist}" var="task">
    <tr>
    <td align="center">${task.id}</td><td align="center">${task.taskId}</td>
    <td align="center">${task.taskName}</td><td align="center">${task.content}</td>
    <td align="center">${task.startTime}</td><td align="center">${task.endTme}</td>
    <td align="center">${task.grade}</td><td align="center">${task.type}</td>
    <td align="center">${task.emploeeId}</td><td align="center">${task.employeeName}</td>
    <td align="center">${task.percentage}</td>
    <td align="center"><a href="${pageContext.request.contextPath}/message.do?flag=goPublishMessage&id=${task.id}&userId=${loginuser.userId}" class="btn btn-primary btn2">提醒</a>   
    </tr>
    </c:forEach>
    </table>
         <c:if test="${pageNow>1 }">
       <a href="${pageContext.request.contextPath}/task.do?flag=showLookTask&userId=${loginuser.userId}&pageNow=${pageNow-1 }"><input type="button" class="btn btn-primary btn2" value="上一页" /></a>  
    </c:if>
    <c:forEach var="i" begin="1" end="${pageCount}" >
        <a href="${pageContext.request.contextPath}/task.do?flag=showLookTask&userId=${loginuser.userId}&pageNow=${i}">[${i }]</a>
    </c:forEach>
    <c:if test="${pageNow<pageCount }">
      <a href="${pageContext.request.contextPath}/task.do?flag=showLookTask&userId=${loginuser.userId}&pageNow=${pageNow+1 }"><input type="button" class="btn btn-primary btn2" value="下一页" /></a>
    </c:if>
               当前页面${pageNow }/总页数${pageCount }<br>
              跳转到第<input type="text" id="pageNow" name="pageNow">页 <input  type="button" class="btn btn-primary btn2" onclick=go() value="跳转">                
    </center>
    <!--/main-->
</div>
</body>
</html>