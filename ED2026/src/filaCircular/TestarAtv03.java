package filaCircular;

import pilha.PilhaContig;

public class TestarAtv03 {

	public static void main(String[] args) {
		PilhaContig pilha = new PilhaContig(10);
		FilaCircular fila = new FilaCircular(pilha.getTopo());
		
		pilha.push(1);
		pilha.push(4);
		pilha.push(8);
		pilha.push(12);
		pilha.push(42);
		pilha.push(99);
		
		System.out.println(fila.transferirPilha(pilha));;

	}

}
