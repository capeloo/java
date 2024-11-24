<%-- 
    Document   : index
    Created on : 23 de nov. de 2024, 16:25:08
    Author     : caioc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="index.css">
        <title>CRUD</title>
    </head>
    <body>
        <main>
            <form action="Login" method="post">
                <h1>Acessar CRUD</h1>
                
                
                <label for="email">E-mail</label> <br>
                <input type="email" name="email" id="email" placeholder="Seu e-mail" class="form_input" required> 
                               
                <label for="senha">Senha</label> <br>
                <input type="password" name="senha" id="senha" placeholder="Sua senha" class="form_input" required> <br>
                
                <input type="submit" value="Entrar" id="btn_entrar">

                <div id="error"><%= request.getAttribute("erroAutenticacao") != null ? request.getAttribute("erroAutenticacao") : "" %></div>
                
            </form>
        </main>
    </body>
</html>

