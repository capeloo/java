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
public class Questao22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite um numero inteiro: ");
        int numero = in.nextInt();
        
        int reverso = 0;
   
        while (numero != 0) {
            int digito = numero % 10;
            reverso = reverso * 10 + digito; 
            numero /= 10; 
        }

        System.out.println("O reverso do numero e: " + reverso);
        
        in.close();
    }
}
