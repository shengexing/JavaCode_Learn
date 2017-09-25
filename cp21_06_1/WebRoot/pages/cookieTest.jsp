<%@ page language="java" import="java.util.Date" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用Cookie记录用户访问本网页的次数</title>
</head>
<body>

	<%
		Cookie temp = null;
		
		// 取得Cookie资料
		Cookie[] cookies = request.getCookies();
		int cookielen = request.getCookies().length;
		int count = 0;
		String date = "";
		if(cookielen != 0) {
			// 遍历取得cookies数组中的Cookie变量
			for(int i = 0; i < cookielen; i++) {
				temp = cookies[i];
				
				// 找到本网页设置的cookie项
				if(temp.getName().equals("accessCount")) {
					// 得到此前的访问数
					count = Integer.parseInt(temp.getValue());
				} else if(temp.getName().equals("accessDate")) {
					date = temp.getValue();
				}
				
				// 找到这两个值便退出遍历
				if((count != 0) && !date.equals(""))
					break;
			}
		}
		
		// 显示用户的登录次数
		if(count == 0) {
			out.println("首度光临的新朋友，欢迎您访问我的网页！");
		} else {
			out.println("这是您第 <font color=red>" + (count + 1)
					+ "</font> 次访问我的网页！<BR/><BR/>");
			out.println("您上次访问的时间是 <font color=red>" + date
					+ "</font>");
		}
		
		// 如果访问次数小于500，则更新cookie
		if(count < 500) {
			Cookie accessCountCookie = new Cookie("accessCount", String.valueOf(count + 1));
			
			// 将Cookie的有效时间设定为1周
			int validateTime = 7 * 24 * 60 * 60;
			
			accessCountCookie.setMaxAge(validateTime);
			
			// 设置Cookie的访问路径，当用户访问本服务器的/cp21_06_1路径时，该Cookie会添加在request中
			accessCountCookie.setPath("/cp21_06_1");
			
			// 将更新后的数据存入cookie变量，存在客户端
			response.addCookie(accessCountCookie);
			
			// 更新访问时间cookie
			Cookie accessDateCookie = new Cookie("accessDate", new Date().toString());
			accessDateCookie.setMaxAge(validateTime);
			accessDateCookie.setPath("/cp21_06_1");
			response.addCookie(accessDateCookie);
		} else {
			// 当访问数大于500时，将cookie删除
			Cookie killMyCookie = new Cookie("accessCount", null);
			killMyCookie.setMaxAge(0);
			killMyCookie.setPath("/cp21_06_1");
			response.addCookie(killMyCookie);
			killMyCookie = new Cookie("accessDate", null);
			killMyCookie.setMaxAge(0);
			killMyCookie.setPath("/cp21_06_1");
			response.addCookie(killMyCookie);
		}
	%>
	<BR>

</body>
</html>