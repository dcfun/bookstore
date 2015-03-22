<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>首页头</title>
  </head>
  <body style="text-align: center;">
  
  	<br>
	  	<h1>dcfun的网上书店</h1>
	<br>
		<div style="float: left;margin-left: 600px;height: 20px">
			<a href="${pageContext.request.contextPath }/client/IndexServlet?method=getall" target="body">首页</a>
			<a href="">查看购物车</a>
			<a href="">查看订单</a>
		</div>
		
		<div style="float: right;height: 20px">
		
		  <c:if test="${user==null}">
			<form action="${pageContext.request.contextPath }/client/LoginServlet" method="post">
			
				用户名：<input type="text" name="username" style="width: 50px">
				密码：<input type="password" name="password" style="width: 50px">
				<input type="submit" value="登录">
				<input type="button" value="注册" onclick="javascript:window.parent.body.location.href='${pageContext.request.contextPath }/client/regiester.jsp'">
			</form>
		  </c:if>
		  
		  <c:if test="${user!=null}">
		  	Welcome! ${user.username } <a href="${pageContext.request.contextPath }/client/LogoutServlet">注销</a>
		  </c:if>
		  
		</div>
  </body>
</html>