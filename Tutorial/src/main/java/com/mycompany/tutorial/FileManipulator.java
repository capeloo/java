package com.mycompany.tutorial;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author caioc
 */
import java.io.File;
import java.io.IOException;

public class FileManipulator {
    
    public static void main(String[] args) {
       File arquivo = new File("C:/Users/caioc/Desktop/arq.txt");
       File dir = new File("C:/Users/caioc/Desktop/dir");
       
       File arquivo2 = new File("C:/Users/caioc/Desktop/dir/arq2.txt");
       File arquivo3 = new File("C:/Users/caioc/Desktop/dir/arq3.txt");
       File dir2 = new File("C:/Users/caioc/Desktop/dir/dir2");
       
       File arquivo4 = new File("C:/Users/caioc/Desktop/arq4.txt");
       
       File[] arquivos = dir.listFiles(); // se for um diretório, lista seus arquivos e subdiretórios
       
       try { 
           arquivo.createNewFile(); // cria um arquivo vazio
           dir.mkdir();// arquivo.mkdir(); cria um diretório
           
           arquivo2.createNewFile();
           arquivo3.createNewFile();
           dir2.mkdir();
           
           arquivo4.createNewFile();
       }
       catch (IOException e) {
           e.printStackTrace();
       }
      
       arquivo4.delete(); // exclui arquivo ou diretório
       
       boolean existe = arquivo.exists();
       boolean existeDir = dir.exists();
      
       System.out.println(existe);
       System.out.println(existeDir);
       System.out.println(arquivos);
    }
}
