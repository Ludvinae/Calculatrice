package ui;

/**
 * Gestion de l'état des entrées utilisateur
 */
public class GestionEntrees {

    private StringBuilder entrees = new StringBuilder();

    /**
     * Ajoute un String au contenu actuel de entrees
     * @param texte: texte à ajouter
     */
    public void ajouter(String texte) { entrees.append(texte); }

    /**
     * Efface tout le contenu de entrees
     */
    public void effacerTout() { entrees = new StringBuilder(); }

    /**
     * Efface le caractere le plus recent dans entrees
     */
    public void effacerDernier() {
        if (!estVide())
            entrees.deleteCharAt(entrees.length() - 1);
    }

    /**
     * Convertis l'objet StringBuilder en objet String
     * @return : version String de entrees
     */
    public String construire() { return entrees.toString(); }

    /**
     * Teste entrees pour savoir si entrees est vide ou non
     * @return : booléen true si entrees est vide, false sinon
     */
    public boolean estVide() { return entrees.isEmpty(); }

    /**
     * Teste pour savoir si entrees depasse 19 caracteres de long
     * @return : booléen true si entrees depasse 19 caracteres de long, false sinon
     */
    public boolean estTropLong() { return entrees.toString().length() >= 20; }
}