<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Cursos</title>
</head>
<body>
	<h1>Cadastro de Cursos</h1>
	<form action=<c:url value="/cadcurso"/> method="post">
		<table>
			<tr>
				<td>Código do Curso:</td>
				<td><input type="text" name="id" size="10"></td>
			</tr>
			<tr>
				<td>Nome do Curso:</td>
				<td><input type="text" name="descricao" size="40"></td>
			</tr>
			<tr>
				<td>Selecione a escola:</td>
				<td><select name="idc">
						<c:forEach var="e" items="${escolas}">
							<option value="${e.id}">${e.descricao}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="Incluir Curso">
	</form>
</body>
</html>