/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.categoria;

/**
 *
 * @author caioc
 */
public class Categoria {
    private int id;
    private String descricao;
    
    public int getId(){
        return id;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;                
    }
}
