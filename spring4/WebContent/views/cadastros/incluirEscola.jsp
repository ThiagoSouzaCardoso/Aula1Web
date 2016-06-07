<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Escolas</title>
</head>
<body>
	<h1>Cadastro de Escolas</h1>
	<form action=<c:url value="/cadescola"/> method="post">
		<table>
			<tr>
				<td>Nome da escola:</td>
				<td><input type="text" name="descricao" size="30"></td>
			</tr>
			<tr>
				<td>Endereco:</td>
				<td><input type="text" name="endereco" size="30"></td>
			</tr>
			<tr>
				<td>Data Fundação (dd/MM/yyyy):</td>
				<td><input type="text" name="dataString" size="20"></td>
			</tr>
		</table>
		<input type="submit" value="Incluir Escola">
	</form>
	${msg}
</body>
</html>
