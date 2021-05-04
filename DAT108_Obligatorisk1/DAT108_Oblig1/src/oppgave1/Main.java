package oppgave1;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String... strings) {
		Tekst tekst = new Tekst("Hallo verden!");

		Thread printTraad = new Thread(new Runnable() {

			@Override
			public void run() {

				while (!tekst.stopp()) {
					System.out.println(tekst.getTekst());
					try {
						Thread.sleep(3_000);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}

			}

		});

		Thread lesTraad = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!tekst.stopp()) {
					String nyMelding = JOptionPane.showInputDialog("Skriv inn din melding, quit for å slutte");
					tekst.setTekst(nyMelding);

				}

			}

		});

		printTraad.start();
		lesTraad.start();
	}
}
