/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.categoria;

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
public class CategoriaDAO {
    public List<Categoria> obterTodas(){
        List<Categoria> categorias = new ArrayList<>();     
        try {
            Class.forName(JDBC_DRIVER);
            try {
                Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
                PreparedStatement pstmt = con.prepareStatement("SELECT id, descricao FROM CATEGORIA ORDER BY id");
                try(ResultSet rs = pstmt.executeQuery()){
                    while(rs.next()){
                        Categoria categoria = new Categoria();
                        categoria.setId(rs.getInt("id"));
                        categoria.setDescricao(rs.getString("descricao"));             
                        categorias.add(categoria);
                    }
                    rs.close();
                }
                pstmt.close();
                con.close();
            } catch(SQLException ex){}
        } catch (ClassNotFoundException ex){}
        
    return categorias;
    }
    
    public Categoria obter(int id){
    Categoria categoria = new Categoria();
        try {
            Class.forName(JDBC_DRIVER);
            try {
                Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
                PreparedStatement pstmt = con.prepareStatement("SELECT id, descricao FROM CATEGORIA WHERE id = ?");
                pstmt.setInt(1, id);
                try(ResultSet rs = pstmt.executeQuery()){
                    while(rs.next()){                   
                        categoria.setId(rs.getInt("id"));
                        categoria.setDescricao(rs.getString("descricao"));
                    }
                    rs.close();
                } 
            } catch(SQLException ex){}
        } catch (ClassNotFoundException ex){}
        return categoria;
    }
    
    public boolean inserir(String descricao){
        boolean res = false;
        try {
            Class.forName(JDBC_DRIVER);
            try {
                Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
                PreparedStatement pstmt  = con.prepareStatement("INSERT INTO CATEGORIA (descricao) VALUES (?);");
                pstmt.setString(1, descricao);        
                if(pstmt.executeUpdate() == 1){
                    res = true;
                }
                pstmt.close();
                con.close();   
            } catch (SQLException e){}
        } catch (ClassNotFoundException ex){}
        return res;
    }
    
    public boolean atualizar(String descricao, int id){
        boolean res = false;
        try {
            Class.forName(JDBC_DRIVER);
            try {
                Connection con = DriverManager.getConnection(JDBC_URL,  JDBC_USUARIO, JDBC_SENHA);
                PreparedStatement pstmt = con.prepareStatement("UPDATE CATEGORIA SET descricao = ? WHERE id = ?");
                pstmt.setString(1, descricao);
                pstmt.setInt(2, id);
                if(pstmt.executeUpdate() == 1){
                    res = true;
                }
                pstmt.close();
                con.close();
            } catch (SQLException e){}
        } catch (ClassNotFoundException ex){}
        return res;
    }
    
    public boolean remover(int id){
        boolean res = false;
        try {
            Class.forName(JDBC_DRIVER);
            try {
                Connection con = DriverManager.getConnection(JDBC_URL,  JDBC_USUARIO, JDBC_SENHA);
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM CATEGORIA WHERE id = ?");
                pstmt.setInt(1, id);
                if(pstmt.executeUpdate() == 1){
                    res = true;
                }
                pstmt.close();
                con.close();
            } catch (SQLException e){}
        } catch (ClassNotFoundException ex){}
        return res;
    }
}
