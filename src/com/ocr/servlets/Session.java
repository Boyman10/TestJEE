package com.ocr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session
 * Working with sessions
 */
@WebServlet("/Session")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 2L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Session() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			// Get the session parameter : 
			
			HttpSession sess = request.getSession();
			String login = (String) sess.getAttribute("login");
			
			// in case of logout :
			//sess.invalidate();
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/session.jsp").forward(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
			
			// Get the submitted variables :
			String name = request.getParameter("name");
			String login = request.getParameter("login");
			
			// initialize session and store the data : 
			HttpSession sess = request.getSession();
			sess.setAttribute("login", login);
			sess.setAttribute("name", name);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/session.jsp").forward(request, response);
		}

	}

