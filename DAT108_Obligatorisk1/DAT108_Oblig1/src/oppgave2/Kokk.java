package oppgave2;

public class Kokk extends Thread {
	private Rutsjebane bane;
	private String navn;

	public Kokk(Rutsjebane bane, int nr) {
		this.bane = bane;
		this.navn = "Kokk" + nr;
	}

	@Override
	public void run() {
		while (true) {
			Hamburger burger = lagBurger();
			synchronized (bane) {
				while (bane.erFull()) {
					System.out.println(
							"### " + this.navn + " er klar med en hamburger, men rutsjebanen er full. Venter! ###");

					try {
						bane.wait();
					} catch (InterruptedException e) {
					}

				}

				bane.leggPaaBurger(burger);
				System.out
						.println(this.navn + " legger på en hamburger " + burger.getName() + " => " + bane.toString());
				bane.notifyAll();
			}
		}

	}

	private Hamburger lagBurger() {
		int leftLimit = 2000;
		int rightLimit = 6000;
		int randomLong = leftLimit + (int) (Math.random() * (rightLimit - leftLimit));

		try {
			sleep(randomLong);
		} catch (InterruptedException e) {
		}

		return new Hamburger(bane.getBurgerNr());
	}

}
