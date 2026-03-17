package simplesmente;

import java.util.Scanner;

public class TestarQuest12 {
	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		
		lista.inserirUltimo(1);
		lista.inserirUltimo(2);
		lista.inserirUltimo(4);
		lista.inserirUltimo(4);
		
		System.out.println("Digite um numero para ser buscado na lista: ");
		int novo = sc.nextInt();
		int procurar = lista.procuraInsereSeNaoExistir(novo);
		if (procurar == 1) {
			System.out.println("Valor nao encontrado ou lista vazia");
			System.out.println("Nova lista: " + lista.toString());
		} else {
			System.out.println("O valor aparece " + procurar + " vezes na lista");
		}
		
		sc.close();
	}

}
