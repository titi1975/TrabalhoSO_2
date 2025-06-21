package trabalhoSO_2;

public class Sargento extends Thread {
	double tempoSono; //em segundos
	Sargento(double tempoSono) {
		this.tempoSono = tempoSono;
	}
	
	/**
	 * dormir
	 */
	public void run() {
		try {
			wait((long)(tempoSono*(1000)));
		}
		catch(Exception e) {
			
		}
	}
}
