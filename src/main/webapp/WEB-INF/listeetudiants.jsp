<%@ page import="metier.Etudiant" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: marwen
  Date: 05/07/2023
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <p> cest la liste detudiant</p>
 <a href="EtudiantServlet?path=ajoutetudiant">ajouter un etudiant</a>

 <h1>Liste des étudiants</h1>
 <table>
     <tr>
         <th>Nom</th>
         <th>Prénom</th>
         <th>Email</th>
         <th>Consulter</th>
         <th>Modifier</th>
         <th>Supprimer</th>
     </tr>
     <%
         List<Etudiant> etudiants = null;
         if (request.getAttribute("etudiants") != null) {
             etudiants = (List<Etudiant>) request.getAttribute("etudiants");
         }
         if (etudiants != null && !etudiants.isEmpty()) {
             for (Etudiant etudiant : etudiants) { %>
     <tr>
         <td><%= etudiant.getNom() %></td>
         <td><%= etudiant.getPrenom() %></td>
         <td><%= etudiant.getEmail() %></td>
         <td><a href="EtudiantServlet?action=affichage&nom=<%= etudiant.getNom() %>">Consulter</a></td>
         <td><a href="EtudiantServlet?action=modifier&nom=<%= etudiant.getNom() %>">Modifier</a></td>
         <td><a href="EtudiantServlet?action=suppression&nom=<%= etudiant.getNom() %>">Supprimer</a></td>
     </tr>
     <% }
     } else { %>
     <tr>
         <td colspan="3">Aucun étudiant à afficher.</td>
     </tr>
     <% } %>
 </table>

</body>
</html>
