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
	static int contadorDeMemoria = 0;
	
	public Memoria(Registrador rdm, Registrador rem) {
		//Seta todas a posições da memoria para 0.
		int i = 256;
		while(i > 0) {
			dados[i-1] = (byte)0;
			i--;
		}
		this.rdm = rdm;
		this.rem = rem;
	}
	
	public  byte getRemConteudo() {
		return rem.getConteudo();
	}
	
	public  byte getRdmConteudo() {
		return rdm.getConteudo();
	}
	
	public  void setDados(int i, byte valor) {
		dados[i] = valor;
	}
	
	public byte[] getDados() {
		return this.dados;
	}
	
	
	public  void acessoAMemoria(){
		if(write == true || read == true){
			contadorDeMemoria++;
		}
	}
	
	public void escrita() {
		if(write == true){
		dados[rem.getConteudo()] = rdm.getConteudo();
		}
	}
	
	public void leitura() {
		if(read == true){
		this.rdm.setConteudo(dados[rem.getConteudo()]);
		System.out.println("HAO="+ rdm.getConteudo());
		}
	}
	
	public int getContadorMem() {
		return contadorDeMemoria;
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
