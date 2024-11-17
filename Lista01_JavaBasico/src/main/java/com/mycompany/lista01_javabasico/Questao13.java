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
public class Questao13 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int candidato1 = 0;
        int candidato2 = 0;
        int candidato3 = 0;
        
        System.out.print("Digite o numero total de eleitores: ");
        int[] totEleitores = new int[in.nextInt()];
        
        for(int voto : totEleitores){
            System.out.print("Qual candidato voce deseja votar? [1, 2, 3]: ");
            voto = in.nextInt();
            
            switch (voto) {
                case 1 -> candidato1++;
                case 2 -> candidato2++;
                case 3 -> candidato3++;
                default -> {
                }
            }  
        }
        
        System.out.println("Candidato 1 recebeu: " + candidato1 + " votos");
        System.out.println("Candidato 1 recebeu: " + candidato2 + " votos");
        System.out.println("Candidato 1 recebeu: " + candidato3 + " votos");
    }
}
