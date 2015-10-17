package br.com.ufes.ramses;

public class Multiplexador {
	
	boolean s1, s2, s3, s4;
	byte conteudo, conteudo2 ;
	
	
	public Multiplexador() {
		this.s1 = false;
		this.s2 = false;
		this.s3 = false;
		this.s4 = false;
		this.conteudo = (byte) 0;
	}
	public void carregaMultiplexador1(Registrador ra, Registrador rb, Registrador rx) {
		if(this.s1 == false) {
			if(this.s2 == false) {
				this.conteudo = ra.getConteudo();
			}else { 
				this.conteudo = rb.getConteudo();
			}	
		}else if(this.s2==true){
				this.conteudo = rx.getConteudo();		
		}
	}
	// criei essa funcao para ficar mais legivel, na verdade nao prescisaria
	public void carregaMultiplexador2(Registrador raux, RegistradorPC pc, Registrador rdm) {
		if(this.s3 == false){
			if(this.s4 == false){
				this.conteudo = raux.getConteudo();
			}else{ 
				this.conteudo = pc.getConteudo();
			}	
		}else if(this.s4==true){
				this.conteudo = rdm.getConteudo();		
		}
	}
	
	public byte getConteudo() {
		return conteudo;
	}
	
	public byte getConteudo2() {
		return conteudo2;
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
