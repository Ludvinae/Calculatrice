package ui.composants;

import javax.swing.*;
import java.awt.*;

public class AffichageUI extends JPanel {

    JLabel label = new JLabel();

    public AffichageUI() {
        add(label);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
    }

    public void afficher(String caractere) {
        label.setText(label.getText() + caractere);
    }

    public void effacer() {
        if (label.getText().isEmpty()) return;
        label.setText(label.getText().substring(0, label.getText().length() - 1));
    }

    public void effacerTout() {
        label.setText("");
    }
}
