package br.com.ufes.view;

import java.awt.EventQueue;
import java.util.ArrayList;

import br.com.ufes.ramses.ArquiteturaRamses;
import br.com.ufes.ramses.Memoria;
import br.com.ufes.ramses.Multiplexador;
import br.com.ufes.ramses.Registrador;
import br.com.ufes.ramses.RegistradorEstados;
import br.com.ufes.ramses.RegistradorPC;
import br.com.ufes.ramses.ULA;

public class Principal {
	
	
	public static void main(String[] args) {
		
		ArrayList<String> microinstrucoes = new ArrayList<String>();
		
		Registrador rdm = new Registrador();
		Registrador rem = new Registrador();
		Registrador ri = new Registrador();
		Registrador ra = new Registrador();
		Registrador rb = new Registrador();
		Registrador rx = new Registrador();
		Registrador raux = new Registrador();
		RegistradorEstados estados = new RegistradorEstados();
		RegistradorPC pc = new RegistradorPC();
		Multiplexador mux = new Multiplexador();
		ULA unidadeAritmetica = new ULA();
		Memoria mem = new Memoria(rdm, rem);
		ArquiteturaRamses ramses = new ArquiteturaRamses();
		
		//ramses.lerArquivo(microinstrucoes, window.textNomeDoArquivo.getText());
		ramses.carregarValor(microinstrucoes, ra, rb, rx, raux, mux, estados, pc, ri, mem, unidadeAritmetica);
			
	}
	

}
