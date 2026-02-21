package ui;

import java.awt.*;

public class Theme {

    private final Color couleurFond;
    private final Color couleurTouches;
    private final Color couleurAffichage;
    private final Color couleurPolice;
    private final Color couleurSecondaire;

    public Theme(Color couleurFond, Color couleurTouches, Color couleurAffichage, Color couleurPolice, Color couleurSecondaire) {
       this.couleurFond = couleurFond;
       this.couleurTouches = couleurTouches;
       this.couleurAffichage = couleurAffichage;
       this.couleurPolice = couleurPolice;
       this.couleurSecondaire = couleurSecondaire;
    }

    public Color getCouleurFond() {
        return couleurFond;
    }

    public Color getCouleurTouches() {
        return couleurTouches;
    }

    public Color getCouleurAffichage() {
        return couleurAffichage;
    }

    public Color getCouleurPolice() {
        return couleurPolice;
    }

    public Color getCouleurSecondaire() {
        return couleurSecondaire;
    }
}
