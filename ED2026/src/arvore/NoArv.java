package arvore;

public class NoArv {
	
	private int info; 
	private NoArv esq, dir;
	
	public NoArv(int elem){
		this.info = elem;
		this.esq = null;
		this.dir = null;
	}
	
	public NoArv getEsq(){
		return this.esq;
	}
	
	public NoArv getDir(){
		return this.dir;
	}
	
	public int getInfo(){
		return this.info;
	}
	
	public void setEsq(NoArv no){
		this.esq = no;
	}
	
	public void setDir(NoArv no){
		this.dir = no;
	}
	
	public void setInfo(int elem){
		this.info = elem;
	}
}