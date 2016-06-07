<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu de Opções</title>
</head>
<body>
	<h1>Menu de Opções</h1>
	<ul>
		<li><a href=<c:url value="/escola/cadastro" />>Cadastro de Escolas</a></li>
		<li><a href=<c:url value="/curso/cadastro" />>Cadastro de Cursos</a></li>
	</ul>
</body>
</html>