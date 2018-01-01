package com.ocr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocr.forms.Connection;

/**
 * Servlet implementation class Test - our Controller Class
 * https://www.ntu.edu.sg/home/ehchua/programming/java/JavaServlets.html
 */
@WebServlet("/Forms")
public class Forms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forms() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/forms.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
        String str = request.getParameter("str");
        
        request.setAttribute("str", str);
        
        Connection f = new Connection();
        f.verifyId(request);
        
        request.setAttribute("form",f);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/forms.jsp").forward(request, response);		
	}

}
