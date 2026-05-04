package pilha;

public class TestarAtv03 {

	public static void main(String[] args) {
		PilhaContig pilha = new PilhaContig(10);
		PilhaContig pilha2 = new PilhaContig(10);
		pilha.push(4);
		pilha.push(8);
		pilha.push(9);

		pilha2.push(4);
		pilha2.push(8);
		pilha2.push(9);

		
		System.out.println(pilha.compararPilhas(pilha2));
		System.out.println("\n"+pilha.toString() + "\n" + pilha2.toString());
	}

}
