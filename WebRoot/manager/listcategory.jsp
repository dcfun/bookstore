<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>列出所有分类</title>
  </head>
  <body style="text-align: center;">
  	
  	<br/><br/>
  	<h2>图书信息</h2>
 
  	<table frame="border" width="60%" align="center">
  	
  		<tr>
  			<td>分类名称</td>
  			<td>分类描述</td>
  			<td>操作</td>
  		</tr>

		<c:forEach var="c" items="${categorys}">
		
			<tr>
				<td>${c.name }</td>			
				<td>${c.description }</td>
				<td>
					<a href="">删除</a>
					<a href="">修改</a>
				</td>
			</tr>
		</c:forEach>
  	
  	</table>

  </body>
</html>

