<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Client</title>
</head>
<body>


<%@page import="java.util.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="mediatek2022.*" %>



<h1>Emprunter un document</h1>

<%



 mediatek2022.Mediatheque m = Mediatheque.getInstance();
mediatek2022.Utilisateur u  =  null;

Object obj = session.getAttribute("utilisateur");


if( obj!=null){
	u = (Utilisateur) obj;
}

Integer size = m.tousLesDocumentsDisponibles().size();


for(int i = 0; i < size; i++) {
	if(m.getDocument(i).disponible()==true){
	out.println(m.getDocument(i));
	String num = Integer.toString(i);
%>
	<form action="<%= request.getContextPath() %>/ClientServlet" method="post">
		 
	<input name="doc" type="hidden" value=<%=num%>>
	<input name="fonct" type="hidden" value="emprunt">
  	<input type="submit" value="emprunt">
	</form>
	</br>
<% } }%>

<h1>rendre un document</h1>

<%
for(int j = 0; j < size; j++) {
	if(m.getDocument(j).disponible()==false){
	out.println(m.getDocument(j));
	String nb = Integer.toString(j);
%>
	<form action="<%= request.getContextPath() %>/ClientServlet" method="post">
		 
	<input name="doc" type="hidden" value=<%=nb%>>
	<input name="fonct" type="hidden" value="retour">

  	<input type="submit" value="retour">
	</form>
	</br>
<% } }%>

</body>
</html>