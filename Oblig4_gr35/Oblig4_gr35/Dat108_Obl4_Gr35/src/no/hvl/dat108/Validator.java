package no.hvl.dat108;

import java.util.List;

public class Validator {
	
	private static final String GYLDIG_FORNAVN = "^[A-ZÆØÅ][-a-zA-ZæøåÆØÅ ]{1,19}$";
	private static final String GYLDIG_ETTERNAVN = "^[A-ZÆØÅ][-a-zA-ZæøåÆØÅ]{1,19}$";
	private static final String GYLDIG_MOBIL = "^[0-9]{8}$";
	private static final String GYLDIG_PASSORD = "^.{6,20}$";
	
	public static boolean isValidUsername(String brukernavn) {
		
		if (brukernavn == null) 
			return false;
        
        return brukernavn.matches(GYLDIG_MOBIL);
		
	}
	
	public static boolean isUniqueUsername(String mobil, List<Deltaker>deltakere) {
		if(deltakere.size()==0 || !isValidUsername(mobil)) 
			return true; 
		
		return deltakere.stream().anyMatch(D -> D.getMobil().equals(mobil));
	}
	
	public static boolean isValidFirstName(String fornavn) {
		if (fornavn == null) 
			return false;
		
		return fornavn.matches(GYLDIG_FORNAVN);
        
	}
	
	public static boolean isValidLastName(String etternavn) {
		if (etternavn == null) 
            return false;
        
		return etternavn.matches(GYLDIG_ETTERNAVN);
	}
	
	public static boolean isValidPassword(String passord) {
		if (passord == null) 
            return false;
		
		return passord.matches(GYLDIG_PASSORD);
        
	}
	
    public static boolean isValidRepeatedPassword(String passord, String repetertPassord) {
    	
    	if(repetertPassord == null || passord == null) 
    		return false;
    	
    	return repetertPassord.equals(passord);
    }
    
    

}
