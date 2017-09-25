<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request对象示例</title>
</head>

<body bgcolor="#FFFFF0">
	<form action="" method="post">
		<input type="text" name="qwe">
		<input type="submit" value="提交">
	</form>
	
	请求方式：<%=request.getMethod() %><br>
	请求的资源：<%=request.getRequestURI() %><br>
	请求用的协议：<%=request.getProtocol() %><br>
	请求的文件名：<%=request.getServletPath() %><br>
	请求的服务器的IP：<%=request.getServerName() %><br>
	请求服务器的端口：<%=request.getServerPort() %><br>
	客户端IP地址：<%=request.getRemoteAddr() %><br>
	客户端主机名：<%=request.getRemoteHost() %><br>
	表单提交来的值：<%=request.getParameter("qwe") %><br>
</body>
</html>
<%@ page import="java.util.Enumeration" %>