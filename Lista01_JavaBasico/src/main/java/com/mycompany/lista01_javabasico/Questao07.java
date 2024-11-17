/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista01_javabasico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author caioc
 */
public class Questao07 {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<Float> notas = new ArrayList();
      
        String decisao = "y";
        while(decisao.equals("y")){
            System.out.print("Digite uma nota: ");
            float nota = in.nextFloat();
            notas.add(nota);
            System.out.print("Deseja continuar? y/n: ");
            String res = in.next();
            
            if(res.equals("n")){
                decisao = res;
            }
        }
        
        float media = fazerMedia(notas);
        
        System.out.println("Sua média é: " + media); 
        
    }
    
    public static float fazerMedia(List<Float> list){
        float res = 0;
        float soma = 0;
        for (Float notas : list) {
            soma += notas;
            res = (soma)/list.size();
        }
        return res;
    }
}
