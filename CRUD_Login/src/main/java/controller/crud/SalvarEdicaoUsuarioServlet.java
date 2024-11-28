/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.crud;

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
@WebServlet(name = "SalvarEdicaoUsuarioServlet", urlPatterns = {"/SalvarEdicaoUsuarioServlet"})
public class SalvarEdicaoUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int res = usuarioDAO.salvarEdicao(nome, email, id);
        
        if(res == 1){
            response.sendRedirect("listarUsuario");
        } else {}
    }
}
