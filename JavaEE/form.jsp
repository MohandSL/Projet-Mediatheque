<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Connexion</title>
</head>
<body>

<h1>Connexion</h1>
 <form action="<%= request.getContextPath() %>/ConnexionServlet" method="post">
  
  Identifiant: <input type="text" name="identifiant">
  <br> <br> 
  
  Password: <input type="password" name="password"><br>
  
  <br> 
  <input type="submit" value="register">
 </form>
</body>
</html>