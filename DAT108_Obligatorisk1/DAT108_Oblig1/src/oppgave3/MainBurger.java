package oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class MainBurger {

	public static void main(String... strings) {
		AtomicInteger burgerNr = new AtomicInteger(1);
		BlockingQueue<Hamburger> bane = new LinkedBlockingQueue<Hamburger>(5);
		for (int i = 1; i <= 3; i++) {
			new Thread(new Kokk(bane, i, burgerNr)).start();
		}

		for (int i = 1; i <= 2; i++) {
			new Thread(new Servitør(bane, i)).start();
		}

	}

}
