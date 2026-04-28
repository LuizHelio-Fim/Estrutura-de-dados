package filaCircular;
import java.util.Scanner;

public class BlocoPrincipalFilaCircular {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Digite o tamanho máximo da fila");
		int tam = scan.nextInt();
		FilaCircular fila = new FilaCircular(tam);
		int opcao, valor;
		
		do {
			System.out.println("Escolha uma Opção:\n"+
					"1. Enfileirar\n"+
					"2. Desenfileirar\n"+
					"3. Imprimir Fila\n"+
					"4. Sair");
			opcao = scan.nextInt();
			switch (opcao){
			case 1:
				System.out.println("Digite um valor");
				
				if (! fila.enfileirar(scan.nextInt())){
					System.out.println("fila está cheia");
				}
				break;
				
			case 2:
				valor = fila.desenfileirar();
				if (valor == -1){
					System.out.println("A fila está vazia");
				}else{
					System.out.println("valor foi removido da fila");
				}
				break;
				
			case 3:
				if (!fila.eVazia()){
					System.out.println("A fila: "+fila.toString());
				}else{
					System.out.println("A fila está vazia");
				}
				break;
				
			case 4:
				System.out.println("FIM DO PROGRAMA");
				break;
			default:
				System.out.println("Opção invalida, tente novamente");
			}
			
		} while (opcao!=4);
		System.exit(0);
	}
}