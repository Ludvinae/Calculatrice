package ui.composants;

import javax.swing.*;
import java.awt.*;

/**
*	Panneau d'affichage de la calculatrice
*/
public class AffichageUI extends JPanel {

    JLabel label = new JLabel("");

    public AffichageUI() {
        add(label);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 28));
    }

	/**
	*	Ajoute un String a la suite du label
	* @Param caractere: caractere à ajouter 
	*/
    public void afficher(String caractere) {
        label.setText(label.getText() + caractere);
    }

	/**
	*	Efface le caratere le plus recent du label
	*/
    public void effacer() {
        if (label.getText().isEmpty()) return;
        label.setText(label.getText().substring(0, label.getText().length() - 1));
    }

	/**
	*	Efface tout le label
	*/
    public void effacerTout() {
        label.setText("");
    }
}
