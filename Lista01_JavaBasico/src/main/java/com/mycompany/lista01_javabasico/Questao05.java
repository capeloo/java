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
public class Questao05 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("//////////////// Calculadora de area de um circulo ////////////////");
        System.out.print("Digite o raio do circulo: ");
        float raio = in.nextFloat();
        double area = calcularArea(raio);
        System.out.println("A area do circulo e " + area);
        System.out.print("///////////////////////////////////////////////////////////////////");
    }
    
    public static double calcularArea(float r){
        double res = Math.PI*(r*r);
        return res;
    }
}
