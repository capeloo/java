/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista01_javabasico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author caioc
 */
public class Questao18 {
    public static void main(String[] args){
         Scanner in = new Scanner(System.in);
        
        List<Integer> lista = new ArrayList();
        
        
        int i = 0;
        while(i < 5){
             System.out.print("Digite um numero: ");
            int num = in.nextInt();
            lista.add(num);   
            i++;
        } 
        
        Collections.reverse(lista);
        
        for(int items : lista)
            System.out.print("[ " + items + " ]");
    }
}
