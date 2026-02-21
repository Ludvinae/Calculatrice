package ui.composants;

import ui.Theme;

import javax.swing.*;
import java.awt.*;

public class Touches extends JPanel {

    private final String[] texteBoutons = {
            "Reset", "Clear", "🔙", "➗",
            "7", "8", "9", "✖️",
            "4", "5", "6", "➖",
            "1", "2", "3", "➕",
            "+/-", "0", ".", "🟰"
    };

    private final JButton[] boutons = new JButton[texteBoutons.length];
    private final Theme theme;

    public Touches(Theme theme) {
        this.theme = theme;

        setOpaque(false);
        setLayout(new GridLayout(5, 4, 5, 5));
        setBackground(theme.couleurFond());

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

            // Toutes les touches sont de la meme couleur, sauf la touche egal
            if (texte.equalsIgnoreCase("🟰")) bouton.setBackground(theme.couleurSecondaire());
            else bouton.setBackground(theme.couleurTouches());
            bouton.setPreferredSize(new Dimension(75, 75));

            // Ajoute le bouton a un tableau
            boutons[i] = bouton;

            // Ajoute le bouton au panel Touches
            add(bouton);
        }
    }

    public String conversionEntree(String texte) {
        String entree = switch (texte) {
            case "➕" -> "+";
            case "➖" -> "-";
            case "✖️" -> "*";
            case "➗" -> "/";
            case "🔙" -> "Retour";
            case "🟰" -> "=";
            default -> texte;
        };
        return entree;
    }
}
