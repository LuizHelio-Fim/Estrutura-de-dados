package arvore;
import java.util.Scanner;
public class MenuPrincipalArvore {
	static Scanner scan =new Scanner(System.in);
	public static void main(String[] args) {
		Arvore arvore = new Arvore(); //instancia a árvore
		int [] vetor= new int[10]; //tamanho da arvore
		char opcao;
		do {
			System.out.println("Escolha uma Opção:\n" +
					"1. Inserir Nó na árvore\n"+
					"2. Localizar Nó na árvore\n"+
					"3. Excluir Nó da árvore\n" +
					"4. Exibir árvore ordenada\n" +
					"5. Sair");
			opcao = scan.next().charAt(0);
			switch (opcao){
			case '1':
				System.out.println("Digite um valor para inserir na árvore");
				if (arvore.inserir(scan.nextInt())){
					System.out.println("inserção efetuada com sucesso");
				}else{
					System.out.println("valor já existe na árvore");
				}
				break;
			case '2':
				if (arvore.eVazia()){
					System.out.println("Árvore está vazia");
				}else{
					System.out.println("Digite o valor para pesquisar");
					if (arvore.pesquisar(scan.nextInt())){
						System.out.println("valor encontrado");
					}else{
						System.out.println("valor não encontrado");
					}
				}
				break;
			case '3':
				if (arvore.eVazia()){
					System.out.println("Arvore está vazia");
				}else {
					System.out.println("Digite um valor para excluir");
					if (arvore.remover(scan.nextInt())){
						System.out.println("remoção efetuada");
					}else{
						System.out.println("valor não encontrado");
					}
				}
				break;
			case '4':
				if (arvore.eVazia()){
					System.out.println("A árvore está vazia");
				}else{
					vetor = arvore.CamCentral();
					String msg=" ";
					for (int i = 0; i < arvore.getQuantNos();i++){
						msg += vetor[i] + " ";
					}
					System.out.println("Exibir a árvore: "+ msg);
				}break;
			case '5':
				System.out.println("FIM DO PROGRAMA");
				break;
			default:
				System.out.println("Opção inválida, tente novamente");
			}
		} while (opcao!='5');
		System.exit(0);
	}
}