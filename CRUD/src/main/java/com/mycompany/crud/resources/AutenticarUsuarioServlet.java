/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.crud.resources;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caioc
 */
@WebServlet(name = "AutenticarUsuarioServlet", urlPatterns = {"/AutenticarUsuarioServlet"})
public class AutenticarUsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Capturando os dados 
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        // Configurando conexão com o banco
        String url = "jdbc:postgresql://localhost:5432/meu_banco";
        String user = "postgres";
        String password = "admin";
        
        try {
            //Driver jdbc (pode ter mais de um)
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AutenticarUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            // Conectando ao banco de dados
            conn = DriverManager.getConnection(url, user, password);
            
            // SQL para verificar se o usuário existe com o e-mail e senha fornecidos
            String sql = "SELECT id, nome FROM usuario WHERE email = ? AND senha = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            // Executa a query
            rs = stmt.executeQuery();
            
            // Verifica se encontrou o usuário
            if(rs.next()){
                // Autenticação bem-sucedida, redireciona para a nova página JSP
                String nome = rs.getString("nome");
                int id = rs.getInt("id");
                
                // Passando o nome do usuario para a nova página JSP
                request.getSession().setAttribute("usuarioNome", nome);
                
                response.sendRedirect("home");
            } else {
                // Usuário não encontrado, redireciona de volta para o login com mensagem de erro
                request.setAttribute("erroAutenticacao", "Email ou senha inválidos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        } catch(Exception e){
            e.printStackTrace();
            response.getWriter().write("Erro ao autenticar o usuário: " + e.getMessage());
        } finally {
            // Fechar as conexões
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
