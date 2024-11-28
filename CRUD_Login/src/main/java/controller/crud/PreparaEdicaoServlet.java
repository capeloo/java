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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.usuario.Usuario;
import model.usuario.UsuarioDAO;

/**
 *
 * @author caioc
 */
@WebServlet(name = "PreparaEdicaoServlet", urlPatterns = {"/PreparaEdicaoServlet"})
public class PreparaEdicaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.prepararEdicao(id);
        
        if(!usuario.getNome().isEmpty()){
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("edicao.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }
}
