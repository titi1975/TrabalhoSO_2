package trabalhoSO_2;

public class Barbeiro extends Thread {
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
