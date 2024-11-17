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
public class Questao04 {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("//////////////// Conversor de metros para centimetros ///////////////");
        System.out.print("Digite um numero em metros: ");
        float numeroM = in.nextFloat();
        float numConvertido = conversor(numeroM);
        System.out.println(numeroM + " metros em centimetros sao " + numConvertido + " centimetros.");
        System.out.print("/////////////////////////////////////////////////////////////////////");
        
    }
    
    public static float conversor(float n){
        float res = n*100;
        return res;
    }
}
