package oppgave1;

public class Tekst {
	
	private String tekst;
	private boolean stopp =false;
	
	public Tekst(String txt) {
		this.tekst = txt;
	}

	public synchronized String getTekst() {
		return tekst;
	}
	
	public boolean stopp() {
		return stopp;
	}

	public synchronized void setTekst(String tekst) {
		if(tekst.equals("quit")) {
			stopp = true;
		}
		this.tekst = tekst;
	} 
	
	
}
