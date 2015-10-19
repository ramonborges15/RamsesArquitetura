package br.com.ufes.ramses;
/*	
	*****Decisoes de Projeto****
	 1) carga RDM é responsavel por carregar para RDM o valor da alu.
	 2) O read é responsavel por carregar para RDM o valor lido da memoria.
*/
public class Memoria {
	
	Registrador rdm;
	Registrador rem;
	boolean read, write;
	byte[] dados = new byte[256];
	static Integer contadorDeMemoria = 0;
	//TODO Pensar em uma maneira de receber dados de entrada e alocar na memoria.
	
	public Memoria(Registrador rdm, Registrador rem) {
		//Seta todas a posições da memoria para 0.
		int i = 256;
		while(i > 0) {
			dados[i-1] = (byte)0;
		}
		
		this.rdm = rdm;
		this.rem = rem;
	}
	//
	public  void acessoAMemoria(){
		if(write == true || read == true){
			contadorDeMemoria++;
		}
	}
	
	public void escrita() {
		if(write == true){
		dados[rem.conteudo] = rdm.conteudo;
		}
	}
	
	public void leitura() {
		if(read == true){
		rdm.conteudo = dados[rem.conteudo];
		}
	}
	
		
	public boolean getRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean getWrite() {
		return write;
	}

	public void setWrite(boolean write) {
		this.write = write;
	}

}
