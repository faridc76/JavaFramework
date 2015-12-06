<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page import="fr.esigelec.projetStruts.dto.*,java.util.*,org.apache.commons.lang.*" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Liste</title>
</head>
<body>
<h1>Liste des clients SANS taglibs de struts :</h1>
<div>
<%
List<Personne> l=(List<Personne>)request.getAttribute("liste");
for(Personne p:l){ %>
<%=p.getId()%> - <%=StringEscapeUtils.escapeHtml(p.toString()) %>
<a href="SupprimerPersonne.do?id=<%=p.getId() %>" title="supprimer">X</a><br/>

<%} %>
<a href="RetourIndex.do">Ajouter une nouvelle personne</a>
</div>
<div>

<h1>Liste des clients AVEC taglibs de struts :</h1>

<logic:iterate name="liste" id="pers" >
<bean:write name="pers" property="id"/> - 
<html:link action="VoirFamille" title="VoirFamille" paramId="nom" paramName="pers" paramProperty="nom"><bean:write name="pers" property="nom"/></html:link>
<bean:write name="pers" property="prenom"/>
<html:link action="SupprimerPersonne" title="supprimer"  paramId="id" paramName="pers" paramProperty="id">X</html:link>
<br/>

</logic:iterate>
<html:link action="RetourIndex">Ajouter une nouvelle personne</html:link>
</div>
<%--autre exemple d'affichage de l'attribut liste --%>
${liste}
</body>
</html>