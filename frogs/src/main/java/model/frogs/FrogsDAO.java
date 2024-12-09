package model.frogs;

import static config.Constantes.JDBC_DRIVER;
import static config.Constantes.JDBC_SENHA;
import static config.Constantes.JDBC_URL;
import static config.Constantes.JDBC_USUARIO;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrogsDAO {
    
    public List<Frogs> getFrogs(){
        List<Frogs> frogs = new ArrayList<>();
        
        try{
            Class.forName(JDBC_DRIVER);
            try {
                Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
                PreparedStatement pstmt = con.prepareStatement("SELECT id, name, photo, date FROM frogs ORDER BY id");
                try(ResultSet rs = pstmt.executeQuery()){
                    while(rs.next()){
                        Frogs frog = new Frogs();
                        frog.setId(rs.getInt("id"));
                        frog.setName(rs.getString("name"));
                        frog.setPhoto(rs.getString("photo"));
                        frog.setDate(rs.getDate("date"));
                        frogs.add(frog);
                    }
                    rs.close();
                }
                pstmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(FrogsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrogsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return frogs;
    }
    
    public Frogs getFrogById(int id){
        Frogs frog = new Frogs();
        
        try {
            Class.forName(JDBC_DRIVER);
            try {
                Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
                PreparedStatement pstmt = con.prepareStatement("SELECT name, photo FROM frogs WHERE id = ?");
                pstmt.setInt(1, id);
                try(ResultSet rs = pstmt.executeQuery()){
                    while(rs.next()){
                        frog.setName(rs.getString("name"));
                        frog.setPhoto(rs.getString("photo"));
                    }
                    rs.close();
                }
                pstmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(FrogsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrogsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return frog;
    }
}
