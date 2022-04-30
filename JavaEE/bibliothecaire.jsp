<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Bibliothécaire</title>
</head>
<body>

<h1>Choix du Type de Document</h1>

<form action="film.jsp">
	<input type="submit" value="Film">
</form>
  
<br> <br> 

  <form action="musique.jsp">
	<input type="submit" value="Musique">
</form>

<br> <br> 

<form action="livre.jsp">
	<input type="submit" value="Livre">
</form>

 



<!--

<label for="TypeDoc">Type document:</label>

<select name="TypeDeDoc" id="Doc">
    <option value="1">Film</option>
    <option value="2" selected>Musique</option>
    <option value="3">CD</option>
</select>

<form action="<%= request.getContextPath() %>/BibliothécaireServlet" method="post">

  Identifiant du document: <input type="text" name="identifiantDocument">
  <br> <br> 
  
  Type du document: <input type="text" name="typeDocument"><br>
  
  <br> 
    Titre du document: <input type="text" name="nomDocument"><br>
  
  <br>
  
    Type du document: <input type="password" name="typeDocument"><br>
  
  <br>
  <input type="submit" value="Enregistrer">


 </form>
-->

</body>
</html>
