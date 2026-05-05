package filaCircular;

public class TestarAtv06 {
	
	public static void main(String[] args) {
		FilaCircular fila = new FilaCircular(11);
		fila.enfileirar(1);
		fila.enfileirar(27);
		fila.enfileirar(10);
		fila.enfileirar(70);
		fila.enfileirar(55);
		fila.enfileirar(49);
		fila.enfileirar(10);
		fila.enfileirar(81);
		
		fila.inserirXApos10(-1);
		
		System.out.println(fila.toString());
	}
}
