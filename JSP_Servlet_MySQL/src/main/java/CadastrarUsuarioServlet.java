/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caioc
 */
@WebServlet(urlPatterns = {"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Captura os dados do usuário
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("idade");
        int idade = Integer.parseInt(request.getParameter("idade"));
        
        // Estabelecendo a conexão com o banco de dados e inserindo o usuário
        String url = "jdbc:postgresql://localhost:5432/meu_banco";
        String user = "postgres";
        String password = "admin";
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            // Conectando ao banco de dados
            conn = DriverManager.getConnection(url, user, password);
            
            // SQL para inserir um novo usuário
            String sql = "INSERT INTO usuarios (nome, email, senha, idade) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.setInt(4, idade);
            
            // Executa o comando de inserção no banco de dados
            stmt.executeUpdate();
            
            // Resposta de sucesso
            response.getWriter().write("Usuario cadastrado com sucesso!");
            
        } catch(Exception e){
            e.printStackTrace();
            response.getWriter().write("Erro ao cadastrar usuário: " + e.getMessage());
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
