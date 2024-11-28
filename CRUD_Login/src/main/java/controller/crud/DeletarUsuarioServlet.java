/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.crud;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.usuario.UsuarioDAO;

/**
 *
 * @author caioc
 */
@WebServlet(name = "DeletarUsuarioServlet", urlPatterns = {"/DeletarUsuarioServlet"})
public class DeletarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int res = usuarioDAO.deletarUsuario(id);
        
        if(res == 1) {
            response.sendRedirect("listarUsuario");
        } else {}
    }
}
