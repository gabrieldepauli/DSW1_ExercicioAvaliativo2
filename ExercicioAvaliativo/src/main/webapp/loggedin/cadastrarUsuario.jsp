<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastre-se</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>    
</head>
<body>
    <h1 class="text-center my-4">Cadastro</h1>

    <h4 class="text-center mb-4">Dados para cadastro:</h4>

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

    <div class="container border p-4 shadow-sm rounded" style="max-width: 400px; margin: 0 auto;">
        <form method="post" action="home.do?action=register" class="text-center">
            
            <div class="mb-3">
                <label for="email" class="form-label" style="font-weight: bold; font-size: 16px;">Email:</label>
                <input type="text" id="email" name="email" placeholder="Digite o email." class="form-control text-center" style="max-width: 250px; margin: 0 auto;" required="required">
            </div>

            <div class="mb-3">
                <label for="senha" class="form-label" style="font-weight: bold; font-size: 16px;">Senha:</label>
                <input type="password" id="senha" name="senha" placeholder="Digite a senha." class="form-control text-center" style="max-width: 250px; margin: 0 auto;" required="required">
            </div>

            <div>
                <button type="submit" class="btn btn-success w-100" style="font-weight: bold;">Registrar</button>
            </div>
        </form>
    </div>

    <div class="text-center mt-4">
        <a href="home.do?action=homePage" style="text-decoration: none;">
            <button class="btn btn-danger" style="font-weight: bold;">Voltar</button>
        </a>
    </div>
</body>
</html>
