package ui;

/**
 * Gestion de l'état des entrées utilisateur
 */
public class GestionEntrees {

    private StringBuilder entrees = new StringBuilder();

    public void ajouter(String texte) { entrees.append(texte); }

    public void effacerTout() { entrees = new StringBuilder(); }

    public void effacerDernier() {
        if (!estVide())
            entrees.deleteCharAt(entrees.length() - 1);
    }

    public String construire() { return entrees.toString(); }

    public boolean estVide() { return entrees.isEmpty(); }
}