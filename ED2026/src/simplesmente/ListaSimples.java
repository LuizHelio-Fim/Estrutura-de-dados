package simplesmente;

public class ListaSimples {
	private No prim;
	private No ult;
	private int quantNos;
	
	//construtor da classe
	public ListaSimples(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	
	public int getQuantNos(){
		return this.quantNos;
	}
	public No getPrim(){
		return this.prim;
	}
	public No getUlt(){
		return this.ult;
	}
	public void setQuantNos(int novoValor){
		this.quantNos = novoValor;
	}
	public void setPrim(No novoNo){
		this.prim = novoNo;
	}
	public void setUlt(No novoNo){
		this.ult = novoNo;
	}
	public boolean eVazia (){
		return (this.prim == null);
	}
	
	//insere um novo nó no final da lista ou se a lista estiver vazia, insere o primeiro nó na lista
	public void inserirUltimo (int elem){
		No novoNo = new No (elem);
		if (this.eVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	
	//retorna o endereço do nó que está contendo o valor a ser procurado.
	public No pesquisarNo (int x){
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo() != x)){
			atual = atual.getProx();
		}
		return atual;
	}
	
	//remove um determinado nó em qualquer posição na lista.
	public boolean removerNo(int x){
		if (this.eVazia()){
			return false;
		}else{
			if (this.prim.getInfo() == x){
				//remove se for único nó da lista
				if (this.prim.getProx() == null){
					this.ult = null;
				}
				//remover o primeiro nó da lista
				this.prim = this.prim.getProx();
			}else{
				No atual = this.prim;
				while ((atual.getProx() != null) &&
						(atual.getProx().getInfo() != x)){
					atual = atual.getProx();
				}
				//não achou o valor na lista
				if (atual.getProx() == null){
					return false;
				}else{
					//se for o último nó
					if (atual.getProx() == this.ult){
						atual.setProx(null);
						this.ult = atual;
					}else{
						atual.setProx(atual.getProx().getProx());
						//remove o nó no meio da lista
					}
				}
			}
			this.quantNos--;
			return true;
		}
	}
	
	public boolean inserirDeterminado(int novo, int x) {
		if (this.eVazia()) {
			return false;
		} else {
			No achou = this.pesquisarNo(x);
			if (achou == null) {
				return false;
			} else {
				No novoNo = new No(novo);
				novoNo.setProx(achou.getProx());
				if (achou == this.ult) {
					this.ult = novoNo;
				}
				achou.setProx(novoNo);
				this.quantNos++;
				return true;
			}
		}
		
	}
	
	//mostra todo o conteúdo da lista
	public String toString(){
		String msg = "";
		No atual = this.prim;
		while (atual != null){
			msg += atual.getInfo() + "\n";
			atual = atual.getProx();
		}
		return msg;
	}
}
