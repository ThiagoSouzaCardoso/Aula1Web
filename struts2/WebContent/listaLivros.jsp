<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de Livros</title>
</head>
<body>
	<h1>Lista de Livros</h1>
	<table>
		<tr>
			<td>CÓDIGO</td>
			<td>TÍTULO</td>
			<td>AUTOR</td>
		</tr>
		<s:iterator value="listaLivros">
			<tr>
				<td><s:property value="codigo" /></td>
				<td><s:property value="titulo" /></td>
				<td><s:property value="autor" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>