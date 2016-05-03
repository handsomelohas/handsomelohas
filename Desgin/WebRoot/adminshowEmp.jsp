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
          window.location.href="${pageContext.request.contextPath}/employee.do?flag=showEmp&pageNow="+pageNow;
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
    <center>
    <h4>职工的信息检视</h4>
    <form action="${pageContext.request.contextPath}/employee.do?flag=showEmp1" method="post">
            职工编号：<input type="text" name="userId" />
    <input type="submit" class="btn btn-primary btn2" value="查询">
    </form>
    <table border="1px">
    <tr bgcolor="#76EE00">
    <td width=150px align="center">职工编号</td><td width=150px align="center">职工名称</td>
    <td width=100px align="center">姓别</td><td width=100px align="center">年龄</td>
    <td width=125px align="center">部门</td><td width=125px align="center">职位</td>
    <td width=150px align="center">入职日期</td><td width=125px align="center">权限</td>
    <td width=200px align="center">操作</td></tr>
    <c:forEach items="${emplist}" var="emp">
    <tr>
    <td align="center">${emp.userId}</td><td align="center">${emp.userName}</td>
    <td align="center">${emp.sex}</td><td align="center">${emp.age}</td>
    <td align="center">${emp.deport}</td><td align="center">${emp.position}</td>
    <td align="center">${emp.indate}</td><td align="center">${emp.role}</td>
    <td align="center"><a href="${pageContext.request.contextPath}/employee.do?flag=goupdateEmp&userId=${emp.userId}" class="btn btn-primary btn2">修改</a>   
    <a onclick="return abc()" href="${pageContext.request.contextPath}/employee.do?flag=delEmp&userId=${emp.userId}" class="btn btn-primary btn2">删除</a></td>
    </tr>
    </c:forEach>
    </table>
    <c:if test="${pageNow>1 }">
       <a href="${pageContext.request.contextPath}/employee.do?flag=showEmp&pageNow=${pageNow-1 }"><input type="button" class="btn btn-primary btn2" value="上一页" /></a>  
    </c:if>
    <c:forEach var="i" begin="1" end="${pageCount}" >
        <a href="${pageContext.request.contextPath}/employee.do?flag=showEmp&pageNow=${i}">[${i }]</a>
    </c:forEach>
     <c:if test="${pageNow<pageCount }">
      <a href="${pageContext.request.contextPath}/employee.do?flag=showEmp&pageNow=${pageNow+1 }"><input type="button" class="btn btn-primary btn2" value="下一页" /></a>
    </c:if>
               当前页面${pageNow }/总页数${pageCount }<br>
              跳转到第<input type="text" id="pageNow" name="pageNow">页 <input  type="button" class="btn btn-primary btn2" onclick=go() value="跳转">                 
    </center>
    <!--/main-->
</div>
</body>
</html>