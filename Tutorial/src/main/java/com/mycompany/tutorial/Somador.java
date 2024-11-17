/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tutorial;

/**
 *
 * @author caioc
 */

/* Classe Somador */
public class Somador {
    /* atributo contadorCalculos */
    private int contadorCalculos = 0;
    /* método somar */
    public double somar(double a, double b) {
        contadorCalculos = contadorCalculos +  1;
        return a + b;
    }
    /* método getContadorCalculos */
    public int getContadorCalculos() {
        return contadorCalculos;
    }
    /* método zerarContadorCalculos */
    public void zerarContadorCalculos(){
        contadorCalculos = 0;
    }
}
