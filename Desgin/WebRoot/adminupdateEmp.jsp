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
                        <li><a href="${pageContext.request.contextPath}/employee.do?flag=addEmpUi"><i class="icon-font">&#xe008;</i>职工注册</a></li>
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=addTaskUi"><i class="icon-font">&#xe005;</i>任务创建</a></li>
                        <li><a href="${pageContext.request.contextPath}/task.do?flag=showTask"><i class="icon-font">&#xe052;</i>任务信息检视</a></li>
                        <li><a href="${pageContext.request.contextPath}/employee.do?flag=showEmp"><i class="icon-font">&#xe033;</i>职工信息检视</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div align="center">
    <h3>请修改个人的信息</h3>
    <form action="${pageContext.request.contextPath}/employee.do?flag=updateEmp" method="post">
    <table>
         <tr><td>职工编号:</td><td><input type="text" name="userId" value="${emp.userId}" required pattern="([L]*[H]*(\d{4}))"/></td></tr>
         <tr><td>职工密码:</td><td><input type="password" name="password" value="${emp.password}" required/></td></tr>
         <tr><td>职工名字:</td><td><input type="text" name="userName" value="${emp.userName}" required/></td></tr>
         <tr><td>职工性别:</td><td><input type="text" name="sex" value="${emp.sex}" required/></td></tr>
         <tr><td>职工年龄:</td><td><input type="number" name="age" value="${emp.age}" min="18" max="100" step="1" required/></td></tr>
         <tr><td>职工部门:</td><td>
         <select name="deport" required>
         <c:if test="${emp.deport=='开发部'}">
         <option value="开发部"  selected="selected">开发部</option>
         <option value="人事部">人事部</option>
         <option value="网络部">网络部</option>
         <option value="电脑部">电脑部</option>
         <option value="财务部">财务部</option>
         <option value="销售部">销售部</option>
         </c:if>
         <c:if test="${emp.deport=='人事部'}">
         <option value="开发部">开发部</option>
         <option value="人事部"  selected="selected">人事部</option>
         <option value="网络部">网络部</option>
         <option value="电脑部">电脑部</option>
         <option value="财务部">财务部</option>
         <option value="销售部">销售部</option>
         </c:if>
         <c:if test="${emp.deport=='网络部'}">
         <option value="开发部">开发部</option>
         <option value="人事部">人事部</option>
         <option value="网络部"  selected="selected">网络部</option>
         <option value="电脑部">电脑部</option>
         <option value="财务部">财务部</option>
         <option value="销售部">销售部</option>
         </c:if>
         <c:if test="${emp.deport=='电脑部'}">
         <option value="开发部">开发部</option>
         <option value="人事部">人事部</option>
         <option value="网络部">网络部</option>
         <option value="电脑部"  selected="selected">电脑部</option>
         <option value="财务部">财务部</option>
         <option value="销售部">销售部</option>
         </c:if>
         <c:if test="${emp.deport=='财务部'}">
         <option value="开发部">开发部</option>
         <option value="人事部">人事部</option>
         <option value="网络部">网络部</option>
         <option value="电脑部">电脑部</option>
         <option value="财务部" selected="selected">财务部</option>
         <option value="销售部">销售部</option>
         </c:if>
         <c:if test="${emp.deport=='销售部'}">
         <option value="开发部">开发部</option>
         <option value="人事部">人事部</option>
         <option value="网络部">网络部</option>
         <option value="电脑部">电脑部</option>
         <option value="财务部">财务部</option>
         <option value="销售部" selected="selected">销售部</option>
         </c:if>
         </select>
         </td></tr>
         <tr><td>职位:</td><td>
         <select name="position" required>
         <c:if test="${emp.position=='经理'}">
         <option value="经理" selected="selected">经理</option>
         <option value="主管">主管</option>
         <option value="程序员">程序员</option>
         <option value="销售员">销售员</option>
         <option value="会计员">会计员</option>
         <option value="网络员">网络员</option>
         </c:if>
         <c:if test="${emp.position=='主管'}">
         <option value="经理">经理</option>
         <option value="主管" selected="selected">主管</option>
         <option value="程序员">程序员</option>
         <option value="销售员">销售员</option>
         <option value="会计员">会计员</option>
         <option value="网络员">网络员</option>
         </c:if>
         <c:if test="${emp.position=='程序员'}">
         <option value="经理">经理</option>
         <option value="主管">主管</option>
         <option value="程序员" selected="selected">程序员</option>
         <option value="销售员">销售员</option>
         <option value="会计员">会计员</option>
         <option value="网络员">网络员</option>
         </c:if>
         <c:if test="${emp.position=='销售员'}">
         <option value="经理">经理</option>
         <option value="主管">主管</option>
         <option value="程序员">程序员</option>
         <option value="销售员" selected="selected">销售员</option>
         <option value="会计员">会计员</option>
         <option value="网络员">网络员</option>
         </c:if>
         <c:if test="${emp.position=='会计员'}">
         <option value="经理">经理</option>
         <option value="主管">主管</option>
         <option value="程序员">程序员</option>
         <option value="销售员">销售员</option>
         <option value="会计员" selected="selected">会计员</option>
         <option value="网络员">网络员</option>
         </c:if>
         <c:if test="${emp.position=='网络员'}">
         <option value="经理">经理</option>
         <option value="主管">主管</option>
         <option value="程序员">程序员</option>
         <option value="销售员">销售员</option>
         <option value="会计员">会计员</option>
         <option value="网络员" selected="selected">网络员</option>
         </c:if>
         </select>
         </td></tr>
         
         <tr><td>权限:</td><td>
         <select name="role" required>
         <c:if test="${emp.role==1}">
         <option value="1" selected="selected">管理员</option>
         <option value="2">经理</option>
         <option value="3">职工</option>
         </c:if>
         <c:if test="${emp.role==2}">
         <option value="1">管理员</option>
         <option value="2" selected="selected">经理</option>
         <option value="3">职工</option>
         </c:if>
         <c:if test="${emp.role==3}">
         <option value="1">管理员</option>
         <option value="2">经理</option>
         <option value="3" selected="selected">职工</option>
         </c:if>
         </select>
         </td></tr>
         <tr><td>职工入职日期:</td><td><input type="date" name="indate" value="${emp.indate}" required/></td></tr>
    </table>  
      <input type="reset" class="btn btn-primary btn2" value="重置" /> 
      <input type="submit" class="btn btn-primary btn2" value="修改" />                 
    </form>
    </div>
    <!--/main-->
</div>
</body>
</html>