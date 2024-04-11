package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.Date;

import com.entities.Note;
import com.helper.FactoryProvider;


public class updatenote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updatenote() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int noteId=Integer.parseInt(request.getParameter("noteid").trim());
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			 Session s=FactoryProvider.getFactory().openSession();
			 Transaction tx=s.beginTransaction();
			 Note note=s.get(Note.class,noteId);
			 note.setContent(content);
			 note.setAddedDate(new Date());
			 note.setTitle(title);
			 tx.commit();
			 s.close();
			 response.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
