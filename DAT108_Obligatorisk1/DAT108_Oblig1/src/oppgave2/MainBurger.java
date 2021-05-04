package oppgave2;

public class MainBurger {
	
	public static void main(String...strings ) {
		
		Rutsjebane bane = new Rutsjebane();
		for(int i = 1; i<=3; i++) {
			Kokk kokk = new Kokk(bane, i);
			kokk.start();
		}
		
		for(int i = 1; i<=2; i++) {
			Servitør servitør = new Servitør(bane, i);
			servitør.start();
		}
		
		
	}

}
