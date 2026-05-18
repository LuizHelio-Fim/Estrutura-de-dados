package recursividade;

public class OcorrenciaDeterminadoCaracter {

	public static void main(String[] args) {
		
		String texto = "Banana amarela";
		char letra = 'a';
		
		System.out.println("total de '" + letra + "' no texto: " + contarCaracter(texto, letra));		
	}
	
	public static int contarCaracter(String texto, char letra) {
		if(texto.length() == 0) {
			return 0;
		}
		
		int cont = 0;
		
		if (texto.charAt(0) == letra) {
			cont = 1;
		}
		
		return cont + contarCaracter(texto.substring(1), letra);
	}

}
