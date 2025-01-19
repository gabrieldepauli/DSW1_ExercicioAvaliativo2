<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.entity.Pedido" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Pedido</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <h1 class="text-center my-4">Editar Pedido</h1>

    <%
    String message = (String) request.getAttribute("message");
    Pedido pedido = (Pedido) request.getAttribute("pedido");

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

    <div class="container border p-4 shadow-sm rounded" style="max-width: 600px; margin: 0 auto;">
        <form action="home.do?action=update" method="post" class="text-center">
            <input type="hidden" name="id" value="<%= pedido.getId() %>">
            
            <div class="mb-3">
                <label for="nomeCliente" class="form-label fw-bold">Nome do cliente</label>
                <input type="text" id="nome" name="nome" value="<%= pedido.getNome() %>" placeholder="Digite o nome do cliente" class="form-control" required="required">
            </div>

            <div class="mb-3">
                <label for="endereco" class="form-label fw-bold">Endereço</label>
                <input type="text" id="endereco" name="endereco" value="<%= pedido.getEndereco() %>" placeholder="Digite o endereço do pedido" class="form-control" required="required">
            </div>

            <div class="mb-3">
                <label for="valor" class="form-label fw-bold">Valor</label>
                <input type="number" id="valor" name="valor" value="<%= pedido.getValor() %>" placeholder="Digite o valor do pedido" class="form-control" required="required">
            </div>

            <div class="mb-3">
                <label for="descricao" class="form-label fw-bold">Descrição</label>
                <input type="text" id="descricao" name="descricao" value="<%= pedido.getDescricao() %>" placeholder="Digite a descrição do pedido" class="form-control" required="required">
            </div>

            <button type="submit" class="btn btn-success mt-3">Alterar</button>
        </form>
    </div>

    <div class="text-center my-4">
        <a href="home.do?action=visualizarPedidos">
            <button class="btn btn-danger">Voltar</button>
        </a>
    </div>

</body>
</html>
