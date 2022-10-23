<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="nombredominio.modelsDAO.documentalDAO"%>
<%@ page import="nombredominio.models.documental"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOCUMENTALES | EDIT</title>
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
					<li><a href="AuthController?action=logout">Cerrar sesion</a></li>
				</ul>
			</nav>
		</header>
	</div>
	<h1>DOCUMENTALES EDIT</h1>
	<%
	documentalDAO documentalDAO = new documentalDAO();
	int id = Integer.parseInt(request.getParameter("id"));
	//int id = Integer.parseInt(request.getAttribute("docu").toString());
	documental documental = new documental();
	documental = documentalDAO.find(id);
	%>
	<form method="POST" action="documentalController?action=update">

		<input type="hidden" name="id" value="<%=documental.getId()%>">
		<p>Nombre:</p>
		<input type="text" name="nombre" value="<%=documental.getNombre()%>">
		<br>
		<p>Director:</p>
		<input type="text" name="director"
			value="<%=documental.getDirector()%>"> <br>
		<p>Genero:</p>
		<input type="text" name="genero" value="<%=documental.getGenero()%>">
		<br>

		<button type="submit">Actualizar</button>
	</form>
	<footer><address>Copyrigth &copy; Peliculas.com </address></footer>
</body>
</html>