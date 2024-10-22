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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		// TODO Login trenutno resetuje listu osoba, pa radi samo sa admin
		// kredencijalima, moze se resiti citanjem iz txt fajla
		ArrayList<Osoba> osobeArrayList = new ArrayList<Osoba>();

		osobeArrayList.add(new Osoba("admin", "admin", "admin", "admin"));

		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("osobe", osobeArrayList);

		String unetoImeString = request.getParameter("korime");
		String unetaLozinkaString = request.getParameter("lozinka");

		for (Osoba osoba : osobeArrayList) {
			if (unetoImeString.equals(osoba.getKorIme()) && unetaLozinkaString.equals(osoba.getLozinka())) {
				response.sendRedirect("./DodavanjeOsobe.html");
			} else {
				response.sendRedirect("./NeuspeliLogin.html");
			}

		}

		doGet(request, response);
	}

}
