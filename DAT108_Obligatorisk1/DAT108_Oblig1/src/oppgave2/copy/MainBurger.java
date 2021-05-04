package oppgave2.copy;

import java.util.LinkedList;

import java.util.Queue;

public class MainBurger {
	
	public static void main(String...strings ) {
		
		Teller teller = new Teller();
		
		Queue<Hamburger>bane = new LinkedList<Hamburger>();
		
		for(int i = 1; i<=3; i++) {
			new Thread(new Kokk(bane, i, teller)).start();
		}

		for(int i = 1; i<=2; i++) {
			new Thread(new Servitør(bane, i)).start();
		
		
	}

}

}