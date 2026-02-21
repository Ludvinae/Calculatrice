package ui;

import javax.swing.*;
import java.awt.*;

public class Touches extends JPanel {

    private String[] texteBoutons = {
            "Reset", "Clear", "🔙", "➗",
            "7️", "8", "9", "✖️",
            "4", "5", "6", "➖",
            "1", "2", "3", "➕",
            "+/-", "0", ".", "🟰"
    };

    private JButton[] boutons = new JButton[texteBoutons.length];

    public Touches() {
        setOpaque(false);
        setLayout(new GridLayout(5, 4, 5, 5));

        arrangement();
    }

    public JButton[] getBoutons() {
        return boutons;
    }

    private void arrangement() {
        for  (int i = 0; i < texteBoutons.length; i++) {
            // Récupere le texte a afficher sur le bouton et crée un bouton avec ce texte
            String texte = texteBoutons[i];
            JButton bouton = new JButton(texte);

            bouton.setBackground(new Color(211, 211, 211));
            bouton.setPreferredSize(new Dimension(75, 75));

            // Ajoute le bouton a un tableau
            boutons[i] = bouton;

            // Ajoute le bouton au panel Touches
            add(bouton);
        }
    }

    /*
    public void versAffichage(String texte) {
        if (texte.equalsIgnoreCase("Retour")) affichage.effacer();
        else if (texte.equalsIgnoreCase("Clear")) affichage.effacerTout();
        // Ajouter les cas manquants
        else affichage.afficher(texte);
    }
     */

    public String conversionEntree(String texte) {
        String entree;
        switch (texte) {
            case "➕": entree = "+"; break;
            case "➖": entree = "-"; break;
            case "✖️": entree = "*"; break;
            case "➗": entree = "/"; break;
            case "🔙": entree = "Retour"; break;
            case "🟰": entree = "="; break;
            default: entree = texte;
        }
        return entree;
    }
}
