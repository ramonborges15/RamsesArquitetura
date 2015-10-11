package br.com.ufes.ramses;

import java.nio.ByteBuffer;

public class Registrador {
	
	byte conteudo;

	boolean cargaRegistrador;
	
	
	public static void main(String[] args) {
		Registrador A = new Registrador();
		A.testes();
	}
	
	private void testes() {
		int i = 1;
		int j = 3;
		byte bin = (byte) i; 
		byte bin2 = (byte) j; 
	
		byte c = (byte) (~bin);
		System.out.print(c);
		byte h = (byte)21;
		System.out.print(h);
		
		//System.out.print(f);
	}
	//Construtor
	public Registrador() {
	
	}
	
	//Getters e Setters
	public byte getConteudo() {
		return conteudo;
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

}
