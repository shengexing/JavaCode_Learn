<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application对象示例</title>
</head>
<body>
<br>
	JSP(SERVLET)引擎名及版本号：<%=application.getServerInfo() %><br><br>
	返回/application.jsp虚拟路径的真实路径：
	<%=application.getRealPath("/application.jsp") %><br><br>
	服务器支持的Servlet API的大版本号：<%=application.getMajorVersion() %><br><br>
	服务器支持的Servlet API的小版本号：<%=application.getMinorVersion() %><br><br>
	指定资源（文件及目录）的URL路径：<%=application.getResource("/application.jsp") %><br><br>
	
	<!-- 可以将application.jsp换成一个目录 --><br><br>
	<%
		application.setAttribute("name", "java编程");
		out.println(application.getAttribute("name"));
		application.removeAttribute("name");
		out.println(application.getAttribute("name"));
	%>

</body>
</html>