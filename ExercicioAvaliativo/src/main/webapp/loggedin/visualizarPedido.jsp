<%@page import="java.util.List"%>
<%@page import="model.entity.Pedido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Pedidos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%
	var pedidos = (List<Pedido>) request.getAttribute("pedidos");
	
	if (pedidos == null || pedidos.isEmpty()) {
		request.getRequestDispatcher("/loggedin/home.jsp").forward(request, response);

	} else {
	%>
		
	<h1 class="text-center my-4">Pedidos Cadastrados</h1>
	
	<%
    	String message = (String) request.getAttribute("message");

    	if (message != null) {
	%>
    <div class="d-flex justify-content-center mt-3">
        <div class="alert alert-secondary alert-dismissible fade show text-center" role="alert">
            <%= message %>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
	<%
    	}
	%>
	
	<form action="home.do?action=buscaPedido" method="post" class="text-center mb-4">
		<input type="text" id="nome" name="nome" placeholder="Pesquise o nome do Cliente" class="form-control w-50 mx-auto text-center">
		<button type="submit" class="btn btn-primary mt-2">Buscar</button>
	</form>
	
	<table class="table table-bordered table-striped table-hover w-75 mx-auto">
		<thead>
			<tr class="text-center">
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">Endereço</th>
					<th scope="col">Valor</th>
					<th scope="col">Descrição</th>
					<th scope="col">Alterar</th>
					<th scope="col">Excluir</th>
			</tr>
		</thead>
			
		<tbody>
		<%
		int i = 1;
		for (var pedido : pedidos) {
		%>
			<tr class="text-center">
				<td><%=pedido.getId()%></td>
				<td><%=pedido.getNome() %></td>
				<td><%=pedido.getEndereco() %></td>
				<td><%=pedido.getValor() %></td>
				<td><%=pedido.getDescricao() %></td>
				<td>
					<a href="home.do?action=formUpdatePedido&id=<%=pedido.getId()%>" class="btn btn-warning">Editar</a>
				</td>
				<td>
					<a class="btn btn-danger" 
					onclick="return confirm('Confirma a exclusão?');" 
					href="home.do?action=delete&id=<%= pedido.getId() %>">Apagar</a>
				</td>
			</tr>
		<%	i += 1;
		} 
		%>
		</tbody>
	</table>

	<div class="text-center my-4">
		<a href="home.do?action=homePage">
			<button class="btn btn-danger">Voltar</button>
		</a>
	</div>

	<%} %>
</body>
</html>
