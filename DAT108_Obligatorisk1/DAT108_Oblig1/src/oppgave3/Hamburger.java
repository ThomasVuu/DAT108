package oppgave3;

public class Hamburger {
	
	private String name;
	
	public Hamburger (int nr) {
		this.name = "("+nr+")";
		
	}

	@Override
	public String toString() {
		return name;
	}

	
	

}
