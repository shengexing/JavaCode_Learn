<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取客户端的IP地址</title>
</head>
<body>

	<%
		// 获取HTTP头的x-forwarded-for信息
		String realIP = request.getHeader("x-forwarded-for");
		if(realIP != null && realIP.length() != 0) {
			// 如果有x-forwarded-for信息，而且等于unknown，则继续读取下一个信息
			while((realIP != null) && (realIP.equals("unknown"))) {
				realIP = request.getHeader("x-forwarded-for");
			}
		}
		if(realIP == null || realIP.length() == 0) {
			realIP = request.getHeader("Proxy-Client-IP");
		}
		if(realIP == null || realIP.length() == 0) {
			realIP = request.getHeader("WL-Proxy-Client-IP");
		}
		if(realIP == null || realIP.length() == 0) {
			realIP = request.getRemoteAddr();
		}
		out.print("你的IP地址是：" + realIP);
	%>
	<br>

</body>
</html>