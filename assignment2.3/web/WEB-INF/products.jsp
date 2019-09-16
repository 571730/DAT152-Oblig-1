<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dat152" tagdir="/WEB-INF/tags"%>
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
        <div class="container">
            <div class="item">
                <img src="${pageContext.request.contextPath}/res/${p.name}.png" alt="">
            </div>
            <div class="item">
                <p><fmt:message key="name"/>: ${p.name}</p>
                <p><fmt:message key="price"/>: <fmt:formatNumber value="${multiplier * p.price}" type="currency" currencySymbol="${currency}"/></p>
                <p><fmt:message key="description"/>: <fmt:message key="${p.description}" /></p>
                <a href="${pageContext.request.contextPath}/add?product=${p.name}"><button><fmt:message key="addToCart" /></button></a>
            </div>
        </div>
    </c:forEach>
    <br>
    <br>
    <a href="${pageContext.request.contextPath}/"><fmt:message key="home"/></a>
    <a href="${pageContext.request.contextPath}/cart"><fmt:message key="cart"/></a>
    <c:if test="${itemAdded != null}">
        <br>
        <br>
        <h3>${itemAdded}<fmt:message key="addedToCart"/></h3>
        <br>
        <br>
    </c:if>
</fmt:bundle>
<dat152:copyright/>
</body>
</html>
