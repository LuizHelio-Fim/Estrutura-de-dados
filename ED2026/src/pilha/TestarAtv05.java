package pilha;

public class TestarAtv05 {

	public static void main(String[] args) {
		PilhaContigString pilha = new PilhaContigString(100);
		PilhaContigString pilha2 = new PilhaContigString(100);

		String texto = "batata";
		pilha.empilharPalavras(texto);
		
		texto = "atatab";
		pilha2.empilharPalavras(texto);

		System.out.println(pilha.compararInversoDoTexto(pilha2));
		
		System.out.println(pilha.toString());
		System.out.println(pilha2.toString());


	}

}
