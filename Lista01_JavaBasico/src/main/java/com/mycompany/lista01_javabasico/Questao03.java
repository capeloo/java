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
public class Questao03 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("/////////// Media Aritmetica ////////////");
        System.out.print("Digite a primeira nota: ");
        float nota1 = in.nextFloat();
        System.out.print("Digite a segunda nota: ");
        float nota2 = in.nextFloat();
        System.out.print("Digite a terceira nota: ");
        float nota3 = in.nextFloat();
        Float media = fazerMedia(nota1, nota2, nota3);
        System.out.println("A media aritmetica e: " + media);
        System.out.println("////////////////////////////////////////");
    }
    
    public static Float fazerMedia(Float n1, Float n2, Float n3){
        Float res = (n1 + n2 + n3)/3;
        return res;
    }
}
