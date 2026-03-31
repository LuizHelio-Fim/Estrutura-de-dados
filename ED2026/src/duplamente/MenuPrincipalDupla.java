package duplamente;
import java.util.Scanner;
public class MenuPrincipalDupla {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//instancia uma nova lista duplamente encadeada.
		ListaDupla lista = new ListaDupla();
		NoDupla pesqNo = null;
		char opcao;
		do {
			opcao = menu();
			switch (opcao){
			case '1':
				System.out.println("Digite um valor");
				lista.inserirUltimo(scan.nextInt());
				break;
			case '2':
				System.out.println("Digite um valor");
				pesqNo = lista.pesquisarNo(scan.nextInt());
				if (pesqNo==null)
					System.out.println("Valor não encontrado.");
				else
					System.out.println("o "+pesqNo.getInfo()+
							" foi encontrado na lista");
				break;
			case '3':
				System.out.println("Digite um valor");
				if (lista.removerNo(scan.nextInt()))
					System.out.println("Remoção efetuada");
				else
					System.out.println("Valor não encontrado.");
				break;
			case '4':
				System.out.println("Exibir a lista\n"+lista.toString());
				break;
			case '5':
				System.out.println("FIM DO PROGRAMA");
			}
		} while (opcao != '5');
		System.exit(0);
	}
	public static char menu(){
		System.out.println("Escolha uma Opção:\n"+
				"1. Inserir Nó no fim\n"+
				"2. Localizar Nó\n"+
				"3. Excluir Nó\n"+
				"4. Exibir lista\n"+
				"5. Sair");
		return scan.next().charAt(0);
	}
}
