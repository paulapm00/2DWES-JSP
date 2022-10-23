<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	spageEncoding="ISO-8859-1"%>
<%@ page import="nombredominio.modelsDAO.serieDAO"%>
<%@ page import="nombredominio.models.serie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SERIE | EDIT</title>
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
					<li><a href="AuthController?action=logout" style="color: rgba(246, 39, 39, 0.432);">Cerrar sesion</a></li>
				</ul>
			</nav>
		</header>
	</div>
	<h1>SERIE EDIT</h1>
	<%
	serieDAO serieDAO = new serieDAO();
	int id = Integer.parseInt(request.getAttribute("id_serie").toString());
	serie serie = new serie();
	serie = serieDAO.find(id);
	%>
	<form method="POST" action="seriesController?action=update">

		<input type="hidden" name="id" value="<%=serie.getId()%>">
		<p>Nombre:</p>
		<input type="text" name="nombre" value="<%=serie.getNombre()%>">
		<br>
		<p>Director:</p>
		<input type="text" name="email" value="<%=serie.getDirector()%>">
		<br>
		<p>Genero:</p>
		<input type="text" name="password" value="<%=serie.getGenero()%>">
		<br>

		<button type="submit">Actualizar</button>
	</form>
</body>
</html>