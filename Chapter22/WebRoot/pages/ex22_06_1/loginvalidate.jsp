<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>验证码登录</title>
</head>

<body>
	<form name="form1" method="post" action=""></form>
	<table width="350" height="100" border="1" align="center"
		cellpadding="0" cellspacing="0" bgcolor="#66FF88">
		<tr>
			<td align="center">登录</td>
		</tr>
		<tr>
			<td align="left">
				您的昵称：
				<input name="usernaame" type="text">
			</td>
		</tr>
		<tr>
			<td align="left">
				验证码：
				<input name="randcode" type="text">
				<IMG src="../../servlet/getImageCode" height="25" width="60" id="randomImage">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" name="Submit" value="进入">
			</td>
		</tr>
	</table>
</body>

</html>