<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Página do usuário</h1>
	
	<button type="submit"><a class="cadastrar-usuario" href="home.do?action=registerForm">Cadastrar novo usuário</a></button><br><br>
	<button type="submit"><a class="cadastrar-pedido" href="home.do?action=cadastrarPedidoForm">Cadastrar novo pedido</a></button><br><br>
	<button type="submit"><a class="visualizar-pedidos" href="home.do?action=visualizarPedidos">Visualizar Pedidos</a></button><br><br>
	<button type="submit"><a class="logout" href="home.do?action=logout">Logout</a></button>
</body>
</html>