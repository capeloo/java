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
public class Questao23 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite o primeiro numero: ");
        int num1 = in.nextInt();
        System.out.print("Digite o segundo numero: ");
        int num2 = in.nextInt();
        System.out.print("Digite a operacao que voce deseja: [+, -, *, /] ");
        String operacao = in.next();
        
        switch(operacao){
            case "+" -> System.out.print(num1 + num2);
            case "-" -> System.out.print(num1 - num2);
            case "*" -> System.out.print(num1 * num2);
            case "/" -> System.out.print(num1 / num2);
        }
    }
}
