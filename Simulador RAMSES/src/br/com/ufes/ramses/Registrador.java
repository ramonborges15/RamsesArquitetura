package br.com.ufes.ramses;


public class Registrador {
	
	byte conteudo;
	boolean cargaRegistrador;
	
	
	public Registrador() {
		this.conteudo =  0;
		this.cargaRegistrador = false;
	}

	//Getters e Setters
	public byte getConteudo() {
		return conteudo;
	}
	public void CarregaRegistrador(ULA alu){
		if(this.cargaRegistrador == true ){
			this.conteudo = alu.getSaida();
		}
		
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
}
