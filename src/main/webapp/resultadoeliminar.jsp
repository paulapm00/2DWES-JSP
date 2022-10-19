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
<h1>Usuario eliminado correctamente</h1>
	<%!
			usuarioDAO usuarioDAO = new usuarioDAO();
		%>
		
		<%= usuarioDAO.eliminar(
				Integer.parseInt(request.getParameter("id"))
				) %>
</body>
</html>