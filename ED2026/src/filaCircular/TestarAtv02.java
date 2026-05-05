package filaCircular;

public class TestarAtv02 {

	public static void main(String[] args) {
		FilaCircular fila = new FilaCircular(10);
		fila.enfileirar(0);
		fila.enfileirar(1);
		fila.enfileirar(2);
		fila.enfileirar(3);
		fila.enfileirar(4);
		fila.enfileirar(-2);
		
		System.out.println(fila.somarFila());;
		
	}

}
