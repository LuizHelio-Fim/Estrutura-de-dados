package duplamente;
public class NoDupla {
	private int info; //este tipo de dado pode ser mudado
	private NoDupla prox;
	private NoDupla ant;
	
	public NoDupla (int elem){
		this.info = elem;
		this.prox = null;
		this.ant = null;
	}
	
	public int getInfo (){
		return this.info;
	}
	public NoDupla getProx(){
		return this.prox;
	}
	public NoDupla getAnt(){
		return this.ant;
	}
	
	public void setInfo(int novo) {
		this.info = novo;
	}
	public void setProx(NoDupla novoNo){
		this.prox = novoNo;
	}
	public void setAnt(NoDupla novoNo){
		this.ant = novoNo;
	}
}