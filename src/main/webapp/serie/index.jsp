<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="nombredominio.modelsDAO.serieDAO"%>
<%@ page import="nombredominio.models.serie"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="../login-validation.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="daw"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Serie | index</title>
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
					<th><a href="serieController?action=create">Crear serie</a></th>
					<th></th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<daw:forEach var="serie" items="${seri}">
					<tr>
						<td>${serie.id}</td>
						<td>${serie.nombre}</td>
						<td>${serie.director}</td>
						<td>${serie.genero}</td>
						<td><a href="serieController?action=edit&id=${serie.id}">Edit</a>
							<a href="serieController?action=delete&id=${serie.id}">Delete</a>
						</td>
					</tr>
				</daw:forEach>
			</tbody>
		</table>
	</div>

	<!--  
			        	el atributo items recoge el elemnto que trae mi controller. Seria equivalente al request.getAttribute()
			        	el atributo var seria la variable local para cada iteracion del forEach
			        -->
	<daw:forEach var="serie" items="${seri}">
		<daw:if test="${serie.id == 1}">
		</daw:if>
	</daw:forEach>

	<!-- 
	                    la etiqueta out recoge un valor o variable que esté situado dentro de mi .jsp
	                    El atributo value contiene el nombre de esa variable que en este caso me manda el controlador
                     -->
	<p>
		<daw:out value="${clase}"></daw:out>
	</p>

	<daw:forEach var="serie" items="${seri}">
	</daw:forEach>
	<footer><address>Copyrigth &copy; Peliculas.com </address></footer>
</body>
</html>