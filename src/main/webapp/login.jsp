<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form method="POST" action="AuthController?action=login">
        	<p>Email:</p>
        	<input type="email" name="email">
        	<br>
        	<p>Password:</p>
        	<input type="text" name="password">
        	<br>

        	<button type="submit">Enviar</button>
        </form>
	</body>
</html>