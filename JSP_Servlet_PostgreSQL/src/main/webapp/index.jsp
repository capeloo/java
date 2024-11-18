<%-- 
    Document   : cadastro
    Created on : 17 de nov. de 2024, 14:37:34
    Author     : caioc
--%>

<%@page contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro de Usuário</title>
    </head>
    <body>
        <h1>Cadastro de Usuário</h1>
        <!-- <p>Olá, <%= request.getParameter("nome") %></p> -->
        <form action="CadastrarUsuarioServlet" method="post">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required><br><br>
            
            <label for="email">E-mail:</label>
            <input type="email" id="email" name="email" required><br><br>
            
            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" required><br><br>
            
            <label for="idade">Idade:</label>
            <input type="number" id="idade" name="idade" required><br><br>
            
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
