<%
	response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
	response.setHeader("Location","admin/getIndexPage");
%>