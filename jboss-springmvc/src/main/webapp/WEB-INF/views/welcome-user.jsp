<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <head>
    <title>Welcome</title>
  </head>
  <body>
    <P>Welcome, <c:out value="${name}" default="unknown"/>.</P>
  </body>
</html>