<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title> 订单明细 </title>
  </head>
  <body>
  
    <br/>
  	<h3>订单明细</h3>
  	<table border="1">
  		<tr>
  			<td>书名</td>
  			<td>售价</td>
  			<td>数量</td>
  			<td>应收货款</td>
  		</tr>
    	
    	<c:forEach var="orderitem" items="${order.orderitems}">
    		<tr>
	    		<td>${orderitem.book.name }</td>
	    		<td>${orderitem.book.price }</td>
	    		<td>${orderitem.quantity }</td>
	    		<td>${orderitem.price }</td>
    		</tr>
    	</c:forEach>
  	
  		<tr>
  			<td>订单总价</td>
  			<td colspan="3">${order.price }元</td>
  		</tr>
  	
  	</table>
  	
  	<br/>
  	<h3>收货人信息</h3>
  	<table border="1">
  		<tr>
  			<td>用户名</td>
  			<td>电话</td>
  			<td>地址</td>
  			<td>邮箱</td>
  		</tr>
  		
  		<tr>
  			<td>${order.user.username }</td>
  			<td>${order.user.phone }</td>
  			<td>${order.user.address }</td>
  			<td>${order.user.email }</td>
  		</tr>
  		
  	</table>
  	
  	<br/>
	<a href="${pageContext.request.contextPath }/manager/ConfirmOrderServlet?orderid=${order.id }">确认发货</a>


  </body>
</html>