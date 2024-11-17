/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tutorial;

/**
 *
 * @author caioc
 */

/* Estrutura básica - classe Tutorial */
public class Tutorial {

/* Variáveis - atributos globais ou atributos de instância */
   public static int x;
   private static final int y = 2;
   protected static int idade = 21;

   /* Método principal de inicialização do programa */
   public static void main (String[] args){
	x = 1;
	int z = 3; // variável local (escopo local)

	/* Estrutura condicional if */
	if (idade > 0 && idade >= 18) {
	    System.out.println("Você é maior de idade!");
	} else {
	    if (idade >= 16)
		System.out.println("Você é menor de idade, mas pode votar!");
	    else 
		System.out.println("Você é menor de idade.");
	}

   	/* Estrutura condicional switch */

	int n = 1;
	
	switch (n) {
	     case 0:
		System.out.println("Zero");
		break;
	     case 2:
		System.out.println("Dois");
		break;
	     default:
		System.out.println("Não é zero e nem dois");
	}

	/* Estrutura de repetição while */
	
	while (n <= 10) {
	    n++;
	    if (n % 2 == 0)
	    System.out.println(n);
	}
	
	/* Estrutura de repetição do while */
	
	int m = 0;
	do {
	    System.out.println(m++ + "m");	
	} while (m <= 10);

	/* Estrutura de repetição for */

	for (int i = 0; i <= 10; i++) {
	    System.out.println("i" + i);
	}

	/* Vetores */
	int v[] = {10, 20, 30, 40};
	System.out.println(v);
	
	//Imprime o tamanho do vetor
	System.out.println(v.length);
	
	//Imprime o conteúdo do vetor  
	for(int i = 0;  i < v.length; i++){
		System.out.println(v[i]);
	}

	/* Estrutura de Repetição Enhanced-for */
	for(int item :  v) {
		System.out.println(item);
	}
		
	/* Saída padrão */
	System.out.println("Meu primeiro programa em Java.");
	System.out.println("Resultado = " + (x + y + z));
   }
}
