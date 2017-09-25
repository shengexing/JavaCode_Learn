<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageContext对象示例</title>
</head>
<body>
<br>

	<%
		request.setAttribute("name", "Java编程");
		session.setAttribute("name", "Java计算机编程");
		// session.putValue("name", "计算机编程");
		application.setAttribute("name", "编程");
	%>
	
	request设定的值：<%=pageContext.getRequest().getAttribute("name") %><br>
	session设定的值：<%=pageContext.getSession().getAttribute("name") %><br>
	application设定的值：<%=pageContext.getServletContext().getAttribute("name") %><br>
	范围1内的值：<%=pageContext.getAttribute("name", 1) %><br>
	范围2内的值：<%=pageContext.getAttribute("name", 2) %><br>
	范围3内的值：<%=pageContext.getAttribute("name", 20) %><br>
	范围4内的值：<%=pageContext.getAttribute("name", 4) %><br>
	
	<!-- 从最小的范围page开始，然后是reques、session及application -->
	<%pageContext.removeAttribute("name", 20); %>
	pageContext修改后的session设定的值：<%=session.getValue("name") %><br>
	<%pageContext.setAttribute("name", "应用技术编程", 4); %>
	pageContext修改后的application设定的值：
	<%=pageContext.getServletContext().getAttribute("name") %><br>
	值的查找：<%=pageContext.findAttribute("name") %><br>
	属性name的范围：<%=pageContext.getAttributesScope("name") %><br>

</body>
</html>