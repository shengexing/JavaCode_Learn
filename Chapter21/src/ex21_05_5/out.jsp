<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>out对象示例</title>
</head>

<%@page buffer="1kb" %>

<body>

	<%
		for(int i=0; i<2000; i++)
			out.println(i+"{"+out.getRemaining()+"}");
	%><br>
	
	缓存大小：<%=out.getBufferSize() %><br>
	剩余缓存大小：<%=out.getRemaining()%><br>
	自动刷新：<%=out.isAutoFlush() %><br>
	
	<%--out.clearBuffer(); --%>
	<%--out.clear(); --%>
	
	<!-- 默认情况下：服务器要输出到客户端的内容，不直接写到客户端，而是先写到一个输出缓存区中，
	只有在下面三种情况下，才会把该缓存区的内容输出到客户端上。
	1. 该JSP网页已完成信息的输出
	2. 输出缓冲区已满
	3. JSP中调用了out.flush()或response.flushbuffer()
	 -->

</body>
</html>