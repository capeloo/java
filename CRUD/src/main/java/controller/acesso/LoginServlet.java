/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.acesso;

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
import model.usuario.Usuario;
import model.usuario.UsuarioDAO;

/**
 *
 * @author caioc
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Entrada de dados 
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        // Processando os dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.autenticar(email, senha);
        
        // Saída de dados
        if(usuario.getEmail().equals(email)){
            request.getSession().setAttribute("usuarioNome", usuario.getNome());
            response.sendRedirect("home");
        } else {
            request.setAttribute("erroAutenticacao", "Email ou senha inválidos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
