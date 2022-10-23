<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="nombredominio.modelsDAO.peliculaDAO"%>
<%@ page import="nombredominio.models.pelicula"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PELICULAS | EDIT</title>
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
	<h1>PELICULAS EDIT</h1>
	<%
	peliculaDAO peliculaDAO = new peliculaDAO();
	int id = Integer.parseInt(request.getParameter("id"));
	//*int id = Integer.parseInt(request.getAttribute("peli").toString());
	pelicula pelicula = new pelicula();
	pelicula = peliculaDAO.find(id);
	%>
	<form method="POST" action="PeliculaController?action=update">

		<input type="hidden" name="id" value="<%=pelicula.getId()%>">
		<p>Nombre:</p>
		<input type="text" name="nombre" value="<%=pelicula.getNombre()%>">
		<br>
		<p>Director:</p>
		<input type="text" name="director"
			value="<%=pelicula.getDirector()%>"> <br>
		<p>Genero:</p>
		<input type="text" name="genero" value="<%=pelicula.getGenero()%>">
		<br>

		<button type="submit">Actualizar</button>
	</form>
	<footer>
		<address>Copyrigth &copy; Peliculas.com</address>
	</footer>
</body>
</html>