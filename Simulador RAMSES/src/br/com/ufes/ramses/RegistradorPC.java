package br.com.ufes.ramses;

public class RegistradorPC {
	
	byte conteudo;
	boolean cargaRegistradorPC;
	boolean incrementa;
	
	/*Construtor*/
	public RegistradorPC() {
		
	}
	
	public void carregaregistradorPC(ULA ALU){
		if(cargaRegistradorPC == true){
			this.conteudo = ALU.getSaida();
		}
	}
	public void incrementaPC(){
		if(incrementa == true){
			this.conteudo = (this.conteudo++);
		}
		
	}

	public byte getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte conteudo) {
		this.conteudo = conteudo;
	}

	public boolean isCargaRegistradorPC() {
		return cargaRegistradorPC;
	}

	public void setCargaRegistradorPC(boolean cargaRegistradorPC) {
		this.cargaRegistradorPC = cargaRegistradorPC;
	}

	public boolean isIncrementa() {
		return incrementa;
	}

	public void setIncrementa(boolean incrementa) {
		this.incrementa = incrementa;
	}
	
	//
}
