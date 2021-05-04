package pakke;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Logg inn servlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean ugyldigPassord = request.getParameter("ugyldigPassord") != null;

		response.setContentType("text/html; charset=ISO-8859-1");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		if (ugyldigPassord) {
			out.println("<p> Passordet du ga inn var feil. Prøv igjen! </p>");
		}
		out.println("<form action=\"login\" method=\"post\">");
		out.println("<p>Gi inn passord:</p>");
		out.println("<input type=password name=\"pw\" /><br>");
		out.println("<br> <input type=\"submit\" value=\"Logg inn\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		response.setContentType("text/html; charset=ISO-8859-1");


		String passord = request.getParameter("pw");
		String riktigPassord = getServletConfig().getInitParameter("passord");
		int intervall = Integer.parseInt(getServletConfig().getInitParameter("maxInactive"));
	

		if (!Validator.erGyldigPassord(passord, riktigPassord)) {
			response.sendRedirect("login" + "?ugyldigPassord");
		} else {

			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);
			sesjon.setMaxInactiveInterval(intervall); // går aldri ut med "0"

			sesjon.setAttribute("varer", new VareListe());

			response.sendRedirect("butikk");
		}

	}

}
