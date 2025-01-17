<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	
	<form method="post" action="front.do?action=getLogin">		
		<label for="email">Email:</label>
		<input type="text" id="email" name="email" placeholder="Digite o email."><br><br>
		
		<label for="senha">Senha:</label>
		<input type="password" id="senha" name="senha" placeholder="Digite a senha."><br><br>
		
		<button type="submit">Logar</button>
	</form>
</body>
</html>