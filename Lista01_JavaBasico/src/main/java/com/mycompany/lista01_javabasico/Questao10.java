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
public class Questao10 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite um numero para saber se ele e par ou impar: ");
        int num = in.nextInt();
        
        if(num%2 == 0){
            System.out.print(num + " e um numero par.");
        } else {
            System.out.print(num + " e um numero impar.");
        }
    }
}
