package recursividade;

public class ExemploFat {

	public static void main(String[] args) {
		int num = 5;
		System.out.println("o fatorial do número "+num+ " é " + fat(num));
		
		System.out.println("resultado: " + inverter("Java"));
	}

	public static int fat (int n) {
		if (n == 0)
			return 1;
		else
			return (n * fat (n-1));
	}
	
	public static String inverter(String s) {
		if (s.isEmpty()) {
			return s;
		}
		return inverter(s.substring(1)) + s.charAt(0);
	}

}
