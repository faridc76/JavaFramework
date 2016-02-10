<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
    <form method="post" action="login">
      <input name="username" value="mincong" placeholder="your username here">
      <button type="submit" value="sumbit">OK</button>
    </form>
    <P>The time on the server is ${serverTime}. </P>
  </body>
</html>