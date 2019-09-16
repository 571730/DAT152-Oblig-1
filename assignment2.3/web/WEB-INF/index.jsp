<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="dat152" tagdir="/WEB-INF/tags"%>
<html>
  <head>
    <title>Kaffekopper AS</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
  </head>
  <body>
  <jsp:include page="chooseLanguage.jsp" />
  <br>
  <fmt:bundle basename="no.hvl.dat152.Resources.apptext">
    <img src="${pageContext.request.contextPath}/res/kaffe.png" alt="Kaffe Logo" class="logo">
    <p><fmt:message key="frontPageInfo" /> <span><a href="${pageContext.request.contextPath}/products"><fmt:message key="products"/></a></span></p>
  </fmt:bundle>
  <dat152:copyright/>
  </body>
</html>
