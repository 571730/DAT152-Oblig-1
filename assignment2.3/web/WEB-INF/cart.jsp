<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dat152" tagdir="/WEB-INF/tags"%>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="chooseLanguage.jsp"/>

<fmt:bundle basename="no.hvl.dat152.Resources.apptext">
    <h1><fmt:message key="cart"/></h1>
    <c:choose>
        <c:when test="${emptyCart}">
            <h3><fmt:message key="emptyCart"/></h3>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                <th><fmt:message key="name"/></th>
                <th><fmt:message key="shortDescription"/></th>
                <th><fmt:message key="price"/></th>
                <th><fmt:message key="quantity"/></th>
                <th><fmt:message key="total"/></th>
                </tr>
                <c:forEach items="${cart.cart}" var="cartItem">
                    <tr>
                        <td>${cartItem.name}</td>
                        <td>
                            <dat152:shortDescription>
                                <fmt:message key="${cartItem.description}"/>
                            </dat152:shortDescription>
                        </td>
                        <td><fmt:formatNumber value="${cartItem.price * multiplier}" type="currency" currencySymbol="${currency}"/></td>
                        <td>${cartItem.quantity}</td>
                        <td><fmt:formatNumber value="${cartItem.totalPrice * multiplier}" type="currency" currencySymbol="${currency}"/></td>
                    </tr>
                </c:forEach>
                <tr class="bold">
                    <td colspan="4" class="right"><fmt:message key="totalAmount"/></td>
                    <td><fmt:formatNumber value="${cart.totalCostCart * multiplier}" type="currency" currencySymbol="${currency}"/></td>
                </tr>
            </table>
        </c:otherwise>
    </c:choose>
    <br>
    <br>
    <a href="${pageContext.request.contextPath}/"><fmt:message key="home"/></a>
    <a href="${pageContext.request.contextPath}/products"><fmt:message key="products"/></a>
</fmt:bundle>
<dat152:copyright/>
</body>
</html>
