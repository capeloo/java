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
public class Questao08 {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite a primeira nota: ");
        float nota01 = in.nextFloat();
        System.out.print("Digite a segunda nota: ");
        float nota02 = in.nextFloat();
        
        float media = (nota01 + nota02)/2;
        String situacao = "";
        
        if(media >= 7) {
            situacao = "Voce esta aprovado.";
            System.out.println(situacao);
        } else if (media >= 4 && media < 7) {
            situacao = "AF";
            System.out.println("voce esta de " + situacao + ".");
            System.out.print("Digite a nota da AF: ");
            float notaAF = in.nextFloat();
            if(notaAF >= 4) {
                situacao = "Voce esta aprovado.";
                System.out.println(situacao);
            } else if((media + notaAF)/2 >= 5) {
                situacao = "aprovado";
                System.out.println(situacao);
            } else {
                situacao = "reprovado";
                System.out.println(situacao);
            }
        } else {
            situacao = "reprovado";
            System.out.println(situacao);
        }       
    }
}
