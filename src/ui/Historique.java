package ui;

import javax.swing.*;

public class Historique extends JPanel {

    private JPanel[] calculs;

    public Historique() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void ajouterCalculs() {
        for  (JPanel calcul : calculs) {
            add(calcul);
        }
    }


}
