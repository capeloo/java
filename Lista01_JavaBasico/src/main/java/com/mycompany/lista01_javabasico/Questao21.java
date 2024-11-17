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
public class Questao21 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Escreva uma palavra: ");
        String palavra1 = in.nextLine();
        System.out.print("Escreva outra palavra: ");
        String palavra2 = in.nextLine();
        
        System.out.println(palavra1 + " " + palavra1.length());
        System.out.println(palavra2 + " " + palavra2.length());
       
        System.out.println(palavra1.equals(palavra2));
        
    }
}
