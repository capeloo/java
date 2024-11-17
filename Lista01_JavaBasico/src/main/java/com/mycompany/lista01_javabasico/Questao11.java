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
public class Questao11 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite um numero entre 0 e 10: ");
        int num = in.nextInt();
        
        if(num < 0 || num > 10){
            System.out.print("Por favor, digite um numero valido entre 0 e 10: ");
            num = in.nextInt();
        }
        
        int[] lista = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        for(int i : lista)
            System.out.println(num + " * " + i + " = " + num * i);
    }
}
