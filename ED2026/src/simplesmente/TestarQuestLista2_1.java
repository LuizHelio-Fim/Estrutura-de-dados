package simplesmente;

public class TestarQuestLista2_1 {

	public static void main(String[] args) {
		ListaSimples lista1 = new ListaSimples();
		lista1.inserirUltimo(1);
		lista1.inserirUltimo(2);
		lista1.inserirUltimo(3);
		lista1.inserirUltimo(4);
		
		ListaSimples lista2 = new ListaSimples();
		lista2.inserirUltimo(6);
		lista2.inserirUltimo(5);
		
		System.out.println("Concatenou? " + lista1.concatenarLista(lista2));
		System.out.println("Existem quantos nós? " + lista1.getQuantNos());
		System.out.println("Qual o ultimo numero da lista? " + lista1.getUlt().getInfo());
		System.out.println(lista1.toString());
		System.out.println("--------------");
		System.out.println(lista2.toString());
	}

}
