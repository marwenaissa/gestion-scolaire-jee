<%--
  Created by IntelliJ IDEA.
  User: marwen
  Date: 06/07/2023
  Time: 01:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Détails de l'étudiant</h1>



<p>Nom : <%= request.getAttribute("etudiantnom") %></p>
<p>Nom : <%= request.getAttribute("etudiantprenom") %></p>
<p>Nom : <%= request.getAttribute("etudiantemail") %></p>

<!-- Autres informations à afficher -->

</body>
</html>




