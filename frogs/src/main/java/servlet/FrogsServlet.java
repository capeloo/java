package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "FrogsServlet", urlPatterns = {"/api/frogs"})
public class FrogsServlet extends HttpServlet {

    private List<String> getFrogs(){
        return Arrays.asList("Espirã", "Zé-perereca", "Sapo da bundinha");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        String json = "[\"Espirã\", \"Zé-perereca\", \"Sapo da bundinha\"]";
        
        response.getWriter().write(json);
    }
}
