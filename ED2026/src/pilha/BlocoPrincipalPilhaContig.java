package pilha;
import java.util.Scanner;
public class BlocoPrincipalPilhaContig {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println ("Digite o tamanho máximo da pilha");
		int tamanho = scan.nextInt();
		PilhaContig pilha = new PilhaContig(tamanho); //instancia a pilha.
		char opcao;
		int valor;
		do {
			opcao = menu();
			switch (opcao){
			case '1':
				System.out.println ("Digite um valor inteiro:");
				if (! pilha.push(scan.nextInt())) {
					System.out.println("Pilha está cheia, não empilhou.");
				}
				break;
			case '2':
				valor = pilha.pop();
				if (valor == -1) {
					System.out.println("A pilha está vazia.");
				} else {
					System.out.println("Valor desempilhado: "+valor);
				}
				break;
			case '3':
				System.out.println("FIM DO PROGRAMA");
				break;
			default:
				System.out.println("Opção inválida, tente novamente");
			}
		} while (opcao!='3');
		System.exit(0);
	}
	public static char menu(){
		System.out.println("\nEscolha uma Opção:\n" +
				"1. Empilhar\n"+
				"2. Desempilhar\n"+
				"3. Sair");
		return scan.next().charAt(0);
	}
}
