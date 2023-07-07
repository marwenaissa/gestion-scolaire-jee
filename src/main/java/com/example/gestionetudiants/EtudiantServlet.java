package com.example.gestionetudiants;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.Etudiant;
import metier.Listeetudiants;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "EtudiantServlet", value = "/EtudiantServlet")
public class EtudiantServlet extends HttpServlet {
    private Listeetudiants etudiants; // Déclaration de la variable etudiants

    public void init() throws ServletException {
        etudiants = new Listeetudiants();
        // Récupérer les données depuis la base de données et les ajouter à la liste etudiants
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost:3306/gestion_scolaire";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM etudiant");
            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                Integer cin = resultSet.getInt("cin");
                Integer idclasse = resultSet.getInt("id_class");
                Etudiant etudiant = new Etudiant(cin , nom, prenom, email , idclasse);
                etudiants.add(etudiant);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        String action = request.getParameter("action");
        String nom = request.getParameter("nom");

        if (etudiants == null) {
            etudiants = new Listeetudiants(); // Initialisation de la variable etudiants
        }
        if (action != null) {
            if (action.equals("affichage")) {
                afficherEtudiants(request, response  , nom);
            } else if (action.equals("suppression")) {
                supprimerEtudiant(request, response , nom);
            }else {
                // Action invalide
                response.sendRedirect("error.jsp");
            }
        }else if (path != null) {
            /*PrintWriter pr = response.getWriter();
            pr.println("<html><head>bienvenu</head><body>");
            for (Etudiant etudiant : etudiants.getEtudiants()) {
                pr.println("<p>Nom : " + etudiant.getNom() + "</p>");
                pr.println("<p>Prenom : " + etudiant.getPrenom() + "</p>");
                pr.println("<p>Email : " + etudiant.getEmail() + "</p>");
                pr.println("<hr>");
            }
            pr.println("</body></html>");*/
            request.setAttribute("etudiants", etudiants.getEtudiants());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/"+path+".jsp");
            // Transférez le contrôle à la JSP
            dispatcher.forward(request, response);
        }else {
            // Action non spécifiée
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (etudiants == null) {
            etudiants = new Listeetudiants(); // Initialisation de la variable etudiants
        }
        if (action != null) {
            if (action.equals("ajouter")) {
                try {
                    ajouterEtudiant(request, response );
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if (action.equals("modifier")) {
                modifierEtudiant(request, response );
            } else {
                // Action invalide
                response.sendRedirect("error.jsp");
            }
        } else {
            // Action non spécifiée
            response.sendRedirect("error.jsp");
        }
    }

    private void ajouterEtudiant(HttpServletRequest request, HttpServletResponse response  ) throws ServletException, IOException, SQLException {
        //response.setContentType("text/html");
        //PrintWriter pr = response.getWriter();
        //pr.println("<html><body>");
        //pr.println("<h1>ameur ayari titre</h1>");
        //pr.println("</body></html>");
        //Résupcer ies information
        String cinstr = request.getParameter("cin");
        int cin = Integer.parseInt(cinstr);
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String idclassstr = request.getParameter("idclass");
        int idclass = Integer.parseInt(idclassstr);
        //Afficher les information
        int lastInsertedId = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost:3306/gestion_scolaire";
            String username = "root";
            String password = "";
            Connection cn = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement pr = cn.prepareStatement("INSERT INTO etudiant VALUES(?,?,?,?,?)");
            pr.setInt(1, cin);
            pr.setString(2, nom);
            pr.setString(3, prenom);
            pr.setString(4, email);
            pr.setInt(5, idclass);
            pr.execute();
        } catch (Exception e) {
            // TO0O Auto-generated catch block
            e.printStackTrace();
        }
        Etudiant e = new Etudiant(cin, nom, prenom, email , 1);
        etudiants.add(e);
        request.setAttribute("etudiants", etudiants.getEtudiants());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listeetudiants.jsp");
        // Transférez le contrôle à la JSP
        dispatcher.forward(request, response);
    }

    private void afficherEtudiants(HttpServletRequest request, HttpServletResponse response ,  String nom ) throws ServletException, IOException {
        /*PrintWriter pr = response.getWriter();
        pr.println("<html><head>bienvenu</head><body>");
        for (Etudiant etudiant : etudiants.getEtudiants()) {
            pr.println("<p>Nom : " + etudiant.getNom() + "</p>");
            pr.println("<p>Prenom : " + etudiant.getPrenom() + "</p>");
            pr.println("<p>Email : " + etudiant.getEmail() + "</p>");
            pr.println("<hr>");
        }
        pr.println("</body></html>");*/


        Etudiant et = etudiants.getEtudiantByNom(nom);

        request.setAttribute("etudiantnom",  et.getNom());
        request.setAttribute("etudiantprenom",  et.getPrenom());
        request.setAttribute("etudiantemail",  et.getEmail());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/consulteretudiant.jsp");
        // Transférez le contrôle à la JSP
        dispatcher.forward(request, response);
    }

    private void modifierEtudiant(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        // Logique pour modifier un étudiant
        // Récupérer les paramètres du formulaire
        // Effectuer les opérations de modification dans la base de données
        // Rediriger vers une page de succès ou d'échec
    }
    private void supprimerEtudiant(HttpServletRequest request, HttpServletResponse response  , String nom) throws ServletException, IOException {

    }
}
