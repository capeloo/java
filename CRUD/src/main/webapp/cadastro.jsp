<%-- 
    Document   : index
    Created on : 18 de nov. de 2024, 03:39:20
    Author     : caioc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="cadastro.css">
        <title>Cadastro</title>
    </head>
    <body>
        <main>
            <form action="CadastrarUsuarioServlet" method="post">
                <h1>Cadastrar usuário</h1>

                <label for="nome">Nome</label> <br>
                <input type="text" name="nome" id="nome" placeholder="Seu nome" class="form_input" required>                
                
                <label for="email">E-mail</label> <br>
                <input type="email" name="email" id="email" placeholder="Seu e-mail" class="form_input" required> 
                               
                <label for="senha">Senha</label> <br>
                <input type="password" name="senha" id="senha" placeholder="Sua senha" class="form_input" required> <br>
                
                <input type="submit" value="Cadastrar" id="btn_cadastrar">
                
            </form>
        </main>
    </body>
</html>