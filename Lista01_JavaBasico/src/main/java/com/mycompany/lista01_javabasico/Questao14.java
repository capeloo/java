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
public class Questao14 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        List<Integer> lista = new ArrayList();
        
        int cond = 0;
        while(cond != 10){
            System.out.print("Digite um numero inteiro maior que 1: ");
            int num = in.nextInt();
            while(num <= 1){
                System.out.print("Numero invalido, digite um valor maior que 1: ");
                num = in.nextInt();
            }
        
            lista.add(num);
            cond++;
        }  
        
        for(int items : lista)
            if(items == 2){
                System.out.print("[ " + items + " primo" + " ]");
            } else if(items == 3){
                System.out.print("[ "+ items + " primo" + " ]");
            } else if(items % 2 == 0){
                System.out.print("[ " + items + " nao primo" + " ]");
            } else if(items % 3 == 0){
                System.out.print("[ " + items + " nao primo" + " ]");
            } else {
                System.out.print("[ " + items + " primo" + " ]");
            }
            
    }
}
