<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>My JSP 'addcustomer.jsp' starting page</title>
  </head>
  <body style="text-align: center;">

	<div id="content">
		
		<div id="category" style="float: left;width: 200px;border: 1px solid red; text-align: left;margin-left: 150px;height: 300px"> 
			<br/>分类列表：
			<ul>
				<c:forEach var="category" items="${categorys }">
					<li>
						<a href="${pageContext.request.contextPath }/client/IndexServlet?method=listBookWithCategory&category_id=${category.id }">${category.name }</a>
					</li>
				
				</c:forEach>	
			</ul>
		 
		</div>
		
		<div id="bookandpage" style="float: left;margin-left: 150px">
			
			<div id="books">
				<c:forEach var="book" items="${page.list }">
					<div id="book">
					
						<div id="image" style="float: left;">
							<img src="${pageContext.request.contextPath }/images/${book.image }" width="83px" height="118px">
						</div>
						
						<div id="bookinfo" style="float: left;text-align: left">
							<ul>
								<li>${book.name }</li>
								<li>${book.author }</li>
								<li>${book.price }</li>
								<li>
									<a href="${pageContext.request.contextPath }/client/BuyServlet?bookid=${book.id }">购买</a>
								</li>							
							</ul>							
						</div>
					
					  <div style="clear: both;"></div>
					</div>
				
				</c:forEach>
			</div>
		</div>
		
		<div style="clear: both;"></div>
		
		<div id="page">
			当前第[${page.pagenum }]页 &nbsp;&nbsp;
			
			<c:forEach var="pagenum" begin="${page.startPage }" end="${page.endPage }">
				[<a href="${pageContext.request.contextPath }/client/IndexServlet?method=${param.method }&pagenum=${pagenum }&category_id=${param.category_id }">${pagenum }</a>]
			
			</c:forEach>
			 &nbsp;共[${page.totalpage }]页 有[${page.totalrecord }]本书		
		</div>


	
	</div>


  </body>
</html>