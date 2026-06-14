package arvore;

public class Arvore {
	private NoArv raiz;
	private int quantNos;
	
	public Arvore(){
		this.quantNos=0;
		this.raiz = null;
	}
	
	public boolean eVazia (){
		return (this.raiz == null);
	}
	
	public NoArv getRaiz(){
		return this.raiz;
	}
	
	public int getQuantNos(){return this.quantNos;
	}
	
	//inserir um novo nó na arvore. Sempre insere em um atributo que seja igual a null
	public boolean inserir (int x){
		if (pesquisar (x)){
			return false;
		}else{
			this.raiz = inserir (x, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	public NoArv inserir (int x, NoArv no){
		if (no == null){
			NoArv novoNo = new NoArv(x);
			return novoNo;
		}else {
			if (x < no.getInfo()){
				no.setEsq(inserir(x, no.getEsq()));
				return no;
			}else{
				no.setDir(inserir(x, no.getDir()));
				return no;
			}
		}
	}
	
	//Pesquisa se um determinado valor está na árvore
	public boolean pesquisar (int x){
		if (pesquisar (x, this.raiz)!= null){
			return true;
		}else{
			return false;
		}
	}
	private NoArv pesquisar (int x, NoArv no){
		if (no != null){
			if (x < no.getInfo()){
				no = pesquisar (x, no.getEsq());
			}else{
				if (x > no.getInfo()){
					no = pesquisar (x, no.getDir());
				}
			}
		}
		return no;
	}
	
	//remove um determinado nó procurando pela chave. O nó pode estar em qualquer posição na árvore
	public boolean remover (int x){
		if (pesquisar (x, this.raiz) != null){
			this.raiz = remover (x, this.raiz);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}
	public NoArv remover (int x, NoArv no){
		if (x < no.getInfo()){
			no.setEsq(remover (x, no.getEsq()));
		}else{
			if (x > no.getInfo()){
				no.setDir(remover (x, no.getDir()));
			}else{
				if (no.getDir()== null){
					return no.getEsq();
				}else{
					if (no.getEsq() == null){
						return no.getDir();
					}else{no.setEsq(arrumar(no, no.getEsq()));
					}
				}
			}
		}
		return no;
	}
	
	//Só chama esse método se o nó a ser removido tiver dois filhos
	private NoArv arrumar (NoArv arv, NoArv maior){
		if (maior.getDir() != null){
			maior.setDir(arrumar (arv, maior.getDir()));
		}
		else{
			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();
		}
		return maior;
	}
	
	//Mostrar todos os nós folhas
	public int[] mostrarFolhas() {
	    int[] vet = new int[this.quantNos];
	    int[] n = {0};

	    mostrarFolhas(this.raiz, vet, n);

	    int[] resultado = new int[n[0]];
	    for (int i = 0; i < n[0]; i++) {
	        resultado[i] = vet[i];
	    }

	    return resultado;
	}
	private void mostrarFolhas(NoArv arv, int[] vet, int[] n) {
	    if (arv != null) {

	        mostrarFolhas(arv.getEsq(), vet, n);
	        mostrarFolhas(arv.getDir(), vet, n);

	        if (arv.getEsq() == null && arv.getDir() == null) {
	            vet[n[0]] = arv.getInfo();
	            n[0]++;
	        }
	    }
	}
	
	// Mostrar a soma de todos os numeros da arvore
	public int somarTodos() {
	    int[] soma = {0};
	    
	    fazSomaTodos(this.raiz, soma);
	    return soma[0];
	}
	private void fazSomaTodos(NoArv arv, int[] soma) {
	    if (arv != null) {

	        soma[0] += arv.getInfo();
	        fazSomaTodos(arv.getEsq(), soma);
	        fazSomaTodos(arv.getDir(), soma);
	    }
	}
	
	// Mostrar a soma somente dos numeros pares da arvore
	public int somarPares() {
	    int[] soma = {0};

	    fazSomaPares(this.raiz, soma);

	    return soma[0];
	}
	private void fazSomaPares(NoArv arv, int[] soma) {
	    if (arv != null) {

	        if (arv.getInfo() % 2 == 0) {
	            soma[0] += arv.getInfo();
	        }

	        fazSomaPares(arv.getEsq(), soma);
	        fazSomaPares(arv.getDir(), soma);
	    }
	}
	
	// Mostrar somente os numeros pares
	public int[] mostrarPares() {
	    int[] vet = new int[this.quantNos];
	    int[] n = {0};

	    mostrarPares(this.raiz, vet, n);

	    int[] resultado = new int[n[0]];
	    for (int i = 0; i < n[0]; i++) {
	        resultado[i] = vet[i];
	    }

	    return resultado;
	}
	private void mostrarPares(NoArv arv, int[] vet, int[] n) {
	    if (arv != null) {

	        if (arv.getInfo() % 2 == 0) {
	            vet[n[0]] = arv.getInfo();
	            n[0]++;
	        }

	        mostrarPares(arv.getEsq(), vet, n);
	        mostrarPares(arv.getDir(), vet, n);
	    }
	}
	
	//caminhamento central
	public int [] CamCentral (){
		int [] n = new int[1];
		n[0] = 0;
		int [] vet = new int[this.quantNos];
		return (CamCentral (this.raiz, vet, n));
	}
	private int [] CamCentral (NoArv no, int [] vet, int []n){
		if (no != null) {
			vet = CamCentral (no.getEsq(),vet,n);
			vet[n[0]] = no.getInfo();
			n[0]++;
			vet = CamCentral (no.getDir(),vet,n);
		}
		return vet;
	}
	
	//caminhamento pré-fixado
	public int [] CamPreFixado (){
		int [] n= new int[1];
		n[0] = 0;
		int [] vet = new int[this.quantNos];
		return (CamPreFixado (this.raiz, vet, n));
	}
	private int [] CamPreFixado (NoArv no, int [] vet, int []n){
		if (no != null) {
			vet[n[0]] = no.getInfo();
			n[0]++;
			vet = CamPreFixado (no.getEsq(), vet,n);
			vet = CamPreFixado (no.getDir(), vet,n);
		}
		return vet;
	}
	
	//caminhamento pós-fixado
	public int [] CamPosFixado (){
		int [] n = new int[1];
		n[0] = 0;
		int [] vet = new int[this.quantNos];
		return (CamPosFixado (this.raiz, vet, n));
	}
	private int [] CamPosFixado (NoArv no, int[] vet, int []n){
		if (no != null) {
			vet = CamPosFixado (no.getEsq(), vet,n);
			vet = CamPosFixado (no.getDir(), vet,n);
			vet[n[0]] = no.getInfo();
			n[0]++;
		}
		return vet;
	}
}