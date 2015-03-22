<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title> 注册界面 </title>
  </head>
  <body style="text-align: center;">
  
	  <h2>用户注册</h2>
	  
	  <form action="${pageContext.request.contextPath }/client/RigisterServlet" method="post">
		  用户名 <input type="text" name="username"><br/>
		  密码 &nbsp;&nbsp;<input type="password" name="password"><br/>
		  电话 &nbsp;&nbsp;<input type="text" name="phone"><br/>
		  住址 &nbsp;&nbsp;<input type="text" name="address"><br/>
		  邮箱 &nbsp;&nbsp;<input type="text" name="email"><br/><br/>
		  <input type="submit" value="注册">  
	  </form>

  </body>
</html>