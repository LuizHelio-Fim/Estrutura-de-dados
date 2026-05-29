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