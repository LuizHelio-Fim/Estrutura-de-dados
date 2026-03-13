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
	//atv 2 - questao 7
	public int somarTodos() {
		if (this.eVazia()) {
			return 0;
		} else {
			int soma = 0;
			No atual = this.prim;
			while (atual != null) {
				soma += atual.getInfo();
				atual = atual.getProx();
			}
			return soma;
		}
	}
	
	//atv 2 - questao 8
	public double mediaTodos() {
		if (this.eVazia()) {
			return 0;
		} else {
			double soma = 0;
			No atual = this.prim;
			int i = 0;
			while (atual != null) {
				soma += atual.getInfo();
				atual = atual.getProx();
				i++;
			}
			return soma/i;
		}
	}
	
	//atv2 - questao 9
	public ListaSimples valoresPares() {
		if (this.eVazia()) {
			return null;
		} else {
			ListaSimples pares = new ListaSimples();
			No atual = this.prim;
			while (atual != null) {
				if(atual.getInfo()%2 == 0) {
					pares.inserirUltimo(atual.getInfo());					
				}
				atual = atual.getProx();
			}
			return pares;
		}	
	}
	
	//atv2 - questao 10
	public boolean compararListas(ListaSimples L1, ListaSimples L2) {
		No atual1 = L1.prim;
		No atual2 = L2.prim;
		while (atual1 != null && atual2 != null) {
			if (atual1.getInfo() != atual2.getInfo()) {
				return false;
			}
			atual1 = atual1.getProx();
			atual2 = atual2.getProx();
		}
		return atual1 == null && atual2 == null;
	}
	
	//atv2 - questao 11
	public int encontraAltera(int num){
		if (this.eVazia()) {
			return 0;
		} else {
			No atual = this.prim;
			while (atual != null) {
				if (atual.getInfo() == num) {
					atual.setInfo(50);
					return 1;
				}
				atual = atual.getProx();
			}
			return 2;
		}
	}
	
	//atv2 - questao 12
	public int procuraInsereSeNaoExistir(int num) {
		if(this.eVazia()) {
			return 0;
		} else {
			No atual = this.prim;
			int quantNosAparece = 0;
			while (atual != null) {
				if (atual.getInfo() == num) {
					quantNosAparece++;
				}
				atual = atual.getProx();
			}
			if (quantNosAparece == 0) {
				this.inserirUltimo(num);
				return 0;
			}
			return quantNosAparece;
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
