<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="nombredominio.modelsDAO.serieDAO"%>
<%@ page import="nombredominio.models.serie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PELCULAS | CREATE</title>
<link href="./resources/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<h1>SERIE CREATE</h1>
	<form method="POST" action="SerieController?action=create">

		<input type="hidden" name="id">
		<p>Nombre:</p>
		<input type="text" name="nombre"> <br>
		<p>Director:</p>
		<input type="text" name="director"> <br>
		<p>Genero:</p>
		<input type="text" name="genero">

		<button type="submit">Enviar</button>
	</form>
</body>
</html>