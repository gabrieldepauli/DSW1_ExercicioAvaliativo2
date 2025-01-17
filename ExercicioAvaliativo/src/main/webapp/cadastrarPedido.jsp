<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Pedido</title>
</head>
<body>
	<h1>Cadastre seu pedido aqui!</h1>
	
	<h4>Dados do pedido:</h4>
	
	<form method="post" action="">
		<label for="id">ID do pedido:</label>
		<input type="number" id="id" name="id" placeholder="Selecione o ID." required="required"><br><br>
	
		<label for="nome">Nome do cliente:</label>
		<input type="text" id="nome" name="nome" placeholder="Digite o nome completo." required="required"><br><br>
		
		<label for="endereco">Endereço:</label>
		<input type="text" id="endereco" name="endereco" placeholder="Digite o endereço." required="required"><br><br>
		
		<label for="valor">Valor do pedido:</label>
		<input type="number" id=""valor"" name=""valor"" placeholder="Digite o valor." required="required"><br><br>
		
		<label for="descricao">Descrição:</label>
		<input type="text" id=""descricao"" name=""descricao"" placeholder="Digite a descrição do pedido."><br><br>
		
		<button type="submit">Cadastrar</button>	
	</form>
</body>
</html>