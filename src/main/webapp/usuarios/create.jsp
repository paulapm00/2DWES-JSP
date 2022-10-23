<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="nombredominio.modelsDAO.usuarioDAO"%>
<%@ page import="nombredominio.models.usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USUARIOS | CREATE</title>
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
	<h1>USUARIOS CREATE</h1>
	<div class="form">
		<form method="POST" action="UsuariosController?action=create">

			<input type="hidden" name="id">
			<p>Nombre:</p>
			<input type="text" name="nombre"> <br>
			<p>Email:</p>
			<input type="email" name="email"> <br>
			<p>Password:</p>
			<input type="text" name="password">

			<button type="submit">Enviar</button>
		</form>
	</div>
	<footer><address>Copyrigth &copy; Peliculas.com </address></footer>
</body>
</html>