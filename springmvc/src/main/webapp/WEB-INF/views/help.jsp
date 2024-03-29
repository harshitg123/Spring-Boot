<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="java.time.LocalDateTime"%>

<html>
<head>
    <title>Help page</title>
</head>
<body>

<%
    String name = (String) request.getAttribute("name");
    LocalDateTime time = (LocalDateTime) request.getAttribute("time");
%>

<h1>My name is <%= name %></h1>

<%-- toString is not needed, expression tag will automatically parse it --%>
<h1>Current Time is <%= time.toString()  %></h1>

</body>
</html>


