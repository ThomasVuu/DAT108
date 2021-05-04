package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

public class Paameldingsskjema {
	
	private String fornavn;
	private String etternavn;
	private String mobil;
	private String passord;
	private String passordRepetert;
	private String kjonn; 
	private String fornavnFeilmelding;
	private String etternavnFeilmelding;
	private String mobilFeilmelding;
	private String passordFeilmelding;
	private String passordRepetertFeilmelding;
	private String kjonnFeilmelding;
	private String kvinneChecked;
	private String mannChecked;
	
	public Paameldingsskjema(HttpServletRequest request) {
		this.fornavn = escapeHtml(request.getParameter("fornavn"));
		this.etternavn = escapeHtml(request.getParameter("etternavn"));
		this.mobil = escapeHtml(request.getParameter("mobil"));
		this.passord = escapeHtml(request.getParameter("passord"));
		this.passordRepetert = escapeHtml(request.getParameter("passordRepetert"));
		this.kjonn = escapeHtml(request.getParameter("kjonn"));
	}
	
	public boolean allInputGyldig() {
		return Validator.isValidFirstName(fornavn) && Validator.isValidLastName(etternavn)
				&& Validator.isValidPassword(passord) && Validator.isValidRepeatedPassword(passord,passordRepetert)
				&& Validator.isValidUsername(mobil);
	}
	
	public void settOppFeilmeldinger() {
		if(!Validator.isValidFirstName(fornavn)) {
			fornavnFeilmelding = fornavn;
			fornavn = "";
		}
		if(!Validator.isValidLastName(etternavn)) {
			etternavn ="";
			etternavnFeilmelding = "Ugyldig etternavn";
		}
		if(!Validator.isValidPassword(passord)) {
			passord="";
			passordFeilmelding ="Ugyldig passord";
		}
		if(!Validator.isValidRepeatedPassword(passord, passordRepetert)) {
			passordRepetert ="";
			passordRepetertFeilmelding = "Passordene må være like";
		}
		if(!Validator.isValidUsername(mobil)) {
			mobil = "";
			mobilFeilmelding = "Ugyldig mobil";
		}
		if(kjonn==null) {
			kjonnFeilmelding = "Du må oppgi kjønn"; 
		}else if(kjonn.equals("mann")) {
			mannChecked = "CHECKED";
		}else {
			kvinneChecked = "CHECKED";
		}
	}
	
	public void ikkeUniktBrukernavn() {
		mobil = "";
		mobilFeilmelding = "Mobilnummeret eksisterer i databasen fra før.";
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	public String getFornavnFeilmelding() {
		return fornavnFeilmelding;
	}

	public String getEtternavnFeilmelding() {
		return etternavnFeilmelding;
	}

	public String getMobilFeilmelding() {
		return mobilFeilmelding;
	}

	public String getPassordFeilmelding() {
		return passordFeilmelding;
	}

	public String getPassordRepetertFeilmelding() {
		return passordRepetertFeilmelding;
	}

	public String getKjonnFeilmelding() {
		return kjonnFeilmelding;
	}

	public String getKvinneChecked() {
		return kvinneChecked;
	}

	public String getMannChecked() {
		return mannChecked;
	}

	public String getPassordRepetert() {
		return passordRepetert;
	}
	private String escapeHtml(String s) {
        String resultat = s;
        if(resultat== null)
        	return resultat; 
        resultat = resultat.replaceAll("<", "&lt;");
        resultat = resultat.replaceAll(">", "&gt;");
        resultat = resultat.replaceAll("\"", "&quot;");
        return resultat;
    }

}
