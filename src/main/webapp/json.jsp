<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <base href="<%=basePath%>">
        <meta charset="UTF-8">
        <title>json测试</title>
    </head>
    <body>
    <div style="width: 100%;height: 100%; min-width: 300px; min-height: 400px;background: beige;">
        <c:forEach items="${adminList}" var="item">
            <ul class="records-list">
                <li style="width:10.66666666666667%; color:#BD45C0">${item.name} </li>
        </c:forEach>
    </div>

    </body>
</html>