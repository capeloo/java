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
        <link rel="stylesheet" href="style.css">
        <title>CRUD</title>
    </head>
    <body>
        <main>
            <form action="AutenticarUsuarioServlet" method="post">
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
