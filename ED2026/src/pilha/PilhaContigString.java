package pilha;

public class PilhaContigString {
    private String[] info;
    private int topo;

    public PilhaContigString(int qte){
        this.topo = 0;
        this.info = new String[qte];
    }
    public String getInfo(){
        return this.info[this.topo - 1];
    }
    public int getTopo(){
        return this.topo;
    }
    public boolean eVazia(){
        return (this.topo == 0);
    }
    public boolean eCheia(){
        return (this.topo == this.info.length);
    }

    public boolean push(String elem){
        if (this.eCheia()) {
            return false;
        } else {
            this.info[this.topo++] = elem;
            return true;
        }
    }

    public String pop(){
        if (this.eVazia()) {
            return null;
        } else {
            return this.info[--this.topo];
        }
    }
    
    //atv 06 - 1
    public void empilharPalavras(String texto) {
    	for (int i=0; i<texto.length(); i++) {
    		String letra  = String.valueOf(texto.charAt(i));
    		this.push(letra);
    	}
    }
    
    public String fraseInversa() {
    	PilhaContigString pilha = new PilhaContigString(topo);
    	String texto = "";
    	String aux;
    	while(!this.eVazia()) {
    		aux = this.pop();
    		texto += aux;
    		pilha.push(aux);
    	}
    	while (!pilha.eVazia()) {
    		this.push(pilha.pop());
    	}
    	return texto;
    }
    
    
    //atv 06 - 5
    public boolean compararInversoDoTexto(PilhaContigString texto) {
        if (this.topo != texto.topo) return false;

        PilhaContigString aux = new PilhaContigString(topo);
        PilhaContigString aux2 = new PilhaContigString(texto.topo);

        aux2.empilharPalavras(texto.fraseInversa());

        String letra, letra2;

        while (!this.eVazia()) {
            letra = this.pop();
            letra2 = aux2.pop();

            if (!letra.equalsIgnoreCase(letra2)) {
                aux.push(letra);

                while (!aux.eVazia()) {
                    this.push(aux.pop());
                }

                return false;
            }

            aux.push(letra);
        }

        while (!aux.eVazia()) {
            this.push(aux.pop());
        }

        return true;
    }
    
    //atv06 - 12
    public boolean verificarPalindromo(String palavra) {
        PilhaContigString pilha = new PilhaContigString(palavra.length());
        PilhaContigString aux = new PilhaContigString(palavra.length());

        for (int i = 0; i < palavra.length(); i++) {
            pilha.push(String.valueOf(palavra.charAt(i)));
        }

        for (int i = palavra.length() - 1; i >= 0; i--) {
            aux.push(String.valueOf(palavra.charAt(i)));
        }

        while (!pilha.eVazia()) {
            if (!pilha.pop().equals(aux.pop())) {
                return false;
            }
        }

        return true;
    }
    
    //atv06 - 15
    public boolean verificarInverso(String x, String y){
    	if (x.length() != y.length()){
    		return false;
    	}else{
    		PilhaContigString pilha = new PilhaContigString(x.length());
    		String inverso="";
    		for (int i=0; i < x.length();i++){
    			pilha.push(String.valueOf(x.charAt(i)));
    		}
    		while (!pilha.eVazia()){
    			inverso += pilha.pop();
    		}
    		if (inverso.equals(y)){
    			return true;
    		}else{
    			return false;
    		}
    	}
    }
    
    @Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    for (int i = topo - 1; i >= 0; i--) {
	        sb.append("| ").append(info[i]).append(" |\n");
	    }

	    sb.append("-----");

	    return sb.toString();
	}
    
}