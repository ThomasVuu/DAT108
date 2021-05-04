package no.hvl.dat108;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logginn")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@EJB
	private DeltakerDAO deltakerDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginMessage = "";

		if (request.getParameter("requiresLogin") != null) {
			loginMessage = "Forespørselen din krever pålogging. " 
							+ "(Du kan ha blitt logget ut automatisk)";

		} else if (request.getParameter("invalidUser") != null) {
			loginMessage = "Ugyldig brukernavn og/eller passord";
		}

		request.setAttribute("loginMessage", loginMessage);

		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String brukernavn = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		Deltaker deltaker = null;
		if(Validator.isValidUsername(brukernavn) && Validator.isValidPassword(passord))
			deltaker = deltakerDAO.hentDeltakerMedID(brukernavn);

		if (deltaker == null || !Passordhjelper.valider(passord, deltaker.getPassord())) {
			response.sendRedirect("logginn?invalidUser");

		}else {
			LoggInnUt.loggInn(request, deltaker);
			response.sendRedirect("deltakerliste");
		}

	}

}
