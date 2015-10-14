package br.com.ufes.ramses;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArquiteturaRamses {
	
	static String nomeDoArquivo;
	
	public static void main(String[] args) {
		
	}
	
	public ArrayList<String> lerArquivo(String nome) {
		//Cria uma lista de String que será o conjunto de todas as microinstrucoes.
		ArrayList<String> microinstrucoes = new ArrayList<String>();
		
		try { 
			FileReader arq = new FileReader(nome); 
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine(); // lê a primeira linha 
			while (linha != null) { 
				
				microinstrucoes.add(linha);
				linha = lerArq.readLine(); 
			} while(linha != null)
			arq.close(); 
		
		} catch (IOException e) { 
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); 
		} System.out.println();
		
		return microinstrucoes;
	}
}
