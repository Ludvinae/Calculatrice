package ui;

import java.awt.*;

public record Theme(Color couleurFond, Color couleurTouches, Color couleurAffichage, Color couleurPolice,
                    Color couleurSecondaire) {

    /**
     * Constructeur du theme par défaut
     */
    public Theme() {
        this(new Color(240, 245, 255), Color.WHITE, Color.WHITE, Color.BLACK, new Color(140, 185, 250));
    }
}
