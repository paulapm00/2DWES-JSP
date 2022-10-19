<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file = "login-validation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
		<h1>HOLA ESTOY EN MI HOME</h1>
		<a href="UsuariosController?action=index">Index usuarios</a>
		<a href="AuthController?action=logout">Cerrar sesion</a>
	</body>
</html>