<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>管理员</title>
</head>
<body>
	<jsp:include page="/WEB-INF/publicJsp/head.jsp" />
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
    <div>
        <table id="box"></table>
        <div id="tb" style="padding:5px;">
		<div style="margin-bottom:5px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="obj.add();">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" style="display:none;" id="save" onclick="obj.save();">保存</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" style="display:none;" id="redo" onclick="obj.redo();">取消编辑</a>		
		</div>
		<div style="padding:0 0 0 7px;color:#333;">
			查询帐号：<input type="text" class="textbox" name="user" style="width:110px">
			创建时间从：<input type="text" name="date_from" class="easyui-datebox" editable="false" style="width:110px">
			到：<input type="text" name="date_to" class="easyui-datebox" editable="false" style="width:110px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="obj.search();">查询</a>
		</div>
</div>
    </div>
    <!--/sidebar-->
    <center>
    <h4>个人信息</h4>
    <table>
    <tr><td>管理员编号》》》》》》》》》》》》</td><td>${loginuser.userId}</td></tr>
    <tr><td>管理员名称》》》》》》》》》》》》</td><td>${loginuser.userName}</td></tr>  
    </table>
    </center>
	</div>
	<jsp:include page="/WEB-INF/publicJsp/foot.jsp" />
</body>
</html>