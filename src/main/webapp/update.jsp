<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.Note"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>
<div class="container ">
<%@include file="navbar.jsp" %>
<h1 style="text-align:center">Update your note</h1>

<% int note_id=Integer.parseInt(request.getParameter("note_id").trim());

Session s=FactoryProvider.getFactory().openSession();
Note note=(Note)s.get(Note.class,note_id);
%>

<form action="updatenote" method="post">
<input type="hidden" value="<%=note.getId()%>" name="noteid">
  <div class="mb-3">
    <label for="title" class="form-label">Title</label>
    <input name="title" required type="text" class="form-control" id="title" placeholder="Enter title hare" value="<%=note.getTitle()%>"/>
    
  </div>
  <div class="mb-3">
    <label for="content" class="form-label">Note Content</label>
    <textarea name= "content" required id="content" class="form-control" placeholder="Enter content here" style="height:300px">
  <%=note.getContent() %></textarea>
  </div>
  
  <div class="buttoncontainer text-center"><button type="submit" class="btn btn-primary">Save</button></div>
</form> </div>


</body>
</html>