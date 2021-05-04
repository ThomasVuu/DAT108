package no.hvl.dat108;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name= "PaameldingServlet", urlPatterns = "/paamelding")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltakerDAO deltakerDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Paameldingsskjema skjema = new Paameldingsskjema(request);

		if (skjema.allInputGyldig()) {
			Deltaker d = deltakerDAO.hentDeltakerMedID(skjema.getMobil());

			if (d == null) {
				d = new Deltaker(skjema);
				deltakerDAO.lagreNyDeltaker(d);
				LoggInnUt.loggInn(request, d);
				request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
			} else {
				skjema.ikkeUniktBrukernavn();
				request.getSession().setAttribute("skjema", skjema);
				response.sendRedirect("paamelding");
			}

		} else {
			skjema.settOppFeilmeldinger();
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("paamelding");
		}
	}

}
