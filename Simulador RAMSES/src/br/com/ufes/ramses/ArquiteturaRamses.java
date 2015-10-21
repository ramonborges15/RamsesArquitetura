package br.com.ufes.ramses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquiteturaRamses {
	
	static int contadorDeTempo = 0;
	static String nomeDoArquivo;
	static int k=1;
	boolean fim;
	public void lerArquivo(ArrayList<String> microinstrucoes, String nome) {
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
		
	}
	
	public void carregaDadosMem(Memoria mem, String nome, Registrador ra, Registrador rb, Registrador rx, RegistradorPC pc) {
		//Cria uma lista de String que será o conjunto de todas as microinstrucoes.
		try { 
			int i = 0;
			FileReader arq = new FileReader(nome); 
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine(); // lê a primeira linha 
			ra.setConteudo(Byte.parseByte(linha));
			linha = lerArq.readLine();
			rb.setConteudo(Byte.parseByte(linha));
			linha = lerArq.readLine();
			rx.setConteudo(Byte.parseByte(linha));
			linha = lerArq.readLine();
			pc.setConteudo(Byte.parseByte(linha));
			
			while (linha != null) { 
				mem.setDados(i, (byte)Integer.parseInt(linha));
				linha = lerArq.readLine();
				i++;
			}
			arq.close();
		
		} catch (IOException e) { 
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); 
		} System.out.println();
		
	}
	
	public int getContCiclos() {
		return contadorDeTempo;
	}
	
	public boolean getFim() {
		return fim;
	}
	
	public void carregarValor(int indice,ArrayList<String> microinstrucoes, Registrador RA,Registrador RB,Registrador RX, Registrador RAUX, Multiplexador MUX,
			RegistradorEstados Estado, RegistradorPC PC, Registrador RI, Memoria Mem, ULA ALU, RegistradorEstados RE){
        
		for(int i = indice; i < microinstrucoes.size(); i++){
			char[] letras = microinstrucoes.get(i).toCharArray();
			if(letras.length <= 21  ){
				System.out.println("QUantidades de bits erradas");
					break;
			}
				
			if (letras[0] == '1') {
				RA.setCargaRegistrador(true);
			} else
				RA.setCargaRegistrador(false);
			if (letras[1] == '1') {
				RB.setCargaRegistrador(true);
			} else
				RB.setCargaRegistrador(false);
			if (letras[2] == '1') {
				RX.setCargaRegistrador(true);
			} else
				RX.setCargaRegistrador(false);
			if (letras[3] == '1') {
				RAUX.setCargaRegistrador(true);
			} else
				RAUX.setCargaRegistrador(false);
			if (letras[4] == '1') {
				MUX.setS1(true);
			} else
				MUX.setS1(false);
			if (letras[5] == '1') {
				MUX.setS2(true);
			} else
				MUX.setS2(false);
			;
			if (letras[6] == '1') {
				MUX.setS3(true);
			} else
				MUX.setS3(false);
			if (letras[7] == '1') {
				MUX.setS4(true);
			} else
				MUX.setS4(false);
			if (letras[12] == '1') {
				Estado.setCarga_N(true);
			} else
				Estado.setCarga_N(false);
			if (letras[13] == '1') {
				Estado.setCarga_Z(true);
			} else
				Estado.setCarga_Z(false);
			if (letras[14] == '1') {
				Estado.setCarga_C(true);
			} else
				Estado.setCarga_C(false);
			if (letras[15] == '1') {
				PC.setIncrementa(true);
			} else
				PC.setIncrementa(false);
			if (letras[16] == '1') {
				PC.setCargaRegistradorPC(true);
			} else
				PC.setCargaRegistradorPC(false);
			if (letras[17] == '1') {
				RI.setCargaRegistrador(true);
			} else
				RI.setCargaRegistrador(false);
			if (letras[18] == '1') {
				Mem.rem.setCargaRegistrador(true);
			} else
				Mem.rem.setCargaRegistrador(false);
			if (letras[19] == '1') {
				Mem.setRead(true);
			} else
				Mem.setRead(false);
			if (letras[20] == '1') {
				Mem.setWrite(true);
			} else
				Mem.setWrite(false);
			if (letras[21] == '1') {
				Mem.rdm.setCargaRegistrador(true);
			} else
				Mem.rdm.setCargaRegistrador(false);
			
			// Construção da seleção ALU

			StringBuilder sb = new StringBuilder();
			sb.append(letras[8]);
			sb.append(letras[9]);
			sb.append(letras[10]);
			sb.append(letras[11]);
			
			
			// Carrega as intruções
			MUX.carregaMultiplexador1(RA, RB, RX, ALU);
			MUX.carregaMultiplexador2(RAUX, PC, Mem.rdm, ALU);
			//ALU.CarregaEntradas(MUX);
			ALU.realizaOperacao(sb.toString(), MUX);
			RA.CarregaRegistrador(ALU);
			RB.CarregaRegistrador(ALU);
			RX.CarregaRegistrador(ALU);
			PC.carregaregistradorPC(ALU);
			PC.incrementaPC();
			RE.CarregaBitEstado(ALU);
			RAUX.CarregaRegistrador(ALU);
			Mem.rdm.CarregaRegistrador(ALU);
			Mem.rem.CarregaRegistrador(ALU);
			Mem.leitura();
			Mem.escrita();
			
			System.out.println(" ");
			System.out.println("Intrucoes " + "t"+k);
			k++;
			System.out.println(PC.getConteudo());
			System.out.println("selecao=> " + sb);
			System.out.println(MUX.s3 + " s3 " + MUX.s4 + " s4");
			System.out.println("ConteudoRdm=>" + Mem.getRdmConteudo());
			System.out.println("ConteudoY=>" + ALU.getEntradaY());
			System.out.println("ConteudoALU=>" + ALU.getSaida());
			// para fazer as estatisticas
			Mem.acessoAMemoria();
			contadorDeTempo++;

			// if(//bot�o de estado){
			// MUX.carregaMultiplexador1(ra, rb, rx);
			//imprimeParcial(RA, RB, RX,PC);
			//System.out.println(MUX.);
			//System.out.println(MUX.getConteudo());
			// }
        }

	}
	
	public void carregarValorpp(int indice, ArrayList<String> microinstrucoes, Registrador RA,Registrador RB,Registrador RX, Registrador RAUX, Multiplexador MUX,
			RegistradorEstados Estado, RegistradorPC PC, Registrador RI, Memoria Mem, ULA ALU, RegistradorEstados RE){
        
		fim = false;
		if (indice == microinstrucoes.size() - 1)
			fim = true;

		char[] letras = microinstrucoes.get(indice).toCharArray();
		if (letras[0] == '1') {
			RA.setCargaRegistrador(true);
		} else
			RA.setCargaRegistrador(false);
		if (letras[1] == '1') {
			RB.setCargaRegistrador(true);
		} else
			RB.setCargaRegistrador(false);
		if (letras[2] == '1') {
			RX.setCargaRegistrador(true);
		} else
			RX.setCargaRegistrador(false);
		if (letras[3] == '1') {
			RAUX.setCargaRegistrador(true);
		} else
			RAUX.setCargaRegistrador(false);
		if (letras[4] == '1') {
			MUX.setS1(true);
		} else
			MUX.setS1(false);
		if (letras[5] == '1') {
			MUX.setS2(true);
		} else
			MUX.setS2(false);
		;
		if (letras[6] == '1') {
			MUX.setS3(true);
		} else
			MUX.setS3(false);
		if (letras[7] == '1') {
			MUX.setS4(true);
		} else
			MUX.setS4(false);
		if (letras[12] == '1') {
			Estado.setCarga_N(true);
		} else
			Estado.setCarga_N(false);
		if (letras[13] == '1') {
			Estado.setCarga_Z(true);
		} else
			Estado.setCarga_Z(false);
		if (letras[14] == '1') {
			Estado.setCarga_C(true);
		} else
			Estado.setCarga_C(false);
		if (letras[15] == '1') {
			PC.setIncrementa(true);
		} else
			PC.setIncrementa(false);
		if (letras[16] == '1') {
			PC.setCargaRegistradorPC(true);
		} else
			PC.setCargaRegistradorPC(false);
		if (letras[17] == '1') {
			RI.setCargaRegistrador(true);
		} else
			RI.setCargaRegistrador(false);
		if (letras[18] == '1') {
			Mem.rem.setCargaRegistrador(true);
		} else
			Mem.rem.setCargaRegistrador(false);
		if (letras[19] == '1') {
			Mem.setRead(true);
		} else
			Mem.setRead(false);
		if (letras[20] == '1') {
			Mem.setWrite(true);
		} else
			Mem.setWrite(false);
		if (letras[21] == '1') {
			Mem.rdm.setCargaRegistrador(true);
		} else
			Mem.rdm.setCargaRegistrador(false);

		// Construção da seleção ALU

		StringBuilder sb = new StringBuilder();
		sb.append(letras[8]);
		sb.append(letras[9]);
		sb.append(letras[10]);
		sb.append(letras[11]);

		// Carrega as intruções
		MUX.carregaMultiplexador1(RA, RB, RX, ALU);
		MUX.carregaMultiplexador2(RAUX, PC, Mem.rdm, ALU);
		// ALU.CarregaEntradas(MUX);
		ALU.realizaOperacao(sb.toString(), MUX);
		RA.CarregaRegistrador(ALU);
		RB.CarregaRegistrador(ALU);
		RX.CarregaRegistrador(ALU);
		PC.carregaregistradorPC(ALU);
		PC.incrementaPC();
		RE.CarregaBitEstado(ALU);
		RAUX.CarregaRegistrador(ALU);
		Mem.rdm.CarregaRegistrador(ALU);
		Mem.rem.CarregaRegistrador(ALU);
		Mem.leitura();
		Mem.escrita();

		System.out.println(" ");
		System.out.println("Intrucoes " + "t" + k);
		k++;
		System.out.println(PC.getConteudo());
		System.out.println("selecao=> " + sb);
		System.out.println(MUX.s3 + " s3 " + MUX.s4 + " s4");
		System.out.println("ConteudoRdm=>" + Mem.getRdmConteudo());
		System.out.println("ConteudoY=>" + ALU.getEntradaY());
		System.out.println("ConteudoALU=>" + ALU.getSaida());
		// para fazer as estatisticas
		Mem.acessoAMemoria();
		contadorDeTempo++;

	}
}