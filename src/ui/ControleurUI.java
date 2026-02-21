package ui;

import controleur.Manager;

import javax.swing.*;

/**
 * Ecoute les boutons et met a jour Vue
 */
public class ControleurUI {

    private Vue vue;
    private Manager manager;
    private GestionEntrees entrees;

    public ControleurUI(Vue vue, Manager manager) {
        this.vue = vue;
        this.manager = manager;
        this.entrees = new GestionEntrees();

        initialiserListeners();
    }

    private void initialiserListeners() {
        for (JButton bouton : vue.getBoutons()) {

            bouton.addActionListener(e -> {
                String texte = bouton.getText();
                gererEntree(vue.conversionTexteTouches(texte));
            });
        }
    }

    private void gererEntree(String texte) {

        switch (texte) {
            case "=" -> calculer();
            case "Clear" -> {
                entrees.effacerTout();
                vue.effacerAffichage();
            }
            case "Reset" -> {
                manager.effacerHistorique();
            }
            case "Retour" -> {
                vue.effacerDernier();
                entrees.effacerDernier();
            }
            case "+/-" -> {
                // a implementer pour gerer le changement de signe
            }
            default -> {
                entrees.ajouter(texte);
                vue.afficher(texte);
            }
        }
    }

    private void calculer() {

        String expression = entrees.construire();
        String resultat = manager.faireCalculUI(expression);

        vue.effacerAffichage();
        vue.afficher(resultat);
        vue.ajouterHistorique(expression + " =", resultat);

        entrees.effacerTout();
    }
}

