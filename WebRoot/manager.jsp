<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    <title>后台管理页</title>
  </head>
  
  <frameset rows="25%, *">
  	
  	<frame src="${pageContex.request.contextPath}manager/head.jsp" name="head">
  	
  	<frameset cols="15%, *">
  		<frame src="${pageContex.request.contextPath}manager/left.jsp" name="left">
  		<frame src="${pageContex.request.contextPath}manager/body.jsp" name="body">
  	</frameset>
  
  </frameset>
  
  
</html>



