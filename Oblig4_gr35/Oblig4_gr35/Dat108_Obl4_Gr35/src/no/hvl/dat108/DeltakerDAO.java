package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeltakerDAO {

	@PersistenceContext(name = "deltakerPU")
	private EntityManager em;

	public Deltaker hentDeltakerMedID(String brukernavn) {

		return em.find(Deltaker.class, brukernavn);
	}
	
	public List<Deltaker> hentAlleDeltakere() {
		return em.createQuery("SELECT d FROM Deltaker d", Deltaker.class).getResultList();
	}
	
	public void lagreNyDeltaker(Deltaker nyDeltaker) {
		em.persist(nyDeltaker);
	}
	
	

}
