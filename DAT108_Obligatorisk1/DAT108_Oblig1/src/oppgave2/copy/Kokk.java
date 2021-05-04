package oppgave2.copy;

import java.util.Queue;

public class Kokk implements Runnable {
	private Queue<Hamburger> bane;

	private String navn;
	private Teller burgerNr; 

	public Kokk(Queue<Hamburger> bane, int nr, Teller burgerNr) {
		this.bane = bane;
		this.navn = "Kokk" + nr;
		this.burgerNr = burgerNr;
	}

	@Override
	public void run() {
		while (true) {
			Hamburger burger = lagBurger();
			synchronized (bane) {
				while (bane.size() == 5) {
					System.out.println(
							"### " + this.navn + " er klar med en hamburger, men rutsjebanen er full. Venter! ###");
					try {
						bane.wait();
					} catch (InterruptedException e) {
					}

				}

				bane.add(burger);
				System.out.println(
						this.navn + " legger på en hamburger " + burger.toString() + " => " + bane.toString());
				bane.notifyAll();
			}
		}

	}

	private Hamburger lagBurger() {
		int leftLimit = 2000;
		int rightLimit = 6000;
		int randomLong = leftLimit + (int) (Math.random() * (rightLimit - leftLimit));

		try {
			Thread.sleep(randomLong);
		} catch (InterruptedException e) {
		}

		return new Hamburger(burgerNr.getTall());
	}

}
