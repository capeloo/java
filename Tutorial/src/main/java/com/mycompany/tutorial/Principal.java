/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tutorial;

/**
 *
 * @author caioc
 */

/* classe Principal que possui o método main e que usa dois 
objetos do tipo Somador */
public class Principal {
    public static void main(String[] agrs) {
        Somador s1 = new Somador(); // objeto s1 do tipo Somador
        Somador s2 = new Somador(); // objeto s2 do tipo Somador
        
        System.out.println(s1.somar(2, 3)); // imprime 5.0
        System.out.println(s2.somar(3, 2)); // imprime 5.0
        System.out.println(s1.somar(4, 3)); // imprime 7.0
        
        System.out.println(s2.getContadorCalculos());
        System.out.println(s1.getContadorCalculos());
    }
}
