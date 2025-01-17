<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastre-se</title>
</head>
<body>
	<h1>Cadastro</h1>
	
	<h4>Dados para cadastro:</h4>
	
	<form method="post" action="home.do?action=register">		
		<label for="email">Email:</label>
		<input type="text" id="email" name="email" placeholder="Digite o email."><br><br>
		
		<label for="senha">Senha:</label>
		<input type="password" id="senha" name="senha" placeholder="Digite a senha."><br><br>
		
		<button type="submit">Registrar</button>
	</form>
</body>
</html>