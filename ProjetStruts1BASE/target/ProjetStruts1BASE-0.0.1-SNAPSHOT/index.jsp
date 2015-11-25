<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Ajout</title>
</head>
<body>

<h1>Ajouter une personne :</h1>
<html:form action="AjouterPersonne" method="post">
<table style="margin:100px 0px 0px 200px">
<tr>
<td>Nom : </td>
<td><html:text property="nom" /> <b style="color:red"><html:errors property="erreur.nom"/></b></td>
</tr>
<tr>
<td>Prénom : </td>
<td><html:text property="prenom" /> <b style="color:red"><html:errors property="erreur.prenom"/></b></td>
</tr>
<tr>
<td></td>
<td>
<html:submit value="envoyer" />
</td>
</tr>
</table>
</html:form>
</body>
</html>