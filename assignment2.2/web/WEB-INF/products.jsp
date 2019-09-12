<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="chooseLanguage.jsp" />
<br>
<fmt:bundle basename="no.hvl.dat152.Resources.apptext">
    <a href="${pageContext.request.contextPath}/"><fmt:message key="home"/></a>
</fmt:bundle>
</body>
</html>
