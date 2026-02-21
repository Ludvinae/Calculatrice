package ui;

import javax.swing.*;
import java.awt.*;

public class composantCalcul extends JPanel {

    public composantCalcul(String expression, String resultat) {
        setLayout(new BorderLayout());

        JLabel expressionLabel = new JLabel(expression);
        expressionLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel resultatLabel = new JLabel(resultat);
        resultatLabel.setFont(new Font("Arial", Font.BOLD, 16));

        add(expressionLabel, BorderLayout.NORTH);
        add(resultatLabel, BorderLayout.CENTER);
    }
}
