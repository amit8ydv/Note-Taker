package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.entities.Note;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaveNoteServlet() {
        super();
   
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			Note note=new Note(title,content,new Date());
	   Session s=  FactoryProvider.getFactory().openSession();
	   Transaction tx=s.beginTransaction();
	   s.persist(note);
	   tx.commit();
	   s.close();
	   response.setContentType("text/html");
	   PrintWriter out=response.getWriter();
	   response.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
