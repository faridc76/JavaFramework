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
    <!--
        Simple bonus 
     -->
    <h1>Bonus calcucation (simple input)</h1>
    <form method="post" action="${pageContext.request.contextPath}/simple-bonus">
      <label for="ssn">SSN</label>
      <label for="multiplier">Multiplier</label>
      <br>
      <input id="ssn" name="ssn" placeholder="15" type="text">
      <input id="multiplier" name="multiplier" placeholder="0" type="number">
      <br>
      <button type="submit">Submit</button>
      <button type="reset">Reset</button>
    </form>
    <hr>
    <!--
        Multiple bonus
     -->
    <h1>Bonus calcucation (multiple inputs)</h1>
    <form method="post" action="${pageContext.request.contextPath}/multiple-bonus">
      <label for="ssn">SSN</label>
      <label for="multiplier">Multiplier</label>
      <br>
      <c:forEach var="i" begin="1" end="5">   
        <input id="ssn" name="ssn" value="${i}" type="text">
        <input id="multiplier" name="multiplier" value="${i}" type="number">
        <br>
      </c:forEach>
      <button type="submit">Submit</button>
      <button type="reset">Reset</button>
    </form>
    <hr>
    <form method="post" action="${pageContext.request.contextPath}/get-bonuses">
      <button type="submit">Submit</button>
    </form>
  </body>
</html>