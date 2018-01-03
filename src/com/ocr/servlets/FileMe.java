package com.ocr.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ocr.forms.Connection;

/**
 * Servlet implementation class Test - our Controller Class
 * https://www.ntu.edu.sg/home/ehchua/programming/java/JavaServlets.html
 */
@WebServlet("/FileMe")
public class FileMe extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	// A few configuration parameters for file upload :
	public static final int SIZE_TAMPON = 10240;
	public static final String FILE_FOLDER = "/home/bob/Downloads/";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileMe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/fileme.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // We retrieve the description field :
        String description = request.getParameter("description");
        request.setAttribute("description", description );

        // Now the file field :
        Part part = request.getPart("myfile");
            
        // Check if file is correct :
        String fileName = getFileName(part);

        // If we have a file :
        if (fileName != null && !fileName.isEmpty()) {
            String fieldName = part.getName();
            // fix IE problem
            fileName = fileName.substring(fileName.lastIndexOf('/') + 1)
                    .substring(fileName.lastIndexOf('\\') + 1);

            // Store the file at home :
            writeFile(part, fileName, FILE_FOLDER);

            request.setAttribute(fieldName, fileName);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/fileme.jsp").forward(request, response);		
	}

    private void writeFile( Part part, String fileName, String spot ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), SIZE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(spot + fileName)), SIZE_TAMPON);

            byte[] tampon = new byte[SIZE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }
    
    private static String getFileName( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }   
}
