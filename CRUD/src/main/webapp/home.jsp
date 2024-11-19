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
        <link rel="stylesheet" href="home.css">
        <title>Home</title>
    </head>
    <body>
        <header>
            <nav>
                <h2>CRUD</h2>
                <div>
                    <button onclick="window.location.href='cadastro.jsp';">Cadastrar</button>
                    <form action="DeslogarUsuarioServlet" method="post">
                        <button type="submit" id="btn_deslogar">Sair</button>
                    </form>
                </div>
            </nav>
        </header>
        <main>
            <section id="sec01">
                <h1>Olá, <%= session.getAttribute("usuarioNome") %>!</h1>
            </section>
            <section id="sec02">
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Ações</th>
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
                                        <td id="td_btn">
                                            <form action="PreparaEdicaoServlet" method="post">
                                                <input type="hidden" name="id" value="<%= usuario.getId() %>">
                                                <button type="submit" id="td_btn_editar">Editar</button>
                                            </form>
                                        
                                            <form action="DeletarUsuarioServlet" method="post">
                                                <input type="hidden" name="id" value="<%= usuario.getId() %>">
                                                <button type="submit">Deletar</button>
                                            </form>
                                            
                                        </td>
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