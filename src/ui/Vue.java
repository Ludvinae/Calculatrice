package ui;


import controleur.Manager;

import javax.swing.*;
import java.awt.*;

public class Vue extends JFrame {

    private final int width = 350;
    private final int height = 480;

    private Manager manager;

    private Touches touches;
    private AffichageUI affichage;

    private StringBuilder entrees;


    public Vue(Manager manager) {
        this.manager = manager;

        // Cree une nouvelle instance de StringBuilder
        entrees = new StringBuilder();

        setSize(width, height);
        setName("Calculatrice");
        // Permet de fermer le programme lorsque l'on ferme la fenetre de l'UI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panneau d'affichage
        affichage = new AffichageUI();
        affichage.setPreferredSize(new Dimension(width, 100));
        setBackground(Color.white);
        // Positionne l'affichage en haut
        add(affichage, BorderLayout.NORTH);

        // Panneau des touches
        touches = new Touches();
        setBackground(Color.BLACK);
        // Positionne les touches au milieu
        add(touches, BorderLayout.CENTER);

        // Ne pas ajouter de composants apres cette commande
        setVisible(true);

        ecouter();
    }

    public void ecouter() {
        // Recupere la liste de boutons du panel touches
        JButton[] boutons = touches.getBoutons();

        for (JButton bouton : boutons) {
            bouton.addActionListener(e -> {
                // Recupere le texte du bouton en le convertissant au prealable en format utilisable (pas d'emojis)
                String texteConverti = touches.conversionEntree(bouton.getText());

                // Envoi le texte soit directement a l'affichage, soit au controleur.Manager
                if (texteConverti.equalsIgnoreCase("=")) {
                    transfertExpression(construitExpression());

                    // Efface l'expression en vue du prochain calcul
                    effecerEntrees();
                }
                else {
                    affichage.afficher(texteConverti);
                    stockerEntrees(texteConverti);
                }
            });
        }
    }

    public void transfertExpression(String expression) {
        String resultat = manager.faireCalculUI(expression);
        affichage.afficher(resultat);
    }

    private void stockerEntrees(String texte) {
        entrees.append(texte);
    }

    private void effecerEntrees() {
        entrees = new StringBuilder();
    }

    private String construitExpression() {
        return entrees.toString();
    }

}
