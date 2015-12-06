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
<title>La même famille</title>
</head>
<body>
<div>

<h1>Liste des clients de la famille</h1>

<logic:iterate name="memeFamille" id="pers" >
<bean:write name="pers" property="id"/> - 
<bean:write name="pers" property="nom"/>
<bean:write name="pers" property="prenom"/>
<bean:write name="pers" property="age"/>
<br/>	
</logic:iterate>
</div>
<%--autre exemple d'affichage de l'attribut liste --%>
${memeFamille}
</body>
</html>