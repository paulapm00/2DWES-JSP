<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="nombredominio.modelsDAO.documentalDAO"%>
<%@ page import="nombredominio.models.documental"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="../login-validation.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="daw"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Documental</title>
<link href="./resources/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div id="contenedorHeader">
		<header>
			<nav>
				<ul>
					<li><a href="UsuariosController?action=index">Usuarios</a></li>
					<li><a href="PeliculaController?action=index">Peliculas</a></li>
					<li><a href="SerieController?action=index">Serie</a></li>
					<li><a href="DocumentalController?action=index">Documentales</a></li>
					<li><a href="AuthController?action=logout" style="color:rgba(246, 39, 39, 0.432) ;">Cerrar sesion</a></li>
				</ul>
			</nav>
		</header>
	</div>
	<div>
		<table class="tabla">
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Director</th>
					<th>Genero</th>
					<th><a href="documentalController?action=create">Crear documental</a></th>
					<th></th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<daw:forEach var="documental" items="${docu}">
					<tr>
						<td>${documental.id}</td>
						<td>${documental.nombre}</td>
						<td>${documental.director}</td>
						<td>${documental.genero}</td>
						<td><a
							href="documentalController?action=edit&id=${documental.id}">Edit</a>
							<a href="documentalController?action=delete&id=${documental.id}">Delete</a>
						</td>
					</tr>
				</daw:forEach>
			</tbody>

		</table>
	</div>
	<footer><address>Copyrigth &copy; Peliculas.com </address></footer>
</body>
</html>