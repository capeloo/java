/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ex02_jdbc_dao;

import java.util.List;
import java.util.Scanner;
import model.categoria.Categoria;
import model.categoria.CategoriaDAO;

/**
 *
 * @author caioc
 */
public class Ex02_jdbc_dao {

    public static void main(String[] args) {
        boolean sair = false;
        Scanner in = new Scanner(System.in);
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        while(sair == false){
            System.out.println("////// Sistema Categoria ////////");
            System.out.println("Escolha a operacao que deseja realizar:");
            System.out.println("- Inserir categoria (digite 1)");
            System.out.println("- Listar categorias (digite 2)");
            System.out.println("- Obter categoria pelo id (digite 3)");
            System.out.println("- Atualizar categoria (digite 4)");
            System.out.println("- Remover categoria (digite 5)");
            int num = in.nextInt();
            
            switch(num){
            case 1 -> {
                System.out.println("////////////////////////////////");
                System.out.print("Digite o nome da nova categoria: ");
                String descricao = in.next();
                if(categoriaDAO.inserir(descricao) == true){
                    System.out.println("Categoria inserida com sucesso!");
                    System.out.println("Deseja fazer uma nova operacao? [y/n]: ");
                    String decisao = in.next();
                    if(decisao.equals("n")){
                        sair = true;
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Não foi possível inserir uma nova categoria.");
                }
                }
            
            case 2 -> {
                List<Categoria> categorias = categoriaDAO.obterTodas();
                System.out.println("////////////////////////////////");
                System.out.println("--------------------");
                System.out.println("| id | descricao |");
                for(Categoria categoria : categorias){
                    System.out.println("| " + categoria.getId() + " | " + categoria.getDescricao() + " |");
                }
                System.out.println("--------------------");
                System.out.println("/////////////////////////////////");
                System.out.println("Deseja fazer uma nova operacao? [y/n]: ");
                String decisao = in.next();
                if(decisao.equals("n")){
                    sair = true;
                } else {
                    break;
                }
                }   
            
            case 3 -> {
                System.out.println("////////////////////////////////");
                System.out.print("Digite o id da categoria desejada: ");
                int id = in.nextInt();
                Categoria categoria = categoriaDAO.obter(id);
                System.out.println("--------------------");
                System.out.println("| id | descricao |");
                System.out.println("| " + categoria.getId() + " | " + categoria.getDescricao() + " |");
                System.out.println("--------------------");
                System.out.println("/////////////////////////////////");
                System.out.println("Deseja fazer uma nova operacao? [y/n]: ");
                String decision = in.next();
                if(decision.equals("n")){
                    sair = true;
                } else {
                    break;
                }
                }
                
            case 4 -> {
                System.out.println("////////////////////////////////");
                System.out.print("Digite o id da categoria que voce deseja atualizar: ");
                int idd = in.nextInt();
                System.out.print("Digite a nova descricao da categoria: ");
                String descricaoo = in.next();
                if(categoriaDAO.atualizar(descricaoo, idd) == true){
                    System.out.println("Categoria atualizada com sucesso!");
                    System.out.println("Deseja fazer uma nova operacao? [y/n]: ");
                    String decisaoo = in.next();
                    if(decisaoo.equals("n")){
                        sair = true;
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Não foi possível atualizar a categoria.");
                }
                }
                
            case 5 -> {
                System.out.println("////////////////////////////////");
                System.out.print("Digite o id da categoria que voce deseja remover: ");
                int iddd = in.nextInt();
                if(categoriaDAO.remover(iddd) == true){
                    System.out.println("Categoria removida com sucesso!");
                    System.out.println("Deseja fazer uma nova operacao? [y/n]: ");
                    String decisaoo = in.next();
                    if(decisaoo.equals("n")){
                        sair = true;
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Não foi possível remover a categoria.");
                }
                }
            }
        }   
    }
}
