/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tutorial;

import java.util.Scanner;

/**
 *
 * @author caioc
 */
public class SystemIn_Scanner {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite o nome: ");
        String nome  = in.nextLine();
        
        System.out.print("Digite a idade: ");
        int idade = in.nextInt();
        
        System.out.print("Digite a altura: ");
        float altura = in.nextFloat();
        
        /* processamento dos dados recebidos */
        in.close();
        
        System.out.println(nome + " " + idade + " " + altura);
    }
}
