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

	public void imprimeParcial(Registrador RA,Registrador RB,Registrador RX, RegistradorPC PC){
		
		System.out.println(RA.toString());
		System.out.println(RB.toString());
		System.out.println(RX.toString());
		System.out.println(PC.toString());
	}
	
	public void carregarValor(Registrador RA,Registrador RB,Registrador RX, Registrador RAUX, Multiplexador MUX,
			RegistradorEstados Estado, RegistradorPC PC, Registrador RI, Memoria Mem, ULA ALU ){
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
                if(letras[12] == '1'){
                	Estado.setCarga_N(true);
                }else 
                	Estado.setCarga_N(false);
                if(letras[13] == '1'){
                	Estado.setCarga_Z(true);
                }else 
                	Estado.setCarga_Z(false);
                if(letras[14] == '1'){
                	Estado.setCarga_C(true);
                }else 
                	Estado.setCarga_C(false);
                if(letras[15] == '1'){
                	PC.setIncrementa(true);
                }else 
                	PC.setIncrementa(false);
                if(letras[16] == '1'){
                	PC.setCargaRegistradorPC(true);
                }else 
                	PC.setCargaRegistradorPC(false);
                if(letras[17] == '1'){
                	RI.setCargaRegistrador(true);
                }else 
                	RI.setCargaRegistrador(false);
                if(letras[18] == '1'){
                	Mem.rem.setCargaRegistrador(true); 
                }else 
                	Mem.rem.setCargaRegistrador(false);
                if(letras[19] == '1'){
                	Mem.setRead(true); 
                }else 
                	Mem.setRead(false);
                if(letras[19] == '1'){
                	Mem.setWrite(true); 
                }else 
                	Mem.setWrite(false);
                if(letras[21] == '1'){
                	Mem.rdm.setCargaRegistrador(true); 
                }else 
                	Mem.rdm.setCargaRegistrador(false);
               
                MUX.carregaMultiplexador1(RA, RB, RX); 
                MUX.carregaMultiplexador2(RAUX, PC, Mem.rdm);
                ALU.CarregaEntradas(MUX)
                RA.CarregaRegistrador(ALU);
                RB.CarregaRegistrador(ALU);
                RX.CarregaRegistrador(ALU);
                PC.carregaregistradorPC(ALU);
                PC.incrementaPC();
                RAUX.CarregaRegistrador(ALU);
                Mem.rdm.CarregaRegistrador(ALU);
                Mem.rem.CarregaRegistrador(ALU);
                
                
                
                // if(//bot�o de estado){
                //MUX.carregaMultiplexador1(ra, rb, rx);       
                imprimeParcial(RA, RB, RX,PC);        
               //       }
        }

	}
	
}
	

