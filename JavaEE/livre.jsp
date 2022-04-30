<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Connexion</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/BibliothecaireServlet" method="post">

<input name="TypeDoc" type="hidden" value="3">

  Nom du document: <input type="text" name="Nom">
  <br> <br>
  
  <br> 
    Auteur: <input type="text" name="Auteur"><br>
  
  <br>
  <input type="submit" value="Enregistrer">

</body>
</html>