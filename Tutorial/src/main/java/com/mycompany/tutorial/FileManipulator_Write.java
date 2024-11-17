/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tutorial;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author caioc
 */
public class FileManipulator_Write {
    
    public static void main(String[] args) throws IOException{
        // FileWriter e BufferedWriter, manipulam o arquivo em formato de texto
        FileWriter fw = new FileWriter("C:/Users/caioc/Desktop/arq.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write("Olá Mundo");
        bw.newLine();
        bw.close();
        fw.close();
    }
}
