package filaCircular;

import duplamente.ListaDupla;
import pilha.PilhaContig;

public class FilaCircular {
	private int [] info;
	private int frente;
	private int tras;
	private int tamanho;

	public FilaCircular(int tamanho){//qte é o tamanho do vetor
		this.frente = 0;
		this.tras = 0;
		this.tamanho = 0;
		this.info = new int [tamanho];
	}

	public int getInfo(){
		return this.info[this.frente];
	}

	public int getFrente(){
		return this.frente;
	}

	public int getTras(){
		return this.tras;
	}

	public int getTamanho(){
		return this.tamanho;
	}

	public boolean eVazia(){
		return (this.tamanho == 0);
	}

	public boolean eCheia(){
		return (this.tamanho == this.info.length);
	}

	public boolean enfileirar (int elem){
		if (this.eCheia()) return false;
	else {
		this.info[this.tras]= elem;
		this.tras = (++this.tras % this.info.length);
		this.tamanho++;
		return true;
		}
	}
	
	public int desenfileirar(){
		int no;
		if (this.eVazia())
			return -1; //pode mudar o valor de retorno
		else{
			no = this.info[this.frente];
			this.frente = (++this.frente % this.info.length);
			this.tamanho--;
			return no;
		}
	}
	
	//Atv07 - 1
	public void retirarNegativos() {
		if (!this.eVazia()) {
			int tam = this.tamanho;
			int item;
			for (int i=0; i < tam; i++) {
				item = this.desenfileirar();
				if (item >= 0) {
					this.enfileirar(item);
				}
			}
		}
	}
	
	//atv07 - 2
	public int somarFila() {
		int soma = 0;
		while (!this.eVazia()) {
			soma += this.desenfileirar();
		}
		return soma;
	}
		
	//atv07 - 3
	public FilaCircular transferirPilha(PilhaContig pilha) {
		if (pilha.eVazia()) return null;
		
		FilaCircular filaAux = new FilaCircular(pilha.getTopo());
		PilhaContig pilhaAux = new PilhaContig(pilha.getTopo());
		
		while (!pilha.eVazia()) {
			pilhaAux.push(pilha.pop());
		}
		while (!pilhaAux.eVazia()) {
			filaAux.enfileirar(pilhaAux.pop());
		}
		return filaAux;
	}
		
	//atv07 - 4
	public void inverterFila() {
		PilhaContig pilha = new PilhaContig(this.tamanho);
		while (!this.eVazia()) {
			pilha.push(this.desenfileirar());
		}
		while (!pilha.eVazia()) {
			this.enfileirar(pilha.pop());
		}
	}
		
	//atv07 - 5
	public FilaCircular separarIdosos() {
		FilaCircular filaIdosos = new FilaCircular(100);
		int tam = this.tamanho;
		int item;
		for (int i=0; i < tam; i++) {
			item = this.desenfileirar();
			if (item >= 70) {
				filaIdosos.enfileirar(item);
			} else {
				this.enfileirar(item);
			}
		}
		return filaIdosos;
	}
		
	//atv07 - 6
	public boolean inserirXApos10(int x) {
		if (this.eCheia() || this.eVazia()) return false;
		
		int aux;
		int i, tam = this.tamanho;
		
		for(i=1; (i<=tam) && (!this.eCheia()); i++) {
			aux = this.desenfileirar();
			if (aux == 10) {
				this.enfileirar(x);
				this.enfileirar(aux);
			} else {
				this.enfileirar(aux);
			}
		}
		if (i > tam) {
			return true;
		} else {
			return false;
		}
	}
	
	//atv07 - 7
	public ListaDupla retirarFaltantes() {
		ListaDupla lista = new ListaDupla();
		int aux, tam = this.tamanho;
		
		for (int i=1; i<= tam; i++) {
			aux = this.desenfileirar();
			if (aux == 1) {
				lista.inserirUltimo(aux);
			} else {
				this.enfileirar(aux);
			}
		}
		return lista;
	}
	
	public String toString(){ //imprimir o conteúdo da fila
		String msg="";
		int aux= this.frente;
		for (int i=1; i <= this.tamanho; i++){
			msg+= this.info[aux] +" ";
			aux= (++aux % this.info.length);
		}
		return msg;
	}
}
