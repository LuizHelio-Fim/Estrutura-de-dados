package simplesmente;

public class TestarQuest10 {

	public static void main(String[] args) {
		ListaSimples lista1 = new ListaSimples();
		lista1.inserirUltimo(1);
		lista1.inserirUltimo(2);
		lista1.inserirUltimo(3);
		lista1.inserirUltimo(4);
		lista1.inserirUltimo(5);
		lista1.inserirUltimo(6);
		
		ListaSimples lista2 = new ListaSimples();
		lista2.inserirUltimo(1);
		lista2.inserirUltimo(2);
		lista2.inserirUltimo(3);
		lista2.inserirUltimo(4);
		lista2.inserirUltimo(5);
		lista2.inserirUltimo(6);
		
		System.out.println("As listas sao iguais? " + lista1.compararListas(lista1, lista2));
	}

}
