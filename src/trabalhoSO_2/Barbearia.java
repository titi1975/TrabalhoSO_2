package trabalhoSO_2;

//todas as alterações às filas de clientes seram feitas pela barbearia
public class Barbearia{
	Cliente[] cadeiras = new Cliente[20];
	Barbeiro RecrutaZero;
	Barbeiro Dentinho;
	Barbeiro Otto;
	Sargento Tainha;
	
	public Barbearia(int tempoSono) {
		RecrutaZero = new Barbeiro();
		Dentinho = new Barbeiro();
		Otto = new Barbeiro();
		Tainha = new Sargento(tempoSono);
	}
	
	//1 Barbeiro;
	public void casoA() {
		
	}
	
	//2 Barbeiros;
	public void casoB() {
			
	}
	
	//3 barbeiros, 1 para cada tipo de cliente;
	public void casoC() {
		
	}

	 public static void main(String[] args) {

	 }
}

	
class Barbeiro extends Thread {
	int cliente;
	long tempoAtendimento;

	
	public Barbeiro() {
	}
	
	//cortar cabelo
	public void run(int index, Cliente[] cadeiras){ // tell it to my heart tell me i'm the only one
		try {
			cliente = cadeiras[index].tipo;
			double rng = Math.random();
			if (cliente < 3) tempoAtendimento =  (long)(rng*(2000) + 1000*cliente);
			else tempoAtendimento = (long)(rng*(2000) + 4000);
			wait(tempoAtendimento);
		}
		catch (Exception e) {
			System.out.println(e + " at Barbeiro.run()");
		}
	}
}

class Sargento extends Thread {
	double tempoSono;
	Sargento(double tempoSono) {
		this.tempoSono = tempoSono;
	}
	
	//dormir
	public void run() {
		try {
			wait((long)(tempoSono*(1000)));
		}
		catch(Exception e) {
			
		}
	}
}

class Cliente extends Thread {
	int tipo;
	
	public Cliente(int tipo) {
		this.tipo = tipo;
		run(); //começa a contar a espera desde que é criado;
	}
	
	public void run() {
		while(true) {
			/*loop infinito, para que a thread esteja sempre rodando, assim para checar o tempo se espera simplesemente
			checamos a quanto tempo a thread está viva*/
			 
		}
	}
	
}




