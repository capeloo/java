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
public class Questao12 {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        
        System.out.print("Digite uma nota entre 0 e 10: ");
        int nota = in.nextInt();
        
        while(nota < 0 || nota > 10){
            System.out.print("Valor inserido invalido, por favor, digite uma nota entre 0  e 10: ");
            nota = in.nextInt();
        }
    }
}
