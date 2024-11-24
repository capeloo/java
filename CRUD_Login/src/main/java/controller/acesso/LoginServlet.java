/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.acesso;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.usuario.Usuario;
import model.usuario.UsuarioDAO;

/**
 *
 * @author caioc
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Entrada de dados 
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        // Processando os dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.autenticar(email, senha);
        
        // Saída de dados
        if (usuario != null) {
            request.getSession().setAttribute("usuarioNome", usuario.getNome());
            response.sendRedirect("listarUsuario");
        } else {
            request.setAttribute("erroAutenticacao", "Email ou senha inválidos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
       
    }
}