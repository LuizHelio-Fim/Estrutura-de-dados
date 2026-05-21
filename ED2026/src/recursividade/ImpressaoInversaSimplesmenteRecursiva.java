package recursividade;

import simplesmente.*;

public class ImpressaoInversaSimplesmenteRecursiva {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		
		lista.inserirUltimo(0);
		lista.inserirUltimo(1);
		lista.inserirUltimo(2);
		lista.inserirUltimo(3);
		lista.inserirUltimo(4);
		lista.inserirUltimo(5);
		lista.inserirUltimo(6);
		
		System.out.println(imprimirInvertido(lista.getPrim()));
		
	}
	
	public static String imprimirInvertido(No atual) {
		if (atual == null) {
			return "";
		}		
		return imprimirInvertido(atual.getProx()) + " " + atual.getInfo();
	}

}
