package simplesmente;

public class TestarQuest08 {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		lista.inserirUltimo(5);
		lista.inserirUltimo(6);
		lista.inserirUltimo(7);
		System.out.println("Média dos numeros da lista: " + lista.mediaTodos());;
	}

}
