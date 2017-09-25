<%@ page language="java" import="ex22_06_2.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<%
		// 获得session，参数为false，表示如果session不存在，则不创建
		session = request.getSession(false);
		PageableResultSet pageResultSet = (PageableResultSet)session.getAttribute("pageResultSet");
		boolean hasResult = (pageResultSet == null) ? false : true;
		
		int pageIndex = 0;
		int pageCount = 0;
		if(hasResult) {
			pageIndex = Integer.parseInt((String)request.getParameter("pageIndex"));
			pageResultSet.gotoPage(pageIndex);
			pageCount = pageResultSet.getPageCount();
		}
	%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>数据库查看器</title>
	
	<script type="text/javascript">
		<%if(hasResult) { %>
			function firstpage() {
				fobj = document.pageForm;
				fobj.pageIndex.value = "1";
				fobj.submit();
			}
			
			function lastpage() {
				fobj = document.pageForm;
				fobj.pageIndex.value = "<%=pageCount%>";
				fobj.submit();
			}
			
			function prepage() {
				fobj = document.pageForm;
				fobj.pageIndex.value = "<%=(pageIndex - 1)%>";
				fobj.submit();
			}
			
			function nextpage() {
				fobj = document.pageForm;
				fobj.pageIndex.value = "<%=(pageIndex + 1)%>";
				fobj.submit();
			}
		<%}%>
	</script>
</head>
<body>
	<%@include file="header.jsp" %>
	<br>
	
	<FORM name="queryForm" method="post" action="/Chapter22/servlet/queryDB">
		请输入SQL语句：
		<input type="text" name="querySQL" size="50">
		<input type="hidden" name="servleturl" value="/pages/ex22_06_2/queryDB.jsp">
		<input type="hidden" name="errorurl" value="/pages/ex22_06_2/queryDB.jsp">
		<input type="hidden" name="pageIndex" value="1">
		<input type="hidden" name="pageSize" value="5">
		<input type="submit" name="Submit" value="查 询">
	</FORM>
	
	<%
		// 如果存在错误信息，则用error.jsp显示错误信息
		String errormsg = (String)request.getAttribute("errormsg");
		if(errormsg != null) {
	%>
	<jsp:include page="error.jsp"/>
	
	<%} %>
	
	<%if(hasResult) { %>
	
		<FORM name="pageForm" method="post" action="/Chapter22/pages/ex22_06_2/queryDB.jsp">
			<%
				int begin = (pageResultSet.getCurPage() - 1) * pageResultSet.getPageSize() + 1;
				int end = (pageResultSet.getCurPage() - 1) * pageResultSet.getPageSize() + pageResultSet.getPageRowsCount();
				
				out.println(new HtmlResultSet(pageResultSet).toString(begin, end));
			%>
			<br>
			<input type="hidden" name="pageIndex" value="">
		</FORM>
		
		<input type="button" name="firstpage" value="第一页" onclick="javascript:firstpage()" 
			<%if(pageIndex == 1) { %>
				disabled
			<%} %>
		/>
		<input type="button" name="prepage" value="上一页" onclick="javascript:prepage()"
			<%if(pageIndex <= 1) { %>
				disabled
			<%} %>
		/>
		<input type="button" name="nextpage" value="下一页" onclick="javascript:nextpage()"
			<%if(pageIndex >= pageCount) {
				out.print(" disabled");
			} %>
		/>
		<input type="button" name="lastpage" value="最后一页" onclick="javascript:lastpage()"
			<%if(pageIndex == pageCount) { %>
				disabled
			<%} %>
		/>
		
	<%} %>
	
</body>
</html>