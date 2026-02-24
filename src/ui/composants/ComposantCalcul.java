package ui.composants;

import ui.Theme;

import javax.swing.*;
import java.awt.*;

public class ComposantCalcul extends JPanel {

    /**
     * Permet de construire un panel composé de deux labels
     * @param expression: valeurs affichées dans le label du haut
     * @param resultat: valeur affichée dans le label du bas
     * @param theme: references de couleurs
     */
    protected ComposantCalcul(String expression, String resultat, Theme theme) {
        setLayout(new BorderLayout());
        setBackground(theme.couleurFond());

        JLabel expressionLabel = new JLabel(expression);
        expressionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        expressionLabel.setAlignmentX(RIGHT_ALIGNMENT);

        JLabel resultatLabel = new JLabel(resultat);
        resultatLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultatLabel.setAlignmentX(RIGHT_ALIGNMENT);

        setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        setAlignmentX(Component.RIGHT_ALIGNMENT);

        add(expressionLabel, BorderLayout.NORTH);
        add(resultatLabel, BorderLayout.CENTER);
    }
}
