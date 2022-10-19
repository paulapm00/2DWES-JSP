<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="nombredominio.modelsDAO.usuarioDAO" %>
<%@ page import="nombredominio.models.usuario" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>USUARIOS | EDIT </title>
	</head>
	<body>
		<h1>USUARIOS EDIT</h1>
		<%
		usuarioDAO usuarioDAO = new usuarioDAO();
		int id = Integer.parseInt(request.getAttribute("id_usuario").toString());
		usuario usuario = new usuario();
		usuario = usuarioDAO.find(id);
		%>
		 <form method="POST" action="UsuariosController?action=update">
        	
        	<input type="hidden" name="id" value="<%= usuario.getId() %>">
        	<p>Nombre:</p>
        	<input type="text" name="nombre" value="<%= usuario.getNombre() %>">
        	<br>
        	<p>Email:</p>
        	<input type="email" name="email" value="<%= usuario.getEmail() %>">
        	<br>
        	<p>Password:</p>
        	<input type="email" name="password" value="<%= usuario.getPassword() %>">
        	<br>
        	
        	<button type="submit">Actualizar</button>
        </form>
	</body>
</html>