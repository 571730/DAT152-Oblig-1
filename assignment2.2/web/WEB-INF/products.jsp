<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/language?lan=en">English</a>
<a href="${pageContext.request.contextPath}/language?lan=no">Norsk</a>
<a href="${pageContext.request.contextPath}/language?lan=fr">François</a>
<c:forEach items="${products}" var="p">
    <h1>${p.name}</h1>
    <p>${p.price}</p>
    <p>${p.description}</p>
</c:forEach>
<a href="${pageContext.request.contextPath}/">${home}</a>
</body>
</html>
