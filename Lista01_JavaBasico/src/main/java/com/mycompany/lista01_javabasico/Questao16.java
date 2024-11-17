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
public class Questao16 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite um numero inteiro positivo: ");
        int num = in.nextInt();
        
        if(num < 0){
            System.out.print("Por favor, digite um numero positivo.");
            num = in.nextInt();
        }
        
        int fatorial = 1;
        for(int i = 1; i <= num; i++){
            fatorial *= i;
        }
        
         System.out.println("O fatorial de " + num + " e " + fatorial);
    }
}

