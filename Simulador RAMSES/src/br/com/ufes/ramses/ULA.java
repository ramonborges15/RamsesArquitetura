package br.com.ufes.ramses;

public class ULA {
	
	byte entradaX, entradaY;
	byte saida;
	String sel_alu;
	boolean n, z, c;
	static int contadorOperacoes = 0;
	
	/*Construtor*/
	public ULA() {
		//super();
		this.entradaX = 0;
		this.entradaY = 0;
		this.saida = 0;
		this.n = false;
		this.z = false;
		this.c = false;
	}
	
	//TODO Observar se operacao gera Carry, zero ou negativo e setar as variaveis n, c, z 
	public void realizaOperacao(String sel_alu, Multiplexador m) {
		setEntradaX(m.getSaida());
		setEntradaY(m.getSaida2());
		System.out.println("SelecaoALU>> " + sel_alu);
		if(sel_alu.equals("0000")){
			contadorOperacoes++;
			this.saida = (byte) (entradaX + entradaY);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
			
		}
		if(sel_alu.equals("0001")){
			contadorOperacoes++;
			this.saida = (byte)(entradaX - entradaY);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
		}
		if(sel_alu.equals("0010")){
			contadorOperacoes++;
			this.saida = (byte)(entradaX & entradaY);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
		}
		if(sel_alu.equals("0011")){
			contadorOperacoes++;
			this.saida = (byte)(entradaY | entradaX);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
		}
		if(sel_alu.equals("0100")){
			contadorOperacoes++;
			this.saida = (byte) (~entradaX);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
		}
		if(sel_alu.equals("0101")){
			contadorOperacoes++;
			this.saida = (byte)(-entradaX);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
		}
		if(sel_alu.equals("0110")){
			contadorOperacoes++;
			this.saida = (byte) (entradaX >> 1);
			if(this.saida == (byte)0  ){
				this.z = true;
			}
			if(this.saida < (byte) 0 ){
				this.n = true;
			}
		}
		if(sel_alu.equals("0111")){
			contadorOperacoes++;
			setSaida(entradaY);
			System.out.println("Olha ele hein...Olha ele");
		}
		if(sel_alu.equals("1000")){
			this.saida = this.entradaX;
		}
		
		if(entradaX > 0 && entradaY > 0 && saida < 0) {
			c = true;
		}
				
	}
	//
	//Getters e Setters
	public int getContadorOp() {
		return contadorOperacoes;
	}
	
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
