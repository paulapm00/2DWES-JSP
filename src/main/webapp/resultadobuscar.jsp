<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@page import="nombredominio.modelsDAO.usuarioDAO" %>
<%@page import="nombredominio.models.usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
			usuarioDAO usuarioDAO = new usuarioDAO();
		%>
		
		<%= usuarioDAO.find(
				Integer.parseInt(request.getParameter("id"))
				).getEmail() %>
</body>
</html>