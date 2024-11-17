/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista01_javabasico;

/**
 *
 * @author caioc
 */
public class Questao15 {
        public static void main(String[] args) {
        int n = 10;
        int a = 0, b = 1;

        System.out.print("Sequência de Fibonacci até " + n + " termos: ");

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");

            int temp = a;
            a = b;
            b = temp + b;
        }
    }
}
