package br.com.ufes.ramses;

public class Multiplexador {
	
	boolean s1, s2;
	byte conteudo;
	
	public void carregaMultiplexador(Registrador ra, Registrador rb, Registrador rx) {
		if(this.s1 == false){
			if(this.s2 == false){
				this.conteudo = ra.getConteudo();
			}else{ 
				this.conteudo = rb.getConteudo();
			}	
		}else if(this.s2==true){
				this.conteudo = rx.getConteudo();		
		}
	}
	
	public byte getConteudo() {
		return conteudo;
	}
	//

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
	
	
}
