package pakke;

public class Validator {
	
	public static boolean erGyldigPassord(String passord, String riktigPassord) {
		
		if(passord == null) {
			return false;
		}
		return passord.matches(riktigPassord);
	}

}
