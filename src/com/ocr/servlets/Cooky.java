package com.ocr.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cooky
 */
@WebServlet("/Cooky")
public class Cooky extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cooky() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// retrieve cookier :
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for(Cookie cookie : cookies)
				if(cookie.getName().equals("login"))
					request.setAttribute("login",cookie.getValue());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/cookie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the submitted variables :
		String name = request.getParameter("name");
		String login = request.getParameter("login");

		Cookie cookie = new Cookie("login",login);
		// set expiration date :
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		doGet(request, response);
	}

}
