/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.crud.resources;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author caioc
 */
@WebServlet(name = "DeslogarUsuarioServlet", urlPatterns = {"/DeslogarUsuarioServlet"})
public class DeslogarUsuarioServlet extends HttpServlet {

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
        
        // Invalidar a sessão do usuário para deslogá-lo
        HttpSession session = request.getSession(false); // Obtém a sessão, sem criá-la se não existir
        if (session != null) {
            session.invalidate(); // Invalida a sessão, removendo todos os atributos
        }

        // Redireciona o usuário para a página de login ou outra página após o deslogamento
        response.sendRedirect("index.jsp"); // Redireciona para a página de login
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response); // Chama o método doPost para reutilizar o código
    }
}
