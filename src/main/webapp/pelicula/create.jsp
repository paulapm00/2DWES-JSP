<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="nombredominio.modelsDAO.peliculaDAO"%>
<%@ page import="nombredominio.models.pelicula"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PELCULAS | CREATE</title>
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
	<h1>PELICULAS CREATE</h1>
	<div class="form">
		<form method="POST" action="PeliculaController?action=create">

			<input type="hidden" name="id">
			<p>Nombre:</p>
			<input type="text" name="nombre"> <br>
			<p>Director:</p>
			<input type="text" name="director"> <br>
			<p>Genero:</p>
			<input type="text" name="genero">

			<button type="submit">Enviar</button>
		</form>
	</div>
	<footer>
		<address>Copyrigth &copy; Peliculas.com</address>
	</footer>
</body>
</html>