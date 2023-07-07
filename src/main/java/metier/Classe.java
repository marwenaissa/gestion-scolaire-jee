package metier;

public class Classe {

    private String nom;

    // Constructeur par défaut
    public Classe() {
        // Initialisation par défaut
        this.nom = "Nom par défaut";
    }

    // Constructeur paramétré
    public Classe(String nom) {
        this.nom = nom;
    }

    // Getter et Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
