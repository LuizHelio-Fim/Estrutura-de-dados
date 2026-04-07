package pilha;
public class PilhaContig {
	private int [] info;
	private int topo;
	public PilhaContig(int qte){
		this.topo = 0;
		this.info = new int [qte];
	}
	public int getInfo(){
		return this.info[this.topo-1];
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
	//inserir um novo dado no topo da pilha.
	public boolean push (int elem){
		if (this.eCheia()) {
			return false;
		}else {
			this.info[this.topo++]= elem;
			return true;
		}
	}
	//remove o dado que está no topo da pilha (somente por vez).
	public int pop(){
		if (this.eVazia()) {
			return -1; //este valor de retorno pode ser alterado
		}else{
			return this.info[--this.topo];
		}
	}
}