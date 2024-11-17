/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tutorial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author caioc
 */
public class FileManipulator_Read {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // FileReader e BufferedReader
        FileReader fr = new FileReader("C:/Users/caioc/Desktop/arq.txt");
        BufferedReader br = new BufferedReader(fr);
        
        while (br.ready()) {
            System.out.println(br.readLine());
        }
        
        br.close();
        fr.close();
    }
}
