package simplesmente;

import java.util.Scanner;

public class Main {

		static Scanner scan = new Scanner (System.in);
		
		public static void main(String[] args) {
			ListaSimples lista = new ListaSimples(); //instancia a lista
			int opcao;
			do{
				System.out.println("Escolha uma opção:\n"
						+ "1. Inserir nó no final da lista\n"
						+ "2. Inserir em determinada posição\n"
						+ "3. Pesquisar um determinado valor na lista\n"
						+ "4. Remover um determinado nó da lista\n"
						+ "5. Mostrar conteúdo a lista\n"
						+ "6. Sair do programa");
				opcao = scan.nextInt();
				switch (opcao){
				case 1:
					System.out.println("digite um valor inteiro:");
					lista.inserirUltimo(scan.nextInt());
					System.out.println("operação realizada!");
					break;
				case 2:
					System.out.println("digite um valor inteiro e depois de qual numero deseja:");
					if ((lista.inserirDeterminado(scan.nextInt(), scan.nextInt()) == false)) {
						System.out.println("valor não encontrado");
					} else {
						System.out.println("Operação realizada");
					}
					scan.nextLine();
				case 3:
					System.out.println("digite o valor inteiro a"
							+ " ser procurado na lista:");
					if (lista.pesquisarNo(scan.nextInt()) != null){
						System.out.println("o valor está na lista.");
					}else{
						System.out.println("valor não encontrado.");
					}
					break;
				case 4:
					System.out.println("digite o valor inteiro a"
							+ " ser removido da lista:");
					if (lista.removerNo(scan.nextInt())){
						System.out.println("o valor foi removido!");
					}else{
						System.out.println("valor não encontrado");
					}
					break;
				case 5:
					System.out.println("lista: "+lista.toString());
					break;
				case 6:
					System.out.println("FIM DO PROGRAMA");
					break;
				default:
					System.out.println("opção inválida");
				}
			}while (opcao!=5);
		}
	}
