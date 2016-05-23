<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="cadLivros" method="post" 
	                             enctype="multipart/form-data">
	                             
		<label for="codigo" >Código</label><br>
		<input type="text" name="codigo" id="codigo" size="10"/><br/>
		<label for="titulo" >Título</label><br>
		<input type="text" name="titulo" id="titulo" size="30"/><br/>
		<label for="autor" >Autor</label><br>
		<input type="text" name="autor" id="autor" size="30"/><br/>
		<label for="data" >Data Publicação</label><br>
		<input type="text" name="data" id="data" size="30"/><br/>
		<label for="preco" >Preço</label><br>
		<input type="text" name="preco" id="preco" size="30"/><br/>
		
		<label for="foto" >Foto</label><br>
		<input type="file" name="foto" id="foto"/><br/>
		
		<input type="submit" value="Incluir"/><br/> 
		${msg}			                             
	
	</form>
</body>
</html>