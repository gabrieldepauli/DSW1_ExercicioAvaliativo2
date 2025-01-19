<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Pedido</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <h1 class="text-center my-4">Cadastre seu pedido aqui!</h1>

    <h2 class="text-center mb-4">Dados do pedido:</h2>

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

    <div class="container border p-4 shadow-sm rounded" style="max-width: 600px; margin: 0 auto;">
        <form method="post" action="home.do?action=cadastrarPedido" class="text-center">
            
            <div class="mb-3">
                <label for="nome" class="form-label" style="font-weight: bold; font-size: 16px;">Nome do cliente:</label>
                <input type="text" id="nome" name="nome" placeholder="Digite o nome completo." required="required" class="form-control text-center" style="max-width: 250px; margin: 0 auto;">
            </div>

            <div class="mb-3">
                <label for="endereco" class="form-label" style="font-weight: bold; font-size: 16px;">Endereço:</label>
                <input type="text" id="endereco" name="endereco" placeholder="Digite o endereço." required="required" class="form-control text-center" style="max-width: 250px; margin: 0 auto;">
            </div>

            <div class="mb-3">
                <label for="valor" class="form-label" style="font-weight: bold; font-size: 16px;">Valor do pedido:</label>
                <input type="number" id="valor" name="valor" placeholder="Digite o valor." step="0.01" required="required" class="form-control text-center" style="max-width: 250px; margin: 0 auto;">
            </div>

            <div class="mb-3">
                <label for="descricao" class="form-label" style="font-weight: bold; font-size: 16px;">Descrição:</label>
                <input type="text" id="descricao" name="descricao" placeholder="Digite a descrição do pedido." required="required" class="form-control text-center" style="max-width: 250px; margin: 0 auto;">
            </div>

            <div>
                <button type="submit" class="btn btn-success w-100" style="font-weight: bold;">Cadastrar</button>
            </div>
        </form>

    </div>
    
    <p class="text-center mt-4">
        <a href="home.do?action=homePage" style="text-decoration: none;">
	        <button class="btn btn-danger" style="font-weight: bold;">Voltar</button>
		</a>
    </p>
        
</body>
</html>
