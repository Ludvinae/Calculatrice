package ui;

import controleur.Manager;

import javax.swing.*;

/**
 * Fait le lien entre le Manager et la Vue
 */
public class ControleurUI {

    private final Vue vue;
    private final Manager manager;
    private final GestionEntrees entrees;

    public ControleurUI(Manager manager) {
        this.vue = new Vue();
        this.manager = manager;
        this.entrees = new GestionEntrees();

        vue.creerHistorique(manager.getCalculs());
        initialiserListeners();
    }

    /**
     * Ajoute un ecouteur sur les boutons de la calculatrice
     * Appelle gererEntree avec le contenu du texte des boutons convertis
     */
    private void initialiserListeners() {
        // Itere sur la liste de boutons du panel touches
        for (JButton bouton : vue.getBoutons()) {

            bouton.addActionListener(e -> {
                // Recupere le texte du bouton en le convertissant dans un format utilisable (pas d'emojis)
                String texte = bouton.getText();
                gererEntree(vue.conversionTexteTouches(texte));
            });
        }
    }

    /**
     * Appelle des méthodes spécifiques en fonction du bouton pressé
     * @param texte : récupere le texte associé aux boutons (converti en texte utilisable)
     */
    private void gererEntree(String texte) {
        switch (texte) {
            case "=" -> calculer();
            case "Clear" -> {
                entrees.effacerTout();
                vue.effacerAffichage();
            }
            case "Reset" -> {
                manager.effacerHistorique();
                vue.creerHistorique(manager.getCalculs());
            }
            case "Retour" -> {
                vue.effacerDernier();
                entrees.effacerDernier();
            }
            case "+/-" -> {
                vue.changeSigne(); // a implementer pour gerer le changement de signe
            }
            default -> {
                if (entrees.estTropLong()) return; // Bloque la longueur de l'entrée pour eviter de sortir de l"ecran
                if (entrees.estVide()) vue.effacerAffichage(); // Efface l'affichage quand on commence un nouveau calcul
                entrees.ajouter(texte);
                vue.afficher(texte);
            }
        }
    }

    /**
     * Envoi l'expression saisi au Manager pour recuperer le résultat
     * Puis fait parevenir le résultat a l'affichage
     */
    private void calculer() {
        String expression = entrees.construire();
        String resultat = manager.faireCalculUI(expression);

        vue.effacerAffichage();
        vue.afficher(resultat);
        vue.ajouterHistorique(manager.dernierCalcul());
        vue.rafraichirHistorique();

        entrees.effacerTout();
    }

}

