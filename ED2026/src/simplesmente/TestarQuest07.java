package simplesmente;

public class TestarQuest07 {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		lista.inserirUltimo(3);
		lista.inserirUltimo(5);
		lista.inserirUltimo(7);
		
		System.out.println("A soma é: " + lista.somarTodos());
		
	}

}
