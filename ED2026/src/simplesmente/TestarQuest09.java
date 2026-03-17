package simplesmente;

public class TestarQuest09 {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		lista.inserirUltimo(1);
		lista.inserirUltimo(2);
		lista.inserirUltimo(3);
		lista.inserirUltimo(4);
		lista.inserirUltimo(5);
		lista.inserirUltimo(6);
		System.out.println("Valores pares da lista:" + lista.valoresPares());
		System.out.println("Valores pares da lista de outra forma: " + lista.valoresParesProf());
	}

}
