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

        function go(){
          var pageNow=document.getElementById("pageNow").value;
           pageCount=${pageCount};
          if(pageNow<=0 || pageNow>pageCount){
                window.alert("页数越界了，请重新输入");
                return false;
          }
          window.location.href="${pageContext.request.contextPath}/task.do?flag=showEmpTask&userId=${loginuser.userId}&pageNow="+pageNow;
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
    <h4>任务提醒信息</h4>
    <table border="1px">
    <tr bgcolor="#76EE00">
    <td width=100px align="center">序号</td>
    <td width=150px align="center">发送人</td><td width=250px align="center">发送时间</td>
    <td width=150px align="center">接收人</td><td width=500px align="center">任务提醒信息</td>
    <td width=100px align="center">操作</td></tr>
    <c:forEach items="${messageList}" var="message">
    <tr>
    <td align="center">${message.mesId}</td>
    <td align="center">${message.sender.userName}</td>
    <td align="center">${message.mesTime}</td>
    <td align="center">${message.getter.userName}</td>
    <td align="center">${message.content}</td>
    <td align="center"><a href="${pageContext.request.contextPath}/message.do?flag=goReplyMessage&mesId=${message.mesId}"><i class="icon-font">&#xe012;</i>回复</a></td>
    </tr>
    </c:forEach>
    </table>
    </center>
    <!--/main-->
</div>
</body>
</html>