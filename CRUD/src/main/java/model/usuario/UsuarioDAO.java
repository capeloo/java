/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.usuario;

import static config.Constantes.JDBC_DRIVER;
import static config.Constantes.JDBC_SENHA;
import static config.Constantes.JDBC_URL;
import static config.Constantes.JDBC_USUARIO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author caioc
 */
public class UsuarioDAO {
    public Usuario autenticar(String email, String senha) {
        Usuario usuario = new Usuario();
        
        try {
            Class.forName(JDBC_DRIVER);
            try (
                    Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA); 
                    PreparedStatement pstmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?")
                ) 
                {
                    pstmt.setString(1, email);
                    pstmt.setString(2, senha);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            String nome = rs.getString("nome");
                            email = rs.getString("email");
                            int id = rs.getInt("id");
                            
                            usuario.setNome(nome);
                            usuario.setEmail(email);
                            usuario.setId(id);
                        }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
          
        }
        return usuario;
    }
}
