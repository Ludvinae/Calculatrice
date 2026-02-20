package ui;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    String[] texteBoutons = {
            "Reset", "Clear", "🔙", "➗",
            "7️", "8", "9", "✖️",
            "4", "5", "6", "➖",
            "1", "2", "3", "➕",
            "+/-", "0", ".", "🟰"
    };

    AffichageUI affichage;

    public Panel(AffichageUI affichage) {
        this.affichage = affichage;

        setOpaque(false);
        setLayout(new GridLayout(5, 4, 5, 5));

        arrangement();
    }

    private void arrangement() {
        for (String texte : texteBoutons) {
            JButton bouton = new JButton(texte);
            bouton.setBackground(new Color(211, 211, 211));
            bouton.setPreferredSize(new Dimension(50, 50));

            bouton.addActionListener(e -> {
                versAffichage(envoiEntree(texte));
            });

            add(bouton);
        }
    }

    public void versAffichage(String texte) {
        if (texte.equalsIgnoreCase("Retour")) affichage.effacer();
        else if (texte.equalsIgnoreCase("Clear")) affichage.effacerTout();
        // Ajouter les cas manquants
        else affichage.afficher(texte);
    }

    public String envoiEntree(String texte) {
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
