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
 * Servlet implementation class IzmenaOsobe
 */
@WebServlet("/IzmenaOsobe")
public class IzmenaOsobe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzmenaOsobe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		ArrayList<Osoba> osobe = (ArrayList<Osoba>) servletContext.getAttribute("osobe");
		String kveriString = request.getQueryString();
		
		response.getWriter().append("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Izmena osobe</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h1>izmeni ovu osobu: </h1>\r\n"
				+ "\r\n"
				+ "<form action=\"IzmenaOsobe?" + kveriString + "\" method=\"POST\">\r\n"
				+ "	<label>Ime:</label>\r\n"
				+ "	<input type=\"text\" name=\"imee\" value=\""  + osobe.get(Integer.parseInt(request.getQueryString())).getIme()  +  "\" />\r\n"
				+ "	<label>Prezime:</label>\r\n"
				+ "	<input type=\"text\" name=\"prezimee\" value=\"" + osobe.get(Integer.parseInt(request.getQueryString())).getPrezime() + "\"/>\r\n"
				+ "	<button type=\"submit\">Potvrdi</button>\r\n"
				+ "</form>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext = getServletContext();
		ArrayList<Osoba> osobe = (ArrayList<Osoba>) servletContext.getAttribute("osobe");
		
		String imeString = request.getParameter("imee");
		String prezimeString = request.getParameter("prezimee");
		
		osobe.get(Integer.parseInt(request.getQueryString())).setIme(imeString);
		osobe.get(Integer.parseInt(request.getQueryString())).setPrezime(prezimeString);
		
		response.sendRedirect("./PrikazOsobaServlet");
		
		doGet(request, response);
	}

}
