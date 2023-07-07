package metier;


import java.util.ArrayList;
public class Listeetudiants {

    private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

    public ArrayList<Etudiant> getEtudiants() {
        return this.etudiants;
    }

    public void add(Etudiant e) {
        this.etudiants.add(e);
    }

    public void remove(String id) {
        for (Etudiant e : etudiants) {
            if (e.getNom() == id) { // equals
                this.etudiants.remove(e);
                break;
            }
        }
    }
    public Etudiant getEtudiantByNom(String nom) {
        for (Etudiant e : this.etudiants) {
            if (e.getNom().equals(nom)) {
                return e;
            }
        }
        return null; // Si aucun étudiant n'est trouvé avec l'ID donné
    }
}


