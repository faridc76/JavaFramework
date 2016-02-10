<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <head>
    <title>Login</title>
  </head>
  <body>
    <form:form method="post" action="login" modelAttribute="user">
      <form:label path="name">Name:</form:label>
      <form:input path="name"/>
      <input type="submit" value="Register" class="register"/>
    </form:form>
    <P>The time on the server is ${serverTime}. </P>
  </body>
</html>