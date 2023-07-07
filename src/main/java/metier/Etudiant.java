package metier;

public class Etudiant {

    private Integer cin;
    private String nom;
    private String prenom;
    private String email;

    private Integer idclasse;

    public Etudiant(int cin, String nom, String prenom, String email , int idclasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cin = cin;
        this.idclasse = idclasse;
    }


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getCin() {
        return this.cin;
    }

    public void setCin(Integer cin) {
        this.cin = cin;
    }

    public Integer getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Integer idclasse) {
        this.idclasse = idclasse;
    }
}
