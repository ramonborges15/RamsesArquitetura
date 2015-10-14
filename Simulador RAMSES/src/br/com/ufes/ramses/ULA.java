package br.com.ufes.ramses;

public class ULA {
	
	Byte entradaX, entradaY;
	Byte saida;
	Byte sel_alu;
	Byte n, z, c;
	
	public static void main(String[] args) {
		Byte a = 4;
		System.out.println(a>>1);
	}
	
	/*Construtor*/
	public ULA() {
		
	}
	
	public void CargaEntradas(Multiplexador M1, Multiplexador M2){
		this.entradaX = M1.getConteudo();
		this.entradaY = M2.getConteudo();
	}
	
	//TODO Observar se operacao gera Carry, zero ou negativo e setar as variaveis n, c, z 
	public Byte realizaOperacao() {
		if(sel_alu.intValue() == 0){
			this.saida = (byte) (entradaX + entradaY);
		}
		if(sel_alu.intValue() == 1){
			this.saida = (byte)(entradaX - entradaY);
		}
		if(sel_alu.intValue() == 2){
			this.saida = (byte)(entradaX & entradaY);
		}
		if(sel_alu.intValue() == 3){
			this.saida = (byte)(entradaY | entradaX);
		}
		if(sel_alu.intValue() == 4){
			//TODO fazer not.
		}
		if(sel_alu.intValue() == 5){
			this.saida = (byte) (~entradaX);
		}
		if(sel_alu.intValue() == 6){
			this.saida = (byte) (entradaX >> 1);
		}
		if(sel_alu.intValue() == 7){
			this.saida = (byte)(entradaY);
		}
		if(sel_alu == (byte)8){
			this.saida = this.entradaX;
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
