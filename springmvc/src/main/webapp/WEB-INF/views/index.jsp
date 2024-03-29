<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>

<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>My name is</h1>

<%
   String name = (String) request.getAttribute("name");
   Integer id = (Integer) request.getAttribute("Id");
   List<String> friends = (List<String>) request.getAttribute("friends");
%>

<p>name is <%= name %></p>
<p> Id is <%= id %> </p>

<%
    for(String s: friends){
%>

    <p> <%= s %></p>

<%
    }
%>

</body>
</html>