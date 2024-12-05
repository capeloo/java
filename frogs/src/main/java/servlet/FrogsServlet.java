package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.frogs.Frogs;
import model.frogs.FrogsDAO;

@WebServlet(name = "FrogsServlet", urlPatterns = {"/api/frogs"})
public class FrogsServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        
        FrogsDAO frogsDAO = new FrogsDAO();
        List<Frogs> frogs = frogsDAO.getFrogs();
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(frogs);
        
        response.getWriter().write(json);
    }
}
