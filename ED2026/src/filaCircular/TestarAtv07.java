package filaCircular;

public class TestarAtv07 {

	public static void main(String[] args) {
		FilaCircular fila = new FilaCircular(10);
		fila.enfileirar(1);
		fila.enfileirar(1);
		fila.enfileirar(0);
		fila.enfileirar(0);
		fila.enfileirar(1);
		fila.enfileirar(0);
		fila.enfileirar(0);
		fila.enfileirar(1);
		fila.enfileirar(0);
		
		System.out.println(fila.retirarFaltantes());
		
		System.out.println(fila.toString());
	}

}
