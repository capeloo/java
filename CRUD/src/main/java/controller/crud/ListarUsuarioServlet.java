/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.crud;

import model.usuario.Usuario;
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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caioc
 */
@WebServlet(name = "ListarUsuarioServlet", urlPatterns = {"/home"})
public class ListarUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Verificar se o usuário está autenticado
        String usuarioNome = (String) request.getSession().getAttribute("usuarioNome");
        if (usuarioNome == null) {
            // Se o usuário não estiver autenticado, redireciona para o login
            response.sendRedirect("index.jsp");
            return;
        }
        
        String url = "jdbc:postgresql://localhost:5432/meu_banco";
        String user = "postgres";
        String password = "admin";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            
            // SQL para obter todos os registros de usuários
            String sql = "SELECT id, nome, email FROM usuario";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Preencher a lista de usuários
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuarios.add(usuario);
            }

            // Passando a lista de usuários para a JSP
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("sucesso", "sucesso");
            request.getRequestDispatcher("home.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
}
