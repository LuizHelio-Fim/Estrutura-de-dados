package contigua;

public class ListaContig {
	private int fim;
	private int [] info;
	
	public ListaContig(int tamanho){
		this.fim = 0;
		this.info = new int [tamanho];
	}
	
	public int getInfo(int i){
		return this.info[i];
	}
	
	public void setInfo(int i, int elem){
		this.info[i]=elem;
	}
	
	public int getFim(){
		return this.fim;
	}
	
	public void setFim(int _fim){
		this.fim = _fim;
	}
	
	public boolean eVazia (){
		return (this.fim == 0);
	}
	
	public boolean eCheia (){
		return (this.fim == this.info.length);
	}
	
	//retorna verdadeiro se conseguiu inserir o novo nó no final na lista.
	public boolean inserirUltimo (int elem){
		if (this.eCheia()){
			return false;
		} else {
			this.info[this.fim]= elem;
			this.fim++;
			return true;
		}
	}
	
	//retorna a posição do nó caso ele seja encontrado, caso contrário, retorna
	//o valor do this.fim simbolizando que não foi encontrado.
	public int pesquisarNo (int x){
		int i = 0;
		while ((i < this.fim) && (this.info[i] != x)){
			i++;
		}
		return i;
	}
	
	//retorna verdadeiro se conseguiu remover um nó especifico.
	public boolean removerNo (int x){
		int i = 0;
		while ((i < this.fim) && (this.info[i] != x)){
			i++;
		}
		if (i == this.fim){
			return false;
		}else{
			for (int j = i; j < this.fim-1 ;j++){
				this.info[j] = this.info[j+1];
			}
			this.fim--;
			return true;
		}
	}
	
	//insere um novo elemento depois de um determinado numero
	public boolean inserirApos(int x,int num) {
		if (this.eCheia()) return false;
		
		int pos = this.pesquisarNo(x);
		if (pos == this.fim) return false;
		
		for (int i=this.fim; i>pos+1;i--) {
			this.info[i] = this.info[i-1];
		}
		this.info[pos+1] = num;
		this.fim++;
		
		return true;
		
	}
	
	//retorna uma String com todo o conteúdo da lista.
	public String toString(){
		String msg="";
		for (int i=0; i < this.fim; i++){
			msg += this.info[i] + "\n";
		}
		return msg;
	}
}