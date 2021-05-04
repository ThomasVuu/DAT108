package no.hvl.dat108;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deltakerliste")
public class DeltakerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltakerDAO deltakerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!LoggInnUt.isLoggedIn(request)) {

			response.sendRedirect("logginn?requiresLogin");

		} else {
			List<Deltaker> deltakere = deltakerDAO.hentAlleDeltakere();
			
			Collections.sort(deltakere, new Comparator<Deltaker>() {

				@Override
				public int compare(Deltaker d1, Deltaker d2) {
					int res = d1.getFornavn().compareTo(d2.getFornavn());
					if (res != 0)
						return res;

					return d1.getEtternavn().compareTo(d2.getEtternavn());
				}

			});
			request.setAttribute("deltakere", deltakere);
			request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);

		}
	}
}
