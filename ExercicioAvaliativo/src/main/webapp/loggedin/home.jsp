<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <h1 class="text-center my-4">Página do usuário</h1>

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
        <div class="text-center">
            <a href="home.do?action=registerForm" style="text-decoration: none;">
                <button class="btn btn-outline-dark btn-block w-100 mb-3" style="font-size: 15px; font-weight: bold;">Cadastrar novo usuário</button>
            </a>
            
            <a href="home.do?action=cadastrarPedidoForm" style="text-decoration: none;">
                <button class="btn btn-outline-dark btn-block w-100 mb-3" style="font-size: 15px; font-weight: bold;">Cadastrar novo pedido</button>
            </a>
            
            <a href="home.do?action=visualizarPedidos" style="text-decoration: none;">
                <button class="btn btn-outline-dark btn-block w-100 mb-3" style="font-size: 15px; font-weight: bold;">Visualizar Pedidos</button>
            </a>
            
            <a href="home.do?action=logout" style="text-decoration: none;">
                <button class="btn btn-danger btn-block w-100" style="font-size: 15px; font-weight: bold;">Logout</button>
            </a>
        </div>
    </div>

</body>
</html>
