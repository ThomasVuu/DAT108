package no.hvl.dat108;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig4")
public class Deltaker {
	 	@Id
	 	private String mobil;
	    private String fornavn;
	    private String etternavn;
	    @Embedded
	    private Passord passord;
	    private String kjonn;
	    
		public Deltaker(Paameldingsskjema skjema) {
			this.fornavn = skjema.getFornavn();
			this.etternavn = skjema.getEtternavn();
			this.mobil = skjema.getMobil();
			this.passord = Passord.lagPassord(skjema.getPassord());
			this.kjonn = skjema.getKjonn(); 
		}
		
		public Deltaker() {}

		public String getMobil() {
			return mobil;
		}

		public void setMobil(String mobil) {
			this.mobil = mobil;
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

		public Passord getPassord() {
			return passord;
		}

		public void setPassord(Passord passord) {
			this.passord = passord;
		}

		public String getKjonn() {
			return kjonn;
		}

		public void setKjonn(String kjonn) {
			this.kjonn = kjonn;
		}

}
