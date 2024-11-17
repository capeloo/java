/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista01_javabasico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author caioc
 */
public class Questao09 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite o primeiro numero: ");
        int num01 = in.nextInt();
        System.out.print("Digite o segundo numero: ");
        int num02 = in.nextInt();
        System.out.print("Digite o terceiro numero: ");
        int num03 = in.nextInt();
        
        int[] lista = {num01, num02, num03};
        int maxNum = lista[0];
        
        for(int nums :  lista){
            if(nums > maxNum) 
                maxNum = nums;
        }
        
        System.out.println("O maior numero e: " + maxNum);
        
    }
}
