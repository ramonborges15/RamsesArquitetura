package br.com.ufes.ramses;

public class Multiplexador {
	
	boolean s1, s2, s3, s4;
	byte conteudo;
	
	public void carregaMultiplexador1(Registrador ra, Registrador rb, Registrador rx) {
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
	// criei essa fução para ficar mais legivel, na verdade não prescisaria
	public void carregaMultiplexador2(Registrador raux, Registrador pc, Registrador rdm) {
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
