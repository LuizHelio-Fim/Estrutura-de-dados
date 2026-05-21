package recursividade;

import simplesmente.*;

public class PesquisaSequencialRecursiva {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		lista.inserirUltimo(1);
		lista.inserirUltimo(2);
		lista.inserirUltimo(3);
		lista.inserirUltimo(4);
		lista.inserirUltimo(5);
		lista.inserirUltimo(6);
		No atual = lista.getPrim();
		int achar = 6;
		
		boolean achou = pesquisaSequencial(atual, achar);
		
		if (achou) {
			System.out.println("o numero " + achar + " foi encontrado na lista");
		} else {
			System.out.println("o numero " + achar + " não foi encontrado");
		}
	}
	
	public static boolean pesquisaSequencial(No atual, int x) {
		if (atual == null) return false;
		
		if (atual.getInfo() == x) {
			return true;
		} else {
			return pesquisaSequencial(atual.getProx(), x);
		}
	}

}
