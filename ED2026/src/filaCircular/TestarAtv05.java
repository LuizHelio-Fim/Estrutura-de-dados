package filaCircular;

import pilha.PilhaContig;

public class TestarAtv05 {

	public static void main(String[] args) {
		FilaCircular fila = new FilaCircular(10);
		fila.enfileirar(15);
		fila.enfileirar(27);
		fila.enfileirar(77);
		fila.enfileirar(70);
		fila.enfileirar(55);
		fila.enfileirar(49);
		fila.enfileirar(36);
		fila.enfileirar(81);
		
		FilaCircular filaIdosos = new FilaCircular(fila.getTamanho());
		filaIdosos = fila.separarIdosos();
		
		System.out.println(filaIdosos.toString());
	}

}
