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
                versAffichage(texte);
            });

            add(bouton);
        }
    }

    public void versAffichage(String texte) {
        if (texte.equals("🔙")) affichage.effacer();
        else affichage.afficher(texte);
    }

    public String envoiEntree(String texte) {
        String entree = "";
        switch (texte) {
            case "Reset": texte = ""; break;
            case "Clear": texte = ""; break;
            case "0": entree = "0"; break;
            case "1": entree = "1"; break;
            case "2": entree = "2"; break;
            case "3": entree = "3"; break;
            case "4": entree = "4"; break;
            case "5": entree = "5"; break;
            case "6": entree = "6"; break;
            case "7": entree = "7"; break;
            case "8": entree = "8"; break;
            case "9": entree = "9"; break;
            case "➕": entree = "+"; break;
            default: entree = "";
        }
        return entree;
    }
}
