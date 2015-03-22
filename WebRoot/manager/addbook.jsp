<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>添加图书</title>
  </head>
  <body style="text-align: center;">
  
  	<form action="${pageContext.request.contextPath }/manager/BookServlet?method=add" method="post" enctype="multipart/form-data">
	  	<table frame="border" width="50%" border="0.5">
			<tr>
				<td>添加图书</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>  	
			<tr>
				<td>作者</td>
				<td>
					<input type="text" name="author">
				</td>
			</tr>
			<tr>
				<td>售价</td>
				<td>
					<input type="text" name="price">
				</td>
			</tr>
			<tr>
				<td>图片</td>
				<td>
					<input type="file" name="file">
				</td>
			</tr>
			<tr>
				<td>描述</td>
				<td>
					<textarea rows="5" cols="40" name="description"></textarea>
				</td>
			</tr>
			<tr>
				<td>所属分类</td>
				<td>
					<select name="category_id">
						<c:forEach var="c" items="${categorys }">
							<option value="${c.id }">${c.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<input type="reset" value="清空">				
				</td>
				<td>
					<input type="submit" value="提交">	
				</td>
			</tr>  	
	  	</table>
	</form>
  </body>
</html>
