<%-- 
    Document   : home
    Created on : 18 de nov. de 2024, 05:49:11
    Author     : caioc
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.crud.resources.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <header>
            <nav>
                <h2>CRUD</h2>
                <button onclick="">Cadastrar</button>
            </nav>
        </header>
        <main>
            <section>
                <h1>Olá, <%= session.getAttribute("usuarioNome") %>!</h1>
            </section>
            <section>
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            
                            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                            if (usuarios != null) {
                                for (Usuario usuario : usuarios) {
                        %>
                                    <tr>
                                        <td><%= usuario.getId() %></td>
                                        <td><%= usuario.getNome() %></td>
                                        <td><%= usuario.getEmail() %></td>
                                    </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </section>
        </main>
    </body>
</html>