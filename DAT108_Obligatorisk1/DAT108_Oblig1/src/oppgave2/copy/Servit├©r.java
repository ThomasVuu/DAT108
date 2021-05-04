package oppgave2.copy;

import java.util.Queue;

public class Servitør implements Runnable {
	private Queue<Hamburger> bane;
	private String navn;

	public Servitør(Queue<Hamburger> bane, int nr) {
		this.bane = bane;
		this.navn = "Servitør" + nr;
	}

	@Override
	public void run() {
		while (true) {
			taBestilling();
			synchronized (bane) {
				while (bane.isEmpty()) {
					System.out
							.println("### " + this.navn + " vil ta en hamburger, men rutsjebanen er tom. Venter! ###");

					try {
						bane.wait();
					} catch (InterruptedException e) {
					}

				}

				Hamburger burger = bane.remove();
				System.out.println(this.navn + " tar av hamburger   " + burger.toString() + " => " + bane.toString());
				bane.notifyAll();
			}
		}

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
