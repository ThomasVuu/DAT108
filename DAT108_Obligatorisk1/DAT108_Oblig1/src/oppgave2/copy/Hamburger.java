package oppgave2.copy;

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
