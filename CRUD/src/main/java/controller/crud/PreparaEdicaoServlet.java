package controller.crud;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
@WebServlet(urlPatterns = {"/PreparaEdicaoServlet"})
public class PreparaEdicaoServlet extends HttpServlet {

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
        
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        
        String url = "jdbc:postgresql://localhost:5432/meu_banco";
        String user = "postgres";
        String password = "admin";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
            
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            
            String sql = "SELECT * FROM usuario WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                
                request.setAttribute("id", id);
                request.setAttribute("nome", nome);
                request.setAttribute("email", email);
                
                request.getRequestDispatcher("edicao.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        } catch (ServletException | IOException | ClassNotFoundException | SQLException e) {
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }
    }
}
