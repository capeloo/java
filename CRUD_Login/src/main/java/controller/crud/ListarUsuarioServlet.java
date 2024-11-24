/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.crud;

import model.usuario.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.usuario.UsuarioDAO;

/**
 *
 * @author caioc
 */
@WebServlet(name = "ListarUsuarioServlet", urlPatterns = {"/listarUsuario"})
public class ListarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Verificar se o usuário está autenticado
        //String usuarioNome = (String) request.getSession().getAttribute("usuarioNome");
 
        //if (usuarioNome == null) {
            // Se o usuário não estiver autenticado, redireciona para o login
        //    response.sendRedirect("index.jsp");
        //    return;
        //}
        
        // Entrada
        String usuarioNome = (String) request.getSession().getAttribute("usuarioNome");
        
        // Processamento
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> lista = usuarioDAO.listarUsuario();
        
        // Saída
        if(lista.isEmpty()){
            request.setAttribute("usuarios", lista);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            
        }
    }
}