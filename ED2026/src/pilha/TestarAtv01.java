package pilha;

public class TestarAtv01 {

	public static void main(String[] args) {
		PilhaContigString pilha = new PilhaContigString(100);
		String texto = "Macaco quer banana";
		pilha.empilharPalavras(texto);
		

		System.out.println(pilha.fraseInversa());
		
		System.out.println(pilha.toString());

	}

}
