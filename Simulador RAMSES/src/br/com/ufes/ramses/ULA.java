package br.com.ufes.ramses;

public class ULA {
	
	Byte entradaX, entradaY;
	Byte saida;
	String sel_alu;
	boolean n, z, c;
	
	public static void main(String[] args) {
		byte a = 4;
		byte b = 4;
		
	}
	
	/*Construtor*/
	public ULA() {
		super();
		this.entradaX = (byte)0;
		this.entradaY = (byte)0;
		this.saida = (byte)0;
		this.n = false;
		this.z = false;
		this.c = false;
	}
	
	public void CarregaEntradas(Multiplexador Mux){
		this.entradaX = Mux.getConteudo();
		this.entradaY = Mux.getConteudo2();
	}
	
	
	//TODO Observar se operacao gera Carry, zero ou negativo e setar as variaveis n, c, z 
	public void realizaOperacao(String sel_alu) {
		if(sel_alu.equals("0000")){
			this.saida = (byte) (entradaX + entradaY);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
			
		}
		if(sel_alu.equals("0001")){
			this.saida = (byte)(entradaX - entradaY);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
		}
		if(sel_alu.equals("0010")){
			this.saida = (byte)(entradaX & entradaY);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
		}
		if(sel_alu.equals("0011")){
			this.saida = (byte)(entradaY | entradaX);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
		}
		if(sel_alu.equals("0100")){
			this.saida = (byte) (~entradaX);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
		}
		if(sel_alu.equals("0101")){
			this.saida = (byte)(-entradaX);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
		}
		if(sel_alu.equals("0110")){
			this.saida = (byte) (entradaX >> 1);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
		}
		if(sel_alu.equals("0111")){
			this.saida = (byte)(entradaY);
		}
		if(sel_alu.equals("1000")){
			this.saida = this.entradaX;
		}
				
	}
	//
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


	public boolean getN() {
		return n;
	}

	public void setN(boolean n) {
		this.n = n;
	}

	public boolean getZ() {
		return z;
	}

	public void setZ(boolean z) {
		this.z = z;
	}

	public boolean getC() {
		return c;
	}

	public void setC(boolean c) {
		this.c = c;
	}
}
