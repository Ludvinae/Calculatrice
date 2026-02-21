package ui;

import javax.swing.*;

public class Historique extends JPanel {

    public Historique() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void ajouterCalcul(String expression, String resultat) {
        ComposantCalcul calcul = new ComposantCalcul(expression, resultat);

        // Ajoute le dernier calcul en haut
        add(calcul, 0);

        // Rafraichis l'affichage
        revalidate();
        repaint();
    }


}
