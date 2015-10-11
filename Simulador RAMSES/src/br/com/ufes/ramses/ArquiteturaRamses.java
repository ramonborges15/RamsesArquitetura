package br.com.ufes.ramses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ArquiteturaRamses {
	
	static String nomeDoArquivo;
	
	public static void main(String[] args) {
				
		try { 
			FileReader arq = new FileReader(nomeDoArquivo); 
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha = lerArq.readLine(); // lê a primeira linha 
			while (linha != null) { 
				//TODO Instanciar as funções dos componentes
				
				
				linha = lerArq.readLine(); 
			} 
			arq.close(); 
			} catch (IOException e) { 
				System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); 
			} System.out.println();
		}
}
