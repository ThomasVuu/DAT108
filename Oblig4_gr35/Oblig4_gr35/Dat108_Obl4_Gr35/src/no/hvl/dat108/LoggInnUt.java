package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoggInnUt {
	
	public static void loggInn(HttpServletRequest request, Deltaker deltaker) {
		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			sesjon.invalidate();
		}
		sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(120);

		sesjon.setAttribute("deltaker", deltaker);
	}
	
	
	public static boolean isLoggedIn(HttpServletRequest req) {
		HttpSession sesjon = req.getSession(false);
		if(sesjon==null) 
			return false;
		
		return sesjon.getAttribute("deltaker")!=null;
		
		
		
	}
	
	public static void loggUt(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
        if (sesjon != null) {
            sesjon.invalidate();
        }
	}

}
