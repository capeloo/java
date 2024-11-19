<%-- 
    Document   : edicao
    Created on : 19 de nov. de 2024, 00:13:49
    Author     : caioc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="edicao.css">
        <title>Edição</title>
    </head>
    <body>
        <main>
            <form action="SalvarEdicaoUsuarioServlet" method="post">
                <h1>Editar usuário</h1>

                <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">

                <label for="nome">Nome</label> <br>
                <input type="text" name="nome" id="nome" value="<%= request.getAttribute("nome") %>" placeholder="Seu nome" class="form_input" required>                
                
                <label for="email">E-mail</label> <br>
                <input type="email" name="email" id="email" value="<%= request.getAttribute("email") %>" placeholder="Seu e-mail" class="form_input" required> <br>
                
                <input type="submit" value="Salvar" id="btn_salvar">
                
            </form>
        </main>
    </body>
</html>