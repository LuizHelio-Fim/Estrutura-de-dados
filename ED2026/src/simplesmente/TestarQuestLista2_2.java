package simplesmente;

public class TestarQuestLista2_2 {

	public static void main(String[] args) {
		ListaSimples lista1 = new ListaSimples();
		lista1.inserirUltimo(1);
		lista1.inserirUltimo(2);
		lista1.inserirUltimo(3);
		lista1.inserirUltimo(4);
		lista1.inserirUltimo(5);
		lista1.inserirUltimo(5);
		lista1.inserirUltimo(5);
		lista1.inserirUltimo(5);
		
		ListaSimples lista2 = new ListaSimples();
		
		System.out.println("Separou?" + lista1.dividirLista(lista2));
		
		System.out.println("Lista1: " + lista1.toString());
		System.out.println("Prim: " + lista1.getPrim().getInfo());
		System.out.println("ult: " + lista1.getUlt().getInfo());
		System.out.println("QuantNos: " + lista1.getQuantNos() + "\n");

		
		System.out.println("Lista2: " + lista2.toString());
		System.out.println("Prim: " + lista2.getPrim().getInfo());
		System.out.println("ult: " + lista2.getUlt().getInfo());
		System.out.println("QuantNos: " + lista2.getQuantNos());

		
	}

}
