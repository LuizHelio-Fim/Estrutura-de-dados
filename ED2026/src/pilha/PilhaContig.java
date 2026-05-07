package pilha;

import java.util.Arrays;

public class PilhaContig {
	private int [] info;
	private int topo;
	public PilhaContig(int qte){
		this.topo = 0;
		this.info = new int [qte];
	}
	public int getInfo(){
		return this.info[this.topo-1];
	}
	public int getTopo(){
		return this.topo;
	}
	public boolean eVazia(){
		return (this.topo == 0);
	}
	public boolean eCheia(){
		return (this.topo == this.info.length);
	}
	//inserir um novo dado no topo da pilha.
	public boolean push (int elem){
		if (this.eCheia()) {
			return false;
		}else {
			this.info[this.topo++]= elem;
			return true;
		}
	}
	//remove o dado que está no topo da pilha (somente por vez).
	public int pop(){
		if (this.eVazia()) {
			return -1; //este valor de retorno pode ser alterado
		}else{
			return this.info[--this.topo];
		}
	}
	
	//Atv 06 - 2
	public void retirarMaiorQue10() {
		PilhaContig aux = new PilhaContig(topo);
		int num;
		for (int i=0; i < topo; i++) {
			num = this.pop();
			if (num <= 10 ) {
				aux.push(num);
			}
		}
		while (!aux.eVazia()) {
			this.push(aux.pop());
		}
	}
	
	//Atv 06 - 3
	public int compararPilhas(PilhaContig pilha2) {
	    if (this.topo != pilha2.topo) {
	        return 0;
	    }
	    PilhaContig aux1 = new PilhaContig(this.topo);
	    PilhaContig aux2 = new PilhaContig(pilha2.topo);
	    int numP1, numP2;

	    while (!this.eVazia()) {
	        numP1 = this.pop();
	        numP2 = pilha2.pop();

	        if (numP1 != numP2) {
	            aux1.push(numP1);
	            aux2.push(numP2);

	            while (!aux1.eVazia()) {
	                this.push(aux1.pop());
	            }
	            while (!aux2.eVazia()) {
	                pilha2.push(aux2.pop());
	            }

	            return 0;
	        }

	        aux1.push(numP1);
	        aux2.push(numP2);
	    }

	    while (!aux1.eVazia()) {
	        this.push(aux1.pop());
	    }
	    while (!aux2.eVazia()) {
	        pilha2.push(aux2.pop());
	    }

	    return 1;
	}
	
	//atv06 - 7
	public int calcularFatorial(int num) {
		int fatorial = 1;
		while (num > 0) {
			this.push(num--);
		}
		
		while (!this.eVazia()) {
			fatorial *= this.pop();
		}
		
		return fatorial;
	}
	
	//atv06 - 8
	public String converterDecimalBinario(int num) {
		if (num == 0) return "0";
		
		PilhaContig pilha = new PilhaContig(100);
		int bin;
		
		while (num != 0) {
			bin = num%2;
			pilha.push(bin);
			num /= 2;
		}
		
		String binario = "";
		while(!pilha.eVazia()) {
			binario += pilha.pop();			
		}
		
		return binario;
		
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    for (int i = topo - 1; i >= 0; i--) {
	        sb.append("| ").append(info[i]).append(" |\n");
	    }

	    sb.append("-----");

	    return sb.toString();
	}
}