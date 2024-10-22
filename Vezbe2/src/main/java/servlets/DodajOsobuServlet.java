package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Osoba;

/**
 * Servlet implementation class DodajOsobuServlet
 */
@WebServlet("/DodajOsobuServlet")
public class DodajOsobuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DodajOsobuServlet() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String korimeString = request.getParameter("korime");
		String lozinkaString = request.getParameter("lozinka");

		ServletContext servletContext = getServletContext();
		ArrayList<Osoba> osobe = (ArrayList<Osoba>) servletContext.getAttribute("osobe");
		osobe.add(new Osoba(ime, prezime, korimeString, lozinkaString));


		response.sendRedirect("./PrikazOsobaServlet");
		doGet(request, response);
	}

}
