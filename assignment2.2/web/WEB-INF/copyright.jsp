<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="no.hvl.dat152.util.Utils"%>
<html>
<head>
    <title>Copyright</title>
</head>
<body>
<br>
<br>
<% pageContext.setAttribute("date", Utils.getDate()); %>
<p class="italic">${date} HVL</p>
</body>
</html>
