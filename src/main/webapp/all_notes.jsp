<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your All Notes</title>
    <%@include file="all_js_css.jsp" %>
</head>
<body>
<div class="container">
   <%@include file="navbar.jsp" %>
   
   <h1 style="text-align: center">Your All Notes</h1>
   
   <% Session s=FactoryProvider.getFactory().openSession();
   Query q= s.createQuery("from Note");
      List<Note> list1=q.list();
      for(Note nt:list1)
      {
    	  %>
    	  <div class="card mt-3" >
    	  
    	  <div class="card-body">
    	    <h5 class="card-title"><%=nt.getTitle()%></h5>
    	    <p class="card-text"><%=nt.getContent()%></p>
    	    <div class="container text-center">
    	    <a href="Deletenote?note_id=<%=nt.getId()%>" class="btn btn-danger">Delete</a>
             <a href="update.jsp?note_id=<%=nt.getId() %>" class="btn btn-primary">Update</a>
             </div>
    	  </div>
    	</div>
    	<% 
    	  
      }
      %>
      </div>
</body>
</html>