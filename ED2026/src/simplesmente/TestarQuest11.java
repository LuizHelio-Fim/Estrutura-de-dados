package simplesmente;

import java.util.Scanner;

public class TestarQuest11 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		
		lista.inserirUltimo(1);
		lista.inserirUltimo(2);
		lista.inserirUltimo(3);
		lista.inserirUltimo(4);
		
		System.out.println("Digite um valor para alterar: ");
		int alterar = sc.nextInt();
		int teste = lista.encontraAltera(alterar);
		
		if (teste == 0) {
			System.out.println("Lista Vazia");
		} else if (teste == 1) {
			System.out.println("Valor alterado, nova lista: " + lista.toString());
		} else {
			System.out.println("Valor nao encontrado");
		}

		sc.close();
	}

}
