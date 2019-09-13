<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="chooseLanguage.jsp" />
<br>
<fmt:bundle basename="no.hvl.dat152.Resources.apptext">
    <c:forEach items="${products}" var="p">
        <p><fmt:message key="name"/>: ${p.name}</p>
        <p><fmt:message key="price"/>: <fmt:formatNumber value="${multiplier * p.price}" type="currency" currencySymbol="${currency}"/></p>
        <p><fmt:message key="description"/>: <fmt:message key="${p.description}" /></p>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/"><fmt:message key="home"/></a>
</fmt:bundle>
</body>
</html>
