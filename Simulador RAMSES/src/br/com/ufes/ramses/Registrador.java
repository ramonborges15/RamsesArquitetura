package br.com.ufes.ramses;

import java.nio.ByteBuffer;

public class Registrador {
	
	byte conteudo;
	boolean cargaRegistrador;
	
	
	public Registrador() {
		this.conteudo = (byte) 0;
		this.cargaRegistrador = false;
	}

	public static void main(String[] args) {
		Registrador A = new Registrador();
		A.testes();
	}
	
	private void testes() {
	
	}
	
	//Getters e Setters
	public byte getConteudo() {
		return conteudo;
	}
	public void CarregaRegistrador(ULA alu){
		if(this.cargaRegistrador == true ){
			this.conteudo = alu.getSaida();
		}
		
	}
	public void setConteudo(byte conteudo) {
		this.conteudo = conteudo;
	}
	
	public boolean isCargaRegistrador() {
		return cargaRegistrador;
	}

	public void setCargaRegistrador(boolean cargaRegistrador) {
		this.cargaRegistrador = cargaRegistrador;
	}
	
	//Conversores
	public static int bytesToInt(byte[] b) {
		int value = 0;
		for (int i = 0; i < 4; i++) {
			int shift = (4 - 1 - i) * 8;
			value += (b[i] & 0x000000FF) << shift;
		}
		return value;
	}

	@Override
	public String toString() {
		return "Registrador [conteudo =" + conteudo + "]";
	}

}
