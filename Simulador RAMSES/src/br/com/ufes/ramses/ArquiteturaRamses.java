package br.com.ufes.ramses;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArquiteturaRamses {
	
	static String nomeDoArquivo;
	ArrayList<String> microinstrucoes = new ArrayList<String>();
	
	public static void main(String[] args) {
		
	}
	
	public ArrayList<String> lerArquivo(String nome) {
		//Cria uma lista de String que será o conjunto de todas as microinstrucoes.
		
		
		try { 
			FileReader arq = new FileReader(nome); 
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine(); // lê a primeira linha 
			while (linha != null) { 
				
		//microinstrucoes.
				microinstrucoes.add(linha);
				linha = lerArq.readLine();
			}
			arq.close(); 
		
		} catch (IOException e) { 
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); 
		} System.out.println();
		
		return microinstrucoes;
	}
	
	public void carregarValor(Registrador RA,Registrador RB,Registrador RX, Registrador RAUX, Multiplexador MUX){
		// System.out.println(A.toString());
        for(int i=0;i<microinstrucoes.size();i++){
            System.out.print(microinstrucoes.size());
                char[] letras = microinstrucoes.get(i).toCharArray();
                if(letras[0] == '1'){
                	RA.setCargaRegistrador(true);
                }else 
                	RA.setCargaRegistrador(false);
                if(letras[1] == '1'){
                	RB.setCargaRegistrador(true);
                }else 
                	RB.setCargaRegistrador(false);
                if(letras[2] == '1'){
                	RX.setCargaRegistrador(true);
                }else 
                	RX.setCargaRegistrador(false);
                if(letras[3] == '1'){
                	RAUX.setCargaRegistrador(true);
                }else 
                	RAUX.setCargaRegistrador(false);
                if(letras[4] == '1'){
                	MUX.setS1(true);
                }else 
                	MUX.setS1(false);
                if(letras[5] == '1'){
                	MUX.setS2(true);
                }else 
                	MUX.setS2(false);;
                if(letras[6] == '1'){
                	MUX.setS3(true);
                }else 
                	MUX.setS3(false);
                if(letras[7] == '1'){
                	MUX.setS4(true);
                }else 
                	MUX.setS4(false);
        }

	}
		
}
	

