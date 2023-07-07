<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>



<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<a href="EtudiantServlet?path=listeetudiants">servlet etudiant</a>

<a href="EtudiantServlet?action=affichage&id=id">servlet etudiant</a>
<a href="EtudiantServlet?action=suppression&id=id">servlet etudiant</a>

<a href="ClasseServlet">servlet classe</a>

<h3>Tutoriel J2EE (ISP, Servlet, MVC et JDBC)</h3>


</body>
</html>