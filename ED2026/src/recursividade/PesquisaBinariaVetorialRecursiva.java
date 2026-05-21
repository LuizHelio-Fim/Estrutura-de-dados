package recursividade;

public class PesquisaBinariaVetorialRecursiva {

	public static void main(String[] args) {
		 
	}

	public static int pesquisaBinaria(int[] vet, int x, int inicio, int fim) {
		int meio;
		if (inicio > fim) {
			return -1;
		} else {
			meio = (inicio+fim)/2;
			if (vet[meio] == x) {
				return meio;
			} else {
				if (vet[meio] > x) {
					return pesquisaBinaria(vet, x, inicio, meio-1);
				} else {
					return pesquisaBinaria(vet, x, meio+1, fim);
				}
			}
		}
	}
}
