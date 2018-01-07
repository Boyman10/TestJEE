package com.ocr.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocr.bdd.Names;
import com.ocr.beans.BeanException;
import com.ocr.beans.User;

/**
 * Servlet implementation class TestBDD
 */
@WebServlet("/TestBDD")
public class TestBDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestBDD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Names namesTable = new Names();
        request.setAttribute("users", namesTable.getUsers());
        this.getServletContext().getRequestDispatcher("/WEB-INF/bdd.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new  User();
        try {
			user.setName(request.getParameter("name"));
		} catch (BeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        user.setFirstname(request.getParameter("firstname"));
        
        Names namesTable = new Names();
        namesTable.addUser(user);
        
        request.setAttribute("user", namesTable.getUsers());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/bdd.jsp").forward(request, response);
	}

}
