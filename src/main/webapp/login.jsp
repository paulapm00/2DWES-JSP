<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<form method="POST" action="AuthController?action=login">
		<p>Email:</p>
		<input type="email" name="email"> <br>
		<p>Password:</p>
		<input type="text" name="password"> <br>
		<button type="submit">Enviar</button>
	</form>
	<footer>
		<address>Copyrigth &copy; Peliculas.com</address>
	</footer>
</body>
</html>