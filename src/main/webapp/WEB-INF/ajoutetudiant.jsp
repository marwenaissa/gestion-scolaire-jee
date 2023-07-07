<%--
  Created by IntelliJ IDEA.
  User: marwen
  Date: 05/07/2023
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<hS>Ajouter un nouveau etudiant</hs>
<form action="EtudiantServlet" method="Post">
  <table border="1" width="30%">


      <td>Nom</td>
      <td><input type="text" name="nom" /></td>
    </tr>
    <tr>
      <td>Prenom</td>
      <td><input type="text" name="prenom" /></td>
    </tr>
    <tr>
      <input type="hidden" name="action" value="ajouter">

      <td>Cin</td>
      <td><input type="text" name="cin" /></td>
    </tr>
    <tr>
    <tr>
      <td>Email</td>
      <td><input type="text" name="email" /></td>
    </tr>

    <tr>
      <td>Classe</td>
      <td><input type="text" name="idclass" /></td>
    </tr>

    <tr>
      <td colspan="2" ><input type="submit" value="Valider"  /> </td>
    </tr>
  </table>
</form>
</body>
</html>
