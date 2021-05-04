package oppgave3;

import java.util.concurrent.BlockingQueue;

public class Servitør implements Runnable {
	private BlockingQueue<Hamburger> bane;
	private String navn;

	public Servitør(BlockingQueue<Hamburger> bane, int nr) {
		this.bane = bane;
		this.navn = "Servitør" + nr;
	}

	@Override
	public void run() {
		try {
		while (true) {
			taBestilling();
			if (bane.peek() == null) {
				System.out
						.println("### " + this.navn + " vil ta en hamburger, men rutsjebanen er tom. Venter! ###");

			}
			Hamburger burger = bane.take();
			System.out.println(this.navn + " tar av hamburger   " + burger.toString() + " => " + bane.toString());
		}
		}catch(InterruptedException e) {}

	}

	private void taBestilling() {
		int leftLimit = 2000;
		int rightLimit = 6000;
		int randomLong = leftLimit + (int) (Math.random() * (rightLimit - leftLimit));

		try {
			Thread.sleep(randomLong);
		} catch (InterruptedException e) {
		}
	}

}
