/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista01_javabasico;

import java.util.Scanner;

/**
 *
 * @author caioc
 */
public class Questao06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite o preco do primeiro produto: ");
        float produto1 = in.nextFloat();
        System.out.print("Digite o preco do segundo produto: ");
        float produto2 = in.nextFloat();
        System.out.print("Digite o preco do terceiro produto: ");
        float produto3 = in.nextFloat();
        
        String produto = calculaMenorValor(produto1, produto2, produto3);
        // não leva em conta se os produtos tiverem valores iguais
        
        System.out.println("O produto que voce deve comprar e o " + produto);
    }
    
    public static String calculaMenorValor(float prod1, float prod2, float prod3){
        String res;
        float num;
        
        if(prod1 < prod2) {
            num = prod1;
            res = "produto 1";
        } else {
            num = prod2;
            res = "produto 2";
        }
        
        if(num > prod3){
            num = prod3;
            res = "produto 3";
        }
        
        return res;
    }
}
