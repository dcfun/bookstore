<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
  <head>
    <title> 显示订单 </title>
  </head>
  <body style="text-align: center;">
	<h2>订单信息</h2>
	<br/>

	<table width="80%" frame="border" align="center" border="1">
		<tr>
			<td>订单号</td>
			<td>订单人</td>
			<td>下单时间</td>
			<td>订单总价</td>
			<td>订单状态</td>
			<td>操作</td>
		</tr>

		<c:forEach var="order" items="${orders}">
			<tr>
				<td>${order.id }</td>
				<td>${order.user.username }</td>
				<td>${order.ordertime }</td>
				<td>${order.price }</td>
				<td>${order.state==true?'已发货':'未发货'}</td>
				<td>
					<a href="${pageContext.request.contextPath }/manager/OrderDetailServlet?orderid=${order.id }">查看明细</a>
					<a href="#">删除</a>
				</td>
				
			</tr>
		</c:forEach>

	
	</table>
	
  </body>
</html>