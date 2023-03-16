<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String nome = null;
	String cognome = null;
	if(session.getAttribute("nome")==null && session.getAttribute("cognome")==null )
		response.sendRedirect("login.jsp");
	else{
		
		nome = (String)session.getAttribute("nome");
		cognome = (String)session.getAttribute("cognome");
	}	
%>

	<h1>ciao ${nome} ${cognome}</h1>
	 <a href="${pageContext.request.contextPath}/logout">Logout</a>
	
</body>
</html>