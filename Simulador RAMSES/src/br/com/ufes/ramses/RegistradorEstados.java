package br.com.ufes.ramses;

public class RegistradorEstados {
	
	boolean carga_N,carga_Z,carga_C; //byte cargaRegistrador;
	byte conteudo;
	
	/*Construtor*/
	public RegistradorEstados() {

	}

	public boolean getCarga_N() {
		return carga_N;
	}

	public void setCarga_N(boolean carga_N) {
		this.carga_N = carga_N;
	}

	public boolean getCarga_Z() {
		return carga_Z;
	}

	public void setCarga_Z(boolean carga_Z) {
		this.carga_Z = carga_Z;
	}

	public boolean getCarga_C() {
		return carga_C;
	}

	public void setCarga_C(boolean carga_C) {
		this.carga_C = carga_C;
	}
	
}
