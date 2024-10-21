package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Osoba;

/**
 * Servlet implementation class PrikazOsobaServlet
 */
@WebServlet("/PrikazOsobaServlet")
public class PrikazOsobaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrikazOsobaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext servletContext = getServletContext();
//		String ime = (String) servletContext.getAttribute("ime");
//		String prezime = (String) servletContext.getAttribute("prezime");
		
		ArrayList<Osoba> osobe = (ArrayList<Osoba>) servletContext.getAttribute("osobe");

		response.getWriter().append("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Prikaz osobe</title>\r\n" + "</head>\r\n" + "<body>\r\n" + "\r\n");

		for (int i = 0; i < osobe.size(); i++) {
			int ivece = i + 1;
			response.getWriter().append("<h1> Osoba broj: " + ivece + "</h1>");
			response.getWriter().append("<p>Ime: " + osobe.get(i).getIme() + "</p>");
			response.getWriter().append("<p>Prezime: " + osobe.get(i).getPrezime() + "</p>");
			response.getWriter().append("<p>Korisnicko ime: " + osobe.get(i).getKorIme() + "</p>");
			response.getWriter().append("<p>Lozinka: " + osobe.get(i).getLozinka() + "</p>");
			response.getWriter().append("<a href=PrikazPojedinacneOsobe?" + i + ">Prikazi ovu osobu</a>");
			response.getWriter().append("<a href=BrisanjePojedinacneOsobe?" + i + ">Obrisi ovu osobu</a>");
			response.getWriter().append("<a href=IzmenaOsobe?" + i + ">Izmeni ovu osobu</a>");
		}

		response.getWriter().append("\r\n<a href=DodavanjeOsobe.html>Povratak</a>" + "</body>\r\n" + "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
