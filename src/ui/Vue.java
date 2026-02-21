package ui;


import controleur.Manager;
import historique.Calcul;

import javax.swing.*;
import java.util.List;
import java.awt.*;

public class Vue extends JFrame {

    private final int width = 490;
    private final int height = 525;
    private final Theme theme;

    private Manager manager;

    private Touches touches;
    private AffichageUI affichage;
    private Historique historique;

    private StringBuilder entrees;


    public Vue(Manager manager) {
        this.manager = manager;
        // Crée le theme
        theme = new Theme();
        // Cree une nouvelle instance de StringBuilder
        entrees = new StringBuilder();

        configurerFrame();
        initialiserUI();
        ecouter();

        // Ne pas ajouter de composants apres cette commande
        setVisible(true);
    }

    private void configurerFrame() {
        setSize(width, height);
        setName("Calculatrice");
        // Permet de fermer le programme lorsque l'on ferme la fenetre de l'UI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void initialiserUI() {
        // Panneau central pour l'affichage et les touches
        JPanel panelCentral = new JPanel();

        panelCentral.setBackground(theme.getCouleurFond());

        // Panneau d'affichage
        affichage = new AffichageUI();
        affichage.setPreferredSize(new Dimension(width, 80));
        affichage.setBackground(theme.getCouleurAffichage());
        affichage.setBorder(BorderFactory.createLineBorder(theme.getCouleurPolice()));
        // Positionne l'affichage en haut
        panelCentral.add(affichage, BorderLayout.NORTH);

        // Panneau des touches
        touches = new Touches(theme);
        touches.setBackground(theme.getCouleurFond());
        // Positionne les touches au milieu
        panelCentral.add(touches, BorderLayout.CENTER);

        // Panneau de l'historique
        historique = new Historique(theme);
        historique.setPreferredSize(new Dimension(150, height - 40));
        historique.setBackground(theme.getCouleurFond());
        creerHistorique();

        // Place l'historique dans un composant JScroll pour pouvoir faire defiler les calculs si ils sont nombreux
        JScrollPane scroll = new JScrollPane(historique);
        scroll.setViewportView(historique);

        // Empeche le scroll horizontal
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Place le panel central et l'historique dans la frame
        add(panelCentral, BorderLayout.CENTER);
        add(scroll, BorderLayout.EAST);


    }

    private void ecouter() {
        // Recupere la liste de boutons du panel touches
        JButton[] boutons = touches.getBoutons();

        for (JButton bouton : boutons) {
            bouton.addActionListener(e -> {
                // Recupere le texte du bouton en le convertissant au prealable en format utilisable (pas d'emojis)
                String texteConverti = touches.conversionEntree(bouton.getText());

                // Envoi le texte soit directement a l'affichage, soit au controleur Manager
                if (texteConverti.equalsIgnoreCase("=")) envoiVersManager();
                else if (texteConverti.equalsIgnoreCase("Retour")) effacerDerniereEntree();
                else if (texteConverti.equalsIgnoreCase("Clear")) effacerEntrees();
                else if (texteConverti.equalsIgnoreCase("Reset")) manager.effacerHistorique();
                else if (texteConverti.equalsIgnoreCase("+/-")); // Cas a implementer
                else afficherEntree(texteConverti);
            });
        }
    }

    private void gererEntree(String texte) {
        switch (texte) {
            case "=" -> envoiVersManager();
            case "Retour" -> effacerDerniereEntree();
            case "Clear" -> effacerEntrees();
            case "Reset" -> {
                manager.effacerHistorique();
                creerHistorique();
            }
            case "+/-" -> changeSigne();
            default -> afficherEntree(texte);
        }
    }

    private void envoiVersManager() {
        affichage.effacerTout();
        transfertExpression(construitExpression());

        // Efface l'expression en vue du prochain calcul
        entrees = new StringBuilder();

        // A décommenté quand la methode pour recuperer le dernier calcul sera implementée
                    /*
                    Calcul calcul = manager.dernierCalcul();
                    String expression = calcul.getValeur1Db() + " " + calcul.getOperateurDb() + " " + calcul.getValeur2Db() + " =";
                    String resultat = manager.formatResultat(calcul.getResultatDb());
                    historique.ajouterCalcul(expression, resultat);
                     */
    }

    public void transfertExpression(String expression) {
        String resultat = manager.faireCalculUI(expression);
        affichage.afficher(resultat);
        affichage.repaint();
    }

    private String construitExpression() {
        return entrees.toString();
    }

    private void effacerDerniereEntree() {
        affichage.effacer();
        entrees.deleteCharAt(entrees.length() - 1);
    }

    private void effacerEntrees() {
        affichage.effacerTout();
        entrees = new StringBuilder();
    }

    private void creerHistorique() {
        // Vide l'historique
        historique.removeAll();

        List<Calcul> calculs = manager.getCalculs();
        for (Calcul calcul : calculs) {

            // Ideallement, creer des methodes dans la Classe Calcul pour recuperer directement le bon formatage
            String expression = calcul.getValeur1Db() + " " + calcul.getOperateurDb() + " " + calcul.getValeur2Db() + " =";
            String resultat = manager.formatResultat(calcul.getResultatDb());

            historique.ajouterCalcul(expression, resultat);
        }
        historique.rafraichisHistorique();
    }

    private void changeSigne() {
        // A implementer
    }

    private void afficherEntree(String texte) {
        if (entrees.isEmpty()) affichage.effacerTout();
        affichage.afficher(texte);
        entrees.append(texte);
    }
}
