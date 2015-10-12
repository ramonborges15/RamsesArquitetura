package br.com.ufes.ramses;

public class ULA {
	
	byte entradaX, entradaY;
	byte saida;
	byte sel_alu;
	byte n, z, c;
	
	public static void main(String[] args) {
		
	}
	
	/*Construtor*/
	public ULA() {
		
	}
	
	public void CargaEntradas(Multiplexador M1, Multiplexador M2){
		this.entradaX = M1.getConteudo();
		this.entradaY = M2.getConteudo();
	}
	
	public byte realizaOperacao() {
		if(sel_alu == (byte) 0){
			this.saida = this.entradaX;
		}
		if(sel_alu == (byte)1){
			this.saida = (byte)(entradaX + entradaY);
		}
		if(sel_alu == (byte)2){
			this.saida = (byte)(entradaX - entradaY);
		}
		if(sel_alu == (byte)3){
			this.saida = (byte)(entradaX & entradaY);
		}
		if(sel_alu == (byte)4){
			this.saida = (byte)(entradaY | entradaX);
		}
		if(sel_alu == (byte)5){
			//this.saida = (byte)(!entradaX);
		}
		if(sel_alu == (byte)6){
			this.saida = (byte) (~entradaX);
		}
		if(sel_alu == (byte)7){
			
		}
		if(sel_alu == (byte)8){
			this.saida = (byte)(entradaY);
		}
				
		return 0;
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
