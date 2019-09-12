<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
  <head>
    <title>Kaffekopper AS</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/language?lan=en">English</a>
  <a href="${pageContext.request.contextPath}/language?lan=no">Norsk</a>
  <a href="${pageContext.request.contextPath}/language?lan=fr">François</a>
  <h1>Kaffekopper AS</h1>
  <img src="${pageContext.request.contextPath}/res/kaffe.png" alt="Kaffe Logo" class="logo">
  <p>${haveLook} <span><a href="#">${products}</a></span></p>
  <p class="italic">&copy; ${date} HVL</p>
  </body>
</html>
