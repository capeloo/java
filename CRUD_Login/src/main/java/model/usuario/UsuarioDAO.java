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
import java.util.ArrayList;
import java.util.List;
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
                    PreparedStatement pstmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");
                ) 
                {
                    pstmt.setString(1, email);
                    pstmt.setString(2, senha);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            String nome = rs.getString("nome");                          
                            int id = rs.getInt("id");
                            
                            usuario.setNome(nome);
                            usuario.setId(id);
                        }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
          
        }
        return usuario;
    }
    
    public List<Usuario> listarUsuario(){
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            Class.forName(JDBC_DRIVER);
            try {
                Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
                PreparedStatement pstmt = con.prepareStatement("SELECT id, nome, email FROM usuario");
                try(ResultSet rs = pstmt.executeQuery()){
                    while(rs.next()){
                        Usuario usuario = new Usuario();
                        usuario.setId(rs.getInt("id"));
                        usuario.setNome(rs.getString("nome"));
                        usuario.setEmail(rs.getString("email"));
                        usuarios.add(usuario);
                    }
                    rs.close();
                }
                pstmt.close();
                con.close();
            } catch(SQLException ex){}
        } catch (ClassNotFoundException ex){}
        
    return usuarios;
    }
}
