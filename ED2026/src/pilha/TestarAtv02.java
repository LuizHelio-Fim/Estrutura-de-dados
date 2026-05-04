package pilha;

public class TestarAtv02 {

	public static void main(String[] args) {
		PilhaContig pilha = new PilhaContig(10);
		pilha.push(4);
		pilha.push(8);
		pilha.push(9);
		pilha.push(15);
		pilha.push(10);
		pilha.push(18);
		
		pilha.retirarMaiorQue10();
		
		System.out.println(pilha.toString());
	}

}
