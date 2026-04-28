package filaCircular;
public class FilaCircular {
	private int [] info;
	private int frente;
	private int tras;
	private int tamanho;

	public FilaCircular(int tamanho){//qte é o tamanho do vetor
		this.frente = 0;
		this.tras = 0;
		this.tamanho = 0;
		this.info = new int [tamanho];
	}

	public int getInfo(){
		return this.info[this.frente];
	}

	public int getFrente(){
		return this.frente;
	}

	public int getTras(){
		return this.tras;
	}

	public int getTamanho(){
		return this.tamanho;
	}

	public boolean eVazia(){
		return (this.tamanho == 0);
	}

	public boolean eCheia(){
		return (this.tamanho == this.info.length);
	}

	public boolean enfileirar (int elem){
		if (this.eCheia()) return false;
	else {
		this.info[this.tras]= elem;
		this.tras = (++this.tras % this.info.length);
		this.tamanho++;
		return true;
		}
	}
	
	public int desenfileirar(){
		int no;
		if (this.eVazia())
			return -1; //pode mudar o valor de retorno
		else{
			no = this.info[this.frente];
			this.frente = (++this.frente % this.info.length);
			this.tamanho--;
			return no;
		}
	}
	
	//Atv 07 - 1
	public void retirarNegativos() {
		if (!this.eVazia()) {
			int tam = this.tamanho;
			int item;
			for (int i=0; i < tam; i++) {
				item = this.desenfileirar();
				if (item >= 0) {
					this.enfileirar(item);
				}
			}
		}
	}
	
	public String toString(){ //imprimir o conteúdo da fila
		String msg="";
		int aux= this.frente;
		for (int i=1; i <= this.tamanho; i++){
			msg+= this.info[aux] +" ";
			aux= (++aux % this.info.length);
		}
		return msg;
	}
}
