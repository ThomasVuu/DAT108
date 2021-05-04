package pakke;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.cxf.transport.commons_text.StringEscapeUtils;

@WebServlet(name = "Butikk servlet", urlPatterns = "/butikk")
public class HandlelisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Login suksess!

		boolean tomInput = request.getParameter("tomInput") != null;

		response.setContentType("text/html; charset=ISO-8859-1");

		HttpSession sesjon = request.getSession(false);

		VareListe varer = (VareListe) sesjon.getAttribute("varer");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Handleliste</title>");
		out.println("</head>");
		out.println("<body>");

		if (tomInput) {
			out.println("<p> Skriv et navn på produktet du ønkser å legge til i Handlelisten </p>");
			System.out.println("hei");
		}
		out.println("<h2>Min handleliste</h2>");
		out.println("<form action=\"butikk\" method=\"post\">");
		out.println("<p><input type=\"submit\" name=\"leggtil\" value=\"Legg til\" />");
		out.println("<input type=\"text\" name=\"vare\"></p>");
		out.println("</form>");

		for (Vare v : varer.getItems()) {

			out.println("<p> <form action=\"butikk\" method=\"post\">");
			out.println("<input type=\"hidden\" name = \"vare_id\" value=" + varer.getId(v) + ">");
			out.println("<input type=\"submit\" value=\"Slett\" />");
			out.println(v.toString() + "</form></p>");

		}

		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Legg til en vare:
		HttpSession sesjon = request.getSession(false);

		if (sesjon == null) {
			response.sendRedirect("login");
		} else {

			VareListe varer = (VareListe) sesjon.getAttribute("varer");
			String vareId = request.getParameter("vare_id");

			if (vareId == null) {
				String vareNavn = request.getParameter("vare");
				if (vareNavn != null) {
					vareNavn = StringEscapeUtils.escapeHtml4(vareNavn);
					varer.addItem(new Vare(vareNavn));
				}

			} else {

				int id = Integer.parseInt(vareId);
				varer.slettVare(id);

			}

			response.sendRedirect("butikk");

		}
	}
}
