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
 * Servlet implementation class PrikazPojedinacneOsobe
 */
@WebServlet("/PrikazPojedinacneOsobe")
public class PrikazPojedinacneOsobe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrikazPojedinacneOsobe() {
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
		ArrayList<Osoba> osobe = (ArrayList<Osoba>) servletContext.getAttribute("osobe");
		response.getWriter().append("<html><body><p>Ime: ");
		response.getWriter().append(osobe.get(Integer.parseInt(request.getQueryString())).getIme());
		response.getWriter().append("</p><p>Prezime: ");
		response.getWriter().append(osobe.get(Integer.parseInt(request.getQueryString())).getPrezime());
		response.getWriter().append("</p><p>Korisnicko ime: ");
		response.getWriter().append(osobe.get(Integer.parseInt(request.getQueryString())).getKorIme());
		response.getWriter().append("</p><p>Lozinka: ");
		response.getWriter().append(osobe.get(Integer.parseInt(request.getQueryString())).getLozinka());
		response.getWriter().append("</html></body> ");
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
