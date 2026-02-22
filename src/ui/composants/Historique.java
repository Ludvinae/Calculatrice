package ui.composants;


import ui.Theme;

import javax.swing.*;

public class Historique extends JPanel {

    public Historique() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(RIGHT_ALIGNMENT);
    }

    public void ajouterCalcul(String expression, String resultat, Theme theme) {
        ComposantCalcul calcul = new ComposantCalcul(expression, resultat, theme);

        // Ajoute le dernier calcul en haut
        add(calcul, 0);
    }

    /**
     * Rafraichis l'affichage de l'historique
     */
    public void rafraichisHistorique() {
        revalidate();
        repaint();
    }
}
