<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="nombredominio.modelsDAO.usuarioDAO"%>
<%@ page import="nombredominio.models.usuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="../login-validation.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="daw"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USUARIOS | index</title>
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
					<th>Email</th>
					<th>Password</th>
					<th><a href="UsuariosController?action=create">Crear usuario</a></th>
					<th></th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<daw:forEach var="usuario" items="${usu}">
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.nombre}</td>
						<td>${usuario.email}</td>
						<td>${usuario.password}</td>
						<td><a href="UsuariosController?action=edit&id=${usuario.id}">Edit</a>
							<a href="UsuariosController?action=delete&id=${usuario.id}">Delete</a>
						</td>
					</tr>
				</daw:forEach>
			</tbody>
		</table>
	</div>

	<!--  
			        	el atributo items recoge el elemento que trae mi controller. Seria equivalente al request.getAttribute()
			        	el atributo var seria la variable local para cada iteracion del forEach
			        -->
	<daw:forEach var="usuario" items="${usu}">
		<daw:if test="${usuario.id == 1}">
		</daw:if>
	</daw:forEach>

	<!-- 
	                    la etiqueta out recoge un valor o variable que est?? situado dentro de mi .jsp
	                    El atributo value contiene el nombre de esa variable que en este caso me manda el controlador
                     -->
	<p>
		<daw:out value="${clase}"></daw:out>
	</p>

	<daw:forEach var="usuario" items="${usu}">
		<!-- 
		                    El atributo test evalua una codicion
		                    choose es similar a un switch y contiene lo siguiente
			                    when seria el equivalente al case
			                    otherwise seria equivalente al default
	                    -->
	</daw:forEach>
<footer><address>Copyrigth &copy; Peliculas.com </address></footer>
</body>
</html>