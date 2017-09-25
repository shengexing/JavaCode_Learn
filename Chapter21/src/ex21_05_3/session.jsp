<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session对象示例</title>
</head>
<body>
<br>
	session的创建时间：<%=session.getCreationTime() %>&nbsp; &nbsp; <%=new Date(session.getCreationTime()) %><br><br>
	session的ID号：<%=session.getId() %><br><br>
	客户端最近一次请求时间：<%=session.getLastAccessedTime() %>&nbsp; &nbsp; <%=new java.sql.Time(session.getLastAccessedTime()) %><br><br>
	两次请求间隔多长时间此session被取消（ms）：<%=session.getMaxInactiveInterval() %><br><br>
	是否是新创建的一个session：<%=session.isNew()?"是":"否" %><br><br>
	
	<%
		session.putValue("name", "编程");
		session.putValue("number", "1472069");
	%>
	
	<%
		for(int i=0; i<session.getValueNames().length; i++)
			out.println(session.getValueNames()[i]+"="+session.getValue(session.getValueNames()[i]));
	%>
	<!-- 返回的是从格林威治时间(GMT)1970年01月01日0:00:00 起到计算当时的毫秒数 -->

</body>
</html>