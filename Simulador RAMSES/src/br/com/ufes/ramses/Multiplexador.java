package br.com.ufes.ramses;

public class Multiplexador {
	
	boolean s1, s2, s3, s4;
	byte saida, saida2 ;
	
	
	public Multiplexador() {
		this.s1 = false;
		this.s2 = false;
		this.s3 = false;
		this.s4 = false;
		this.saida = 0;
		this.saida2 = 0;
	}
	public void carregaMultiplexador1(Registrador ra, Registrador rb, Registrador rx, ULA alu) {
		if(this.s1 == false) {
			if(this.s2 == false) {
				setSaida(ra.getConteudo());
			}else { 
				setSaida(rx.getConteudo());
			}	
		}else if(this.s2==false){
				setSaida(rb.getConteudo());		
		}
	}
	// criei essa funcao para ficar mais legivel, na verdade nao prescisaria
	public void carregaMultiplexador2(Registrador raux, RegistradorPC pc, Registrador rdm, ULA alu) {
		if(this.s3 == false){
			if(this.s4 == false){
				setSaida2(raux.getConteudo());
			}else{ 
				setSaida2(rdm.getConteudo());
			}	
		}else if(this.s4==false){
				setSaida2(pc.getConteudo());		
		}
	}
	
	public void setSaida(byte saida) {
		this.saida = saida;
	}
	
	public void setSaida2(byte saida2) {
		this.saida2 = saida2;
	}
	
	public byte getSaida() {
		return saida;
	}
	
	public byte getSaida2() {
		return saida2;
	}
	
	public boolean getS1() {
		return s1;
	}

	public void setS1(boolean s1) {
		this.s1 = s1;
	}

	public boolean getS2() {
		return s2;
	}

	public void setS2(boolean s2) {
		this.s2 = s2;
	}
	public boolean getS3() {
		return s3;
	}
	public void setS3(boolean s3) {
		this.s3 = s3;
	}
	public boolean getS4() {
		return s4;
	}
	public void setS4(boolean s4) {
		this.s4 = s4;
	}
}