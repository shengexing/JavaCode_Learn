<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>inputMsg.jsp</title>
</head>

<body>
	<form action="/cp21_06_1/pages/chatroom/method.jsp?action=sendMsg" method="post" name="form1">
		<%=session.getAttribute("username") %>:
		<input name="msg" type="text" id="msg" size="60">
		<input type="submit" name="Submit" value="发言">
	</form>
</body>
</html>