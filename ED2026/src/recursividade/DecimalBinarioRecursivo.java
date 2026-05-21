package recursividade;

public class DecimalBinarioRecursivo {

	public static void main(String[] args) {
		System.out.println(decimalParaBinario(13));
	}
	
	public static String decimalParaBinario(int num) {
		if (num == 0) {
			return "";
		}
		
		return decimalParaBinario(num / 2) + (num % 2);
	}

}
