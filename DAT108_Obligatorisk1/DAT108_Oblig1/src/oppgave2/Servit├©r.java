package oppgave2;

public class Servitør extends Thread{
	private Rutsjebane bane;
	private String navn;

	public Servitør(Rutsjebane bane, int nr) {
		this.bane = bane;
		this.navn = "Servitør" + nr;
	}

	@Override
	public void run() {
		while (true) {
			taBestilling();
			synchronized (bane) {
				while (bane.erTom()) {
					System.out.println(
							"### " + this.navn + " vil ta en hamburger, men rutsjebanen er tom. Venter! ###");

					try {
						bane.wait();
					} catch (InterruptedException e) {
					}

				}
				
				Hamburger burger = bane.taBurger();
				System.out.println(this.navn + " tar av hamburger   " + burger.getName() + " => " + bane.toString()); //legg til print av bane
				bane.notifyAll();
			}
		}

	}

	private void taBestilling() {
		int leftLimit = 2000;
		int rightLimit = 6000;
		int randomLong = leftLimit + (int) (Math.random() * (rightLimit - leftLimit));

		try {
			sleep(randomLong);
		} catch (InterruptedException e) {
		}

	}

}

