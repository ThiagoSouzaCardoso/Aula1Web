<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>

<body>
	<h1>Validação de usuários</h1>
	<form action="valida" method="post">
		<label for="nome">Usuário</label><br/>
		<input type="text" name="nome" id="nome" size="20"/><br/>
		<label for="senha">Senha</label><br/>
		<input type="password" name="senha" id="senha" size="20"/><br/>
		<input type="submit" value="Validar">
		<br/>
		<%
			String msg = (String)request.getAttribute("msgValidacao");
			if(msg != null){
		%>
		
		<p><%= msg %> </p>
		
			
		<%	
			}		
		 %>
	</form>
</body>

</html>