package oppgave2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Rutsjebane {
	private Queue<Hamburger> banen;
	private int maxSize;
	private boolean full = false;
	private boolean tom = true;
	private int burgerNr = 1;

	public Rutsjebane() {
		banen = new LinkedList<Hamburger>();
		this.maxSize = 5;
	}

	public boolean erFull() {
		return full;
	}

	public boolean erTom() {
		return tom;
	}

	public void leggPaaBurger(Hamburger burger) {
		banen.add(burger);
		if (banen.size() == maxSize) {
			full = true;
		}
		tom = false;
		burgerNr++;
	}

	public Hamburger taBurger() {
		Hamburger burger = banen.remove();
		if (banen.size() == 0)
			tom = true;

		full = false;

		return burger;
	}

	public int getBurgerNr() {
		return burgerNr;
	}

	public String toString() {
		Iterator<Hamburger> i = banen.iterator();
		String str = "[";
		while (i.hasNext()) {
			Hamburger e = i.next();
			if (i.hasNext()) {
				str += e.getName() + ",";
			} else {
				str += e.getName();
			}

		}

		return str + "]";
	}
}
