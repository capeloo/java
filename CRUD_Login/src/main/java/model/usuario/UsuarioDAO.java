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
                PreparedStatement pstmt = con.prepareStatement("SELECT id, nome, email FROM usuario ORDER BY id");
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
    
    public int cadastrarUsuario(String nome, String email, String senha){
        int res = 0;
        try {
            Class.forName(JDBC_DRIVER);
            try {
                Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
                String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?);";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, nome);
                pstmt.setString(2, email);
                pstmt.setString(3, senha);
                res = pstmt.executeUpdate();
                pstmt.close();
                con.close();
            } catch (SQLException e){}
        } catch (ClassNotFoundException ex){}
        return res;
    }
    
    public int deletarUsuario(int id){
        int res = 0;
        try {
            Class.forName(JDBC_DRIVER);
            try {
                Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
                String sql = "DELETE FROM usuario WHERE id = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);
                res = pstmt.executeUpdate();
                pstmt.close();
                con.close();
            } catch (SQLException e){}
        } catch (ClassNotFoundException ex){}
        return res;
    }
    
    public Usuario prepararEdicao(int id){
        Usuario usuario = new Usuario();
        try {
            Class.forName(JDBC_DRIVER);
            try {
                Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
                String sql = "SELECT * FROM usuario WHERE id = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
            
                if(rs.next()){
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                
                    usuario.setId(id);
                    usuario.setNome(nome);
                    usuario.setEmail(email);
                }
            
                rs.close();
                pstmt.close();
                con.close();
            } catch (SQLException e){}
        } catch (ClassNotFoundException ex){}
    return usuario;
    }
    
    public int salvarEdicao(String nome, String email, int id){
        int res = 0;
        try {
            Class.forName(JDBC_DRIVER);
            try {
                Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
                String sql = "UPDATE usuario SET nome = ?, email = ? WHERE id = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, nome);
                pstmt.setString(2, email);
                pstmt.setInt(3, id);
                res = pstmt.executeUpdate();
                pstmt.close();
                con.close();
            } catch (SQLException e){}
        } catch (ClassNotFoundException ex){}
        return res;
    }
}
