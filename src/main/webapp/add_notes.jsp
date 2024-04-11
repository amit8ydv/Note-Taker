<%@page language="java" contentType="text/html; charset=UTF-8"
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
<h1 style="text-align:center">Fill your note</h1>

<form action="SaveNoteServlet" method="post">
  <div class="mb-3">
    <label for="title" class="form-label">Title</label>
    <input name="title" required type="text" class="form-control" id="title"  placeholder="Enter title hare">
    
  </div>
  <div class="mb-3">
    <label for="content" class="form-label">Note Content</label>
    <textarea name= "content" required id="content" class="form-control" placeholder="Enter content here" style="height:300px"></textarea>
  </div>
  
  <div class="container text-center"><button type="submit" class="btn btn-primary">Submit</button></div>
</form> </div>



</body>
</html>