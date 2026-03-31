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
	
	//atv 05 - 1
	public void concatenarListas(ListaDupla l2) {
		if (this.eVazia() && !l2.eVazia()) {
			this.prim = l2.getPrim();
			this.ult = l2.getUlt();
			this.quantNos = l2.quantNos;
			
		} else {
			this.ult.setProx(l2.prim);
			l2.prim.setAnt(this.ult); 	// ponteiro apontando pra trás
			this.ult = l2.ult;
			this.quantNos += l2.quantNos;
		}
		l2.prim = null;
		l2.ult = null;
		l2.quantNos = 0;
	}
	
	//atv 05 - 2
	public ListaDupla dividirListas() {
		ListaDupla l2 = new ListaDupla();
		if (this.eVazia()) return l2;
		
		NoDupla atual = this.prim;
		int metade = this.quantNos/2;
		for (int i=0; i <= metade;i++) {
			atual = atual.getProx();
		}
		
		l2.setPrim(atual.getProx());
		l2.prim.setAnt(null);
		l2.setUlt(ult);
		l2.setQuantNos(metade);
		this.setUlt(atual);
		this.ult.setProx(null);
		this.setQuantNos(metade);
		return l2;
	}
	
	//atv 05 - 3
	public int maiorValor() {
		NoDupla maior = this.prim;
		NoDupla atual = this.prim;
		while (atual != null) {
			if (atual.getInfo() > maior.getInfo()) {
				maior = atual;
			}
			atual = atual.getProx();
		}
		return maior.getInfo();
		
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