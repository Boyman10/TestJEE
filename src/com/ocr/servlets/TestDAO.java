package com.ocr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocr.beans.User;
import com.ocr.dao.DaoException;
import com.ocr.dao.UserDao;
import com.ocr.dao.factory.DaoFactory;

/**
 * Servlet implementation class TestDAO
 */
@WebServlet("/TestDAO")
public class TestDAO  extends HttpServlet {
	
	private static final long serialVersionUID = 7L;

    private UserDao utilisateurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = daoFactory.getUserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("users", utilisateurDao.list());
        }
        catch (DaoException e) {
            request.setAttribute("erreur", e.getMessage());
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/dao.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        try {
            User utilisateur = new User();
            utilisateur.setName(request.getParameter("name"));
            utilisateur.setFirstname(request.getParameter("firstname"));
            
            utilisateurDao.add(utilisateur);
            request.setAttribute("users", utilisateurDao.list());
        }
        catch (Exception e) {
            request.setAttribute("erreur", e.getMessage());
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/dao.jsp").forward(request, response);
    }
    
    

}