/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.crud;

import controller.acesso.LoginServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caioc
 */
@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns = {"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Capturando os dados 
        String nome = request.getParameter("nome");
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            // Conectando ao banco de dados
            conn = DriverManager.getConnection(url, user, password);
            
            String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            
            // Executa a query
            int res = stmt.executeUpdate();
            
            if(res == 1){
                response.sendRedirect("home");
            } else {
                request.setAttribute("erroCadastro", "Não foi possível cadastrar o usuário");
                request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            }
            
        } catch(ServletException | IOException | SQLException e){
            response.getWriter().write("Erro ao cadastrar o usuário: " + e.getMessage());
        } finally {
            // Fechar as conexões
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }
    }
}
