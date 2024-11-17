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
public class Questao20 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        List<Integer> lista = new ArrayList();
        List<Integer> pares = new ArrayList();
        List<Integer> impares = new ArrayList();
        
        int i = 0;
        while(i < 20){
            System.out.print("Digite um numero: ");
            int num = in.nextInt();
            lista.add(num);
            
            if(num%2 == 0){
                pares.add(num);
            } else {
                impares.add(num);
            }
            
            i++;
        }
        
        for(int item : lista){
            System.out.println(item + ", ");
        }
        
        for(int item : pares){
            System.out.println("[ " + item + " ]");
        }
        
        for(int item : impares){
            System.out.print(item + ", ");
        }
        
    }
}
