<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Livros</title>
</head>
<body>
	<h1>Lista de Livros Cadastrados</h1>
	<jsp:useBean id="livro" class="br.com.fiap.bean.LivrosBean" />
	<table border="1">
		<tr>
			<td>Código</td>
			<td>Título</td>		
			<td colspan="2">Opções</td>	
		</tr>
		<c:forEach var="book" items="${livro.listaLivros}">
			<tr>
				<td>${book.codigo}</td>
				<td>${book.titulo}</td>
				<td><a href="consultarLivro?codigo=${book.codigo}">Detalhes</a></td>
				<td><a href="#">Sinopse</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>