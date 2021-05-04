package oppgave2.copy;

public class Teller {

	int tall = 0; 
	
	public synchronized int getTall() {
		tall++;
		return tall; 
		
	}

}
