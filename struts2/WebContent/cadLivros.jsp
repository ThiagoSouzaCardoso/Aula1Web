<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sx:head />
<title>Cadastro de Livros</title>
</head>
<body>
	<h1>Cadastro de Livros</h1>
	<s:form action="cadastro" method="post" enctype="multipart/form-data">
		<s:textfield name="livro.codigo" label="Código" size="10" />
		<s:textfield name="livro.titulo" label="Título" size="30" />
		<s:textfield name="livro.autor" label="Autor" size="30" />
		<sx:datetimepicker name="livro.dataPublicacao" label="Data Publicação" displayFormat="dd/MM/yyyy" />
		<s:textfield name="livro.preco" label="Preço" size="30" />
		<s:file name="figura" label="Selecione a imagem:" />
		<s:submit name="submit" label="Incluir" align="center" />
	</s:form>
</body>
</html>