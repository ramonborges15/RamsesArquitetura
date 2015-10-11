package br.com.ufes.ramses;

public class ULA {
	
	byte entradaX, entradaY;
	byte saida;
	byte sel_alu;
	byte n, z, c;
	
	/*Construtor*/
	public ULA() {
		
	}
	
	//Getters e Setters
	public byte getEntradaX() {
		return entradaX;
	}

	public void setEntradaX(byte entradaX) {
		this.entradaX = entradaX;
	}

	public byte getEntradaY() {
		return entradaY;
	}

	public void setEntradaY(byte entradaY) {
		this.entradaY = entradaY;
	}

	public byte getSaida() {
		return saida;
	}

	public void setSaida(byte saida) {
		this.saida = saida;
	}

	public byte getSel_alu() {
		return sel_alu;
	}

	public void setSel_alu(byte sel_alu) {
		this.sel_alu = sel_alu;
	}

	public byte getN() {
		return n;
	}

	public void setN(byte n) {
		this.n = n;
	}

	public byte getZ() {
		return z;
	}

	public void setZ(byte z) {
		this.z = z;
	}

	public byte getC() {
		return c;
	}

	public void setC(byte c) {
		this.c = c;
	}
}
