<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="author" content="Mincong HUANG">
    <title>Bonus calcucation</title>
  </head>
  <body>
    <p>Bonus Result</p>
    <c:forEach var="bonus" items="${bonuses}">
      <p>SSN : <c:out value="${bonus.ssn}" default="NULL" /></p>
      <p>Multiplier : <c:out value="${bonus.multiplier}" default="NULL" /></p>
      <p>Bonus : <c:out value="${bonus.bonus}" default="NULL" /></p>
      <hr>
    </c:forEach>
  </body>
</html>