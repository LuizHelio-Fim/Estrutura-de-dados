package contigua;

import java.util.Scanner;

public class MenuPrincipal {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Digite o tamanho máximo da lista");
		int tam = scan.nextInt();
		ListaContig lista = new ListaContig(tam); // instancia a lista
		char opcao;
		int posicao;
		do {
			System.out.println("Escolha uma Opção:\n"+
					"1. Inserir Nó no final\n"+
					"2. Localizar Nó\n"+
					"3. Excluir Nó\n"+
					"4. Exibir lista\n"+
					"5. Sair");
			opcao = scan.next().charAt(0);
			
			switch (opcao){
			case '1':
				System.out.println("Digite um valor inteiro para inserir:");
				if (!lista.inserirUltimo(scan.nextInt())){
					System.out.println("Lista está cheia");
				}
				break;
				
			case '2':
				if (lista.eVazia()){
					System.out.println("A lista está vazia");
				}
				else{
					System.out.println("Digite o valor para localizar:");
					posicao = lista.pesquisarNo(scan.nextInt());
					if (posicao == lista.getFim()){
						System.out.println("Não encontrado\n");
					}else{
						System.out.println("Está na posição "+posicao);
					}
				}
				break;
				
			case '3':
				if (lista.eVazia()){
					System.out.println("A lista está vazia");
				}
				else {
					System.out.println("Digite um valor para excluí-lo:");
					if (lista.removerNo(scan.nextInt())){
						System.out.println("remoção efetuada");
					}
					else{
						System.out.println("remoção não efetuada,"+
								" valor não encontrado");
					}
				}
				break;
				
			case '4':
				if (lista.eVazia()){
					System.out.println("A lista está vazia");
				}
				else{
					System.out.println("Exibir a lista: "+lista.toString());
				}
				break;
				
			case '5':
				System.out.println("FIM DO PROGRAMA");
				break;
			default:
				System.out.println("Opção invalida, tente novamente");
			}
		} while (opcao!='5');
		System.exit(0);
	}
}
