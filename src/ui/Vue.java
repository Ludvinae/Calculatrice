package ui;

import javax.swing.*;
import java.awt.*;

public class Vue extends JFrame {

    private final int width = 350;
    private final int height = 480;

    public Vue() {
        setSize(width, height);
        setName("Calculatrice");
        // Permet de fermer le programme lorsque l'on ferme la fenetre de l'UI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panneau d'affichage
        JPanel affichage = new JPanel();
        affichage.setPreferredSize(new Dimension(width, 100));
        setBackground(Color.white);
        // Positionne l'affichage en haut
        add(affichage, BorderLayout.NORTH);

        // Panneau des touches
        Panel touches = new Panel();
        setBackground(Color.BLACK);
        // Positionne les touches au milieu
        add(touches, BorderLayout.CENTER);

        // Ne pas ajouter de composants apres cette commande
        setVisible(true);

        lancer();
    }

    public void lancer() {

        while (true){

        }
    }

    public static void main(String[] args) {
        new Vue();
    }
}
