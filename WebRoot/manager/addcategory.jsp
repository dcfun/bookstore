<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    <title>添加分类</title>
  </head>
  
  <body>
  	
    <form action="${pageContext.request.contextPath }/manager/CategoryServlet?method=add" method="post">
    
	    <table frame="border" width="50%">
	    	分类名称：<input type="text" name="name"><br/>
	    	分类描述：<textarea rows="5" cols="40" name="description"></textarea><br/><br/>
	    	<input type="submit" value="添加">
	    </table>
    </form>
  </body>
</html>
