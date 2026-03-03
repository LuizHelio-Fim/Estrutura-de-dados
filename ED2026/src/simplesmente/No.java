package simplesmente;

public class No {
	private int info; //atributo será do tipo de dado necessário para armazenamento
	private No prox;
	
	public No (int elem){
		this.info = elem;
		this.prox = null; //esta linha é opcional, pois o prox é automaticamente definido como null
	}
	
	public int getInfo (){
		return this.info;
	}
	
	public void setInfo(int elem){
		this.info = elem;
	}
	
	public No getProx(){
		return this.prox;
	}
	
	public void setProx(No novoNo){
		this.prox = novoNo;
	}
}
