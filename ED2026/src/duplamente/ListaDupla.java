package duplamente;

public class ListaDupla {
	private NoDupla prim;
	private NoDupla ult;
	private int quantNos;
	
	public ListaDupla(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	
	public int getQuantNos(){
		return this.quantNos;
	}
	public NoDupla getPrim(){
		return this.prim;
	}
	public NoDupla getUlt(){
		return this.ult;
	}
	
	public void setQuantNos(int valorNovo){
		this.quantNos = valorNovo;
	}
	public void setPrim(NoDupla novoNo){
		this.prim = novoNo;
	}
	public void setUlt(NoDupla novoNo){
		this.ult = novoNo;
	}
	
	public boolean eVazia (){
		return (this.prim == null);
	}
	
	//insere um novo nó no final da lista ou se a lista estiver vazia, insere
	// o primeiro nó na lista
	public void inserirUltimo (int elem){
		NoDupla novoNo = new NoDupla (elem);
		this.quantNos++;
		if (this.eVazia())
			this.prim = novoNo;
		else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
	}
	
	//retorna o endereço do nó que está contendo o valor a ser procurado.
	public NoDupla pesquisarNo (int x){
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo() != x)) {
			atual = atual.getProx();
		}
		return atual;
	}
	
	//remove um determinado nó em qualquer posição na lista.
	public boolean removerNo (int x){
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo() != x)){
			atual = atual.getProx();
		}
		if (atual == null) {
			return false;
		}else {
			if (atual == this.prim){
				this.prim = prim.getProx();
				if (this.prim == null) { //se a lista tem somente um nó
					this.ult=null;
				}else {
					this.prim.setAnt(null);//remove o primeiro
				}
			}else {
				if (atual == this.ult){ // remove o ultimo
					this.ult = this.ult.getAnt();
					this.ult.setProx(null);
				} else {
					//remove no meio da lista
					atual.getProx().setAnt(atual.getAnt());
					atual.getAnt().setProx(atual.getProx());
				}
			}
			this.quantNos--;
			return true;
		}
	}
	
	public String toString(){
		String msg="";
		NoDupla atual = this.prim;
		while (atual != null){
			msg += atual.getInfo() +"\n";
			atual = atual.getProx();
		}
		return msg;
	}
}