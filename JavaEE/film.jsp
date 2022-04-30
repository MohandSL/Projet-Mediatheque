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

<input name="TypeDoc" type="hidden" value="2">

  Nom du document: <input type="text" name="Nom">
  <br> <br> 
  
  Duree: <input type="text" name="Duree"><br>
  
  <br> 
    Realisateur: <input type="text" name="Realisateur"><br>
  
  <br>
  <input type="submit" value="Enregistrer">

</body>
</html>