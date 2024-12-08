package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.frogs.Frogs;
import model.frogs.FrogsDAO;

@WebServlet(name = "GetFrogByIdServlet", urlPatterns = {"/api/details"})
public class GetFrogByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        
        FrogsDAO frogsDAO = new FrogsDAO();
        Frogs frog = frogsDAO.getFrogById(id);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(frog);
        
        response.getWriter().write(json);
    }
}
