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
	
	//atv 05 - 4
	public double calcularMediaAritmetica() {
		if (eVazia()) return 0.0;
		
		NoDupla atual = this.prim;
		double total = 0.0;
		
		while (atual != null) {
			total += atual.getInfo();
			atual = atual.getProx();
		}
		return total / this.quantNos;
	}
	
	//atv 05 - 5
	public boolean removerZeros() {
		NoDupla atual = this.prim;
		int totalItens = this.quantNos;		// se o total no comeco for o mesmo que no final entao nenhum item foi retirado
		
		while (atual != null) {
	        NoDupla proximo = atual.getProx();

	        if (atual.getInfo() == 0) {
	            if (atual == this.prim) {
	                this.prim = atual.getProx();
	                if (this.prim == null) {
	                    this.ult = null;
	                } else {
	                    this.prim.setAnt(null);
	                }
	            } else if (atual == this.ult) {
	                this.ult = this.ult.getAnt();
	                this.ult.setProx(null);
	            } else {
	                atual.getProx().setAnt(atual.getAnt());
	                atual.getAnt().setProx(atual.getProx());
	            }
	            this.quantNos--;
	        }
	        atual = proximo;
	    }
		return totalItens == this.quantNos;
	}
	
	//atv 05 - 6
	public void removerValoresRepetidos() {
	    if (this.prim == null) return;
	    NoDupla atual = this.prim;

	    while (atual != null) {
	        NoDupla comparar = atual.getProx();
	        while (comparar != null) {
	            NoDupla proximo = comparar.getProx();

	            if (atual.getInfo() == comparar.getInfo()) {
	                if (comparar == this.ult) {
	                    this.ult = comparar.getAnt();
	                    this.ult.setProx(null);
	                } else {
	                    comparar.getAnt().setProx(comparar.getProx());
	                    comparar.getProx().setAnt(comparar.getAnt());
	                }
	                this.quantNos--;
	            }
	            comparar = proximo;
	        }
	        atual = atual.getProx();
	    }
	}
	
	//atv 05 - 7
	//Tipo do dado guardado não condiz com a lista (objeto com nome e altura)
	
	//atv05 - 8
	public ListaDupla valoresAcimaDe100() {
		if (eVazia()) return new ListaDupla();
		
		ListaDupla valoresAcima100 = new ListaDupla();
		NoDupla atual = this.prim;
		
		while (atual != null) {
			if (atual.getInfo() > 100) {
				valoresAcima100.inserirUltimo(atual.getInfo());
			}
			atual = atual.getProx();
		}
		return valoresAcima100;
	}
	
	//atv05 - 9
	//Tipo do dado guardado não condiz com a lista (String)
	
	//atv05 - 10
	public void inserirOrdenado (int num) {
		if (eVazia()) {
		    this.prim = this.ult = new NoDupla(num);
		    this.quantNos++;
		    return;
		}
		
		NoDupla novoNo = new NoDupla(num);
		if (num <= this.prim.getInfo()) {
			novoNo.setProx(this.prim);
			this.prim.setAnt(novoNo);
			this.prim = novoNo;
			
		} else if (num >= this.ult.getInfo()) {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
			this.ult = novoNo;
		} else {
			NoDupla atual = this.prim;
			
			while (atual.getInfo() < num) {
				atual = atual.getProx();
			}
			novoNo.setProx(atual);
			novoNo.setAnt(atual.getAnt());
			atual.getAnt().setProx(novoNo);
			atual.setAnt(novoNo);

		}
		this.quantNos++;
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