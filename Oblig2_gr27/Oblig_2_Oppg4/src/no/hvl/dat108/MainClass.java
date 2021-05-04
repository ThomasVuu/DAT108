package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainClass
 */
@WebServlet("/MainClass")
public class MainClass extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM 'Klokken' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		String timestamp = formatter.format(date);

		response.setContentType("text/html; charset=ISO-8859-1");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Kvittering</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Hei, " + fornavn + " " + etternavn + "</p>");
		out.println("<p>Din registrering er mottatt " + timestamp + "</p>");
		out.println("</body>");
		out.println("</html>");	}

}
