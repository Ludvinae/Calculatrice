package ui;

import javax.swing.*;

public class AffichageUI extends JPanel {

    JLabel label;

    public void afficher(String caractere) {
        label.setText(label.getText() + caractere);
    }

    public void effacer() {
        label.setText(label.getText().substring(0, label.getText().length() - 1));
    }
}
