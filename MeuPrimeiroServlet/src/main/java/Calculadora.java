/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author caioc
 */
@WebServlet(urlPatterns = {"/Calculadora"})
public class Calculadora extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Entrada */
        double x = Double.parseDouble(request.getParameter("x"));
        double y = Double.parseDouble(request.getParameter("y"));
        int op = Integer.parseInt(request.getParameter("op"));
        
        /* Processamento e Saída */
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculadora Web</title>");
            out.println("</head>");
            out.println("<body>");
            
            switch(op) {
                case 1: {
                    out.println("<h1>" + x + " + " + y + " = " + (x + y) + "</h1>");
                    break;
                }
                case 2: {
                    out.println("<h1>" + x + " - " + y + " = " + (x - y) + "</h1>");
                    break;
                }
                case 3: {
                    out.println("<h1>" + x + " * " + y + " = " + (x * y) + "</h1>");
                    break;
                }
                case 4: {
                    out.println("<h1>" + x + " / " + y + " = " + (x / y) + "</h1>");
                    break;
                }
            }
            
            out.println("</body>");
            out.println("</html>");
        }
        }
    }

