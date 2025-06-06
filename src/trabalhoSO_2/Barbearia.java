package trabalhoSO_2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;



//todas as alterações às filas de clientes seram feitas pela barbearia
public class Barbearia{
	LinkedList<Cliente> proxCliente = new LinkedList<Cliente>();
	LinkedList<Cliente> cadeiras = new LinkedList<Cliente>();	
	int ocupacao = 0;
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
	
	//Função de ler os clietes
	
	//1 Barbeiro;
	public void casoA() {
		int semClientes = 0;
		while(semClientes < 3) {
			//Se o Sargento estiver acordado
			if (!Tainha.isAlive()) {
				if (ocupacao < 20 && proxCliente.getFirst().tipo != 0) {
					//Se há cadeiras livres, adiciona apenas um cliente
					cadeiras.add(proxCliente.getFirst());
					cadeiras.get(ocupacao).run(); //contar o tempo de espera
					ocupacao++;
					proxCliente.remove();
				}
				else if (ocupacao < 20) {
					semClientes++;
				}
				Tainha.run(); //Tira um cochilo
			}
			
			//Se o Recruta estiver livre
			if(!RecrutaZero.isAlive()) {
				Collections.sort(cadeiras, new SortByTipo());
				if (ocupacao != 0 && cadeiras.getFirst().tipo != 0) {
					// tira o primeiro da fila para cortar o cabelo
					cadeiras.remove();
					RecrutaZero.run(); 
				}
			}
			
		}
		
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
	double tempoSono; //em segundos
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
	}
	
	public void run() {
		while(true) {
			/*loop infinito, para que a thread esteja sempre rodando, assim para checar o tempo se espera simplesemente
			checamos a quanto tempo a thread está viva*/
			 
		}
	}
	
}

class SortByTipo implements Comparator<Cliente> {


	public int compare(Cliente c1, Cliente c2) {
		// TODO Auto-generated method stub
		return Integer.compare(c1.tipo, c2.tipo);
	}
}






