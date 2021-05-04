package oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Kokk implements Runnable {
	private BlockingQueue<Hamburger> bane;
	private String navn;
	private AtomicInteger burgerNr;

	public Kokk(BlockingQueue<Hamburger> bane, int nr, AtomicInteger burgerNr) {
		this.bane = bane;
		this.navn = "Kokk"+nr;
		this.burgerNr=burgerNr;
	}

	@Override
	public void run() {
		try {
		while (true) {
			Hamburger burger = lagBurger();
			
			if(!bane.offer(burger)) {
				System.out.println(
						"### " + navn + " er klar med en hamburger, men rutsjebanen er full. Venter! ###");
				bane.put(burger);
			}
			
			System.out.println(this.navn + " legger på en hamburger " + burger.toString() + " => " + bane.toString()); 

		}
		}catch(InterruptedException e) {
			
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

		return new Hamburger(burgerNr.getAndIncrement());
	}
	

}
