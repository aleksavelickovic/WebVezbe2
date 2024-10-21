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
 * Servlet implementation class DodajOsobuServlet
 */
@WebServlet("/DodajOsobuServlet")
public class DodajOsobuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Osoba> Osobe = new ArrayList<Osoba>();

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

		Osobe.add(new Osoba(ime, prezime));

		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("osobe", Osobe);

		response.sendRedirect("./PrikazOsobaServlet");
//		doGet(request, response);
	}

}
