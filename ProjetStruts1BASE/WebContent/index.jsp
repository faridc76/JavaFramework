<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.struts.action.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>
	<bean:message key="message.title" />
</title>
</head>
<body>
<h1> <bean:message key="message.add" /> </h1>
<html:form action="AjouterPersonne" method="post">
<table style="margin:100px 0px 0px 200px">

<tr>
<td><bean:message key="message.name" /> </td>
<td><html:text property="nom" /> <b style="color:red"><html:errors property="erreur.nom"/></b></td>
</tr>

<tr>
<td><bean:message key="message.firstname" /> </td>
<td><html:text property="prenom" /> <b style="color:red"><html:errors property="erreur.prenom"/></b></td>
</tr>

<tr>
<td><bean:message key="message.age" /> </td>
<td><html:text property="age" /> <b style="color:red"><html:errors property="erreur.age"/></b></td>
</tr>

<tr>
<td></td>
<td>
<html:submit value="->" />
</td>
</tr>

</table>
</html:form>
</body>
</html>