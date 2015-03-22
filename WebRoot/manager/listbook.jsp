<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <title> OXX </title>
  </head>
  <body style="text-align: center;">
   
  	<br/><br/>
  	<h2>图书信息</h2>
  	
  	<table frame="border" width="50%" align="center">
		<tr>
			<td>图书名称</td>
			<td>作者</td>
			<td>价格</td>
			<td>图片</td>
			<td>描述</td>
			<td>操作</td>
		</tr>  	
		
		<c:forEach var="c" items="${page.list }">
			<tr>
				<td>${c.name }</td>	
				<td>${c.author }</td>
				<td>${c.price }</td>
				<td>
					<a href="${pageContext.request.contextPath }/images/${c.image }">查看图片</a>
				</td>
				<td>
					<a href="#">修改</a>
					<a href="#">删除</a>				
				</td>
			
			</tr>
  		</c:forEach>
  	</table>
	<br/>
	
	当前第[${page.pagenum }]页 &nbsp;&nbsp;
	
	<c:forEach var="pagenum" begin="${page.startPage }" end="${page.endPage }">
		[<a href="${pageContext.request.contextPath }/manager/BookServlet?method=list&pagenum=${pagenum }">${pagenum }</a>]
	</c:forEach>
	
	&nbsp;共[${page.totalpage }]页 有[${page.totalrecord }]本书
  
  </body>
</html>