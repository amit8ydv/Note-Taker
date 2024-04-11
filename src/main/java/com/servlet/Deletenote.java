package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class Deletenote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Deletenote() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	
	int note_id=Integer.parseInt(request.getParameter("note_id"));
	Session s=  FactoryProvider.getFactory().openSession();
	   Transaction tx=s.beginTransaction();
	Note note=s.get(Note.class,note_id);
	s.remove(note);
	   tx.commit();
	   s.close();
	   response.sendRedirect("all_notes.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
