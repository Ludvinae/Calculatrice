package ui;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    String[] texteBoutons = {
            "+", "7", "8", "9",
            "-", "4", "5", "6",
            "x", "1", "2", "3",
            "/", ".", "0", "="
    };

    public Panel() {
        setLayout(new GridLayout(4, 4));

        arrangement();
    }

    private void arrangement() {
        for (String texte : texteBoutons) {
            Bouton bouton = new Bouton(texte);
            add(bouton);
        }
    }
}
