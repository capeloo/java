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
@WebServlet(name = "DeletarUsuarioServlet", urlPatterns = {"/DeletarUsuarioServlet"})
public class DeletarUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        
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
            
            String sql = "DELETE FROM usuario WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            // Executa a query
            int res = stmt.executeUpdate();
            
            if(res == 1){
                response.sendRedirect("home");
            } else {
                request.setAttribute("erroCadastro", "Não foi possível deletar o usuário");
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
            
        } catch(ServletException | IOException | SQLException e){
            response.getWriter().write("Erro ao deletar o usuário: " + e.getMessage());
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
