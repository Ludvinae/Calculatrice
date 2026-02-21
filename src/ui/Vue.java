package ui;


import controleur.Manager;
import historique.Calcul;
import ui.composants.AffichageUI;
import ui.composants.Historique;
import ui.composants.Touches;

import javax.swing.*;
import java.util.List;
import java.awt.*;

/**
 * Construit l'UI et expose les methodes pour la manipuler
 */
public class Vue extends JFrame {

    private final int WIDTH = 490;
    private final int HEIGHT = 525;
    private final Theme theme;

    // a enlever quand refactor creer historique
    private final Manager manager;

    private Touches touches;
    private AffichageUI affichage;
    private Historique historique;


    public Vue(Manager manager) {
        this.manager = manager;
        // Crée le theme
        theme = new Theme();

        configurerFrame();
        initialiserUI();

        // Ne pas ajouter de composants apres cette commande
        setVisible(true);
    }

    private void configurerFrame() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);

        setName("Calculatrice");
        // Fait apparaitre la fenetre au milieu de l'ecran
        setLocationRelativeTo(null);
        // Permet de fermer le programme lorsque l'on ferme la fenetre de l'UI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void initialiserUI() {
        // Panneau central pour l'affichage et les touches
        JPanel panelCentral = new JPanel();

        panelCentral.setBackground(theme.couleurFond());

        // Panneau d'affichage
        affichage = new AffichageUI();
        affichage.setPreferredSize(new Dimension(WIDTH, 80));
        affichage.setBackground(theme.couleurAffichage());
        affichage.setBorder(BorderFactory.createLineBorder(theme.couleurPolice()));
        // Positionne l'affichage en haut
        panelCentral.add(affichage, BorderLayout.NORTH);

        // Panneau des touches
        touches = new Touches(theme);
        touches.setBackground(theme.couleurFond());
        // Positionne les touches au milieu
        panelCentral.add(touches, BorderLayout.CENTER);

        // Panneau de l'historique
        historique = new Historique(theme);
        historique.setBackground(theme.couleurFond());
        creerHistorique();

        // Place l'historique dans un composant JScroll pour pouvoir faire defiler les calculs si ils sont nombreux
        JScrollPane scroll = new JScrollPane(historique);
        scroll.setPreferredSize(new Dimension(150, 0));
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        scroll.setViewportView(historique);

        // Empeche le scroll horizontal
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Place le panel central et l'historique dans la frame
        add(panelCentral, BorderLayout.CENTER);
        add(scroll, BorderLayout.EAST);
    }

    public JButton[] getBoutons() {
        return touches.getBoutons();
    }

    public void afficher(String texte) { affichage.afficher(texte); }

    public void effacerAffichage() { affichage.effacerTout(); }

    public void effacerDernier() {
        affichage.effacer();
    }

    public void ajouterHistorique(String expr, String res) {
        historique.ajouterCalcul(expr, res);
    }

    public void rafraichirHistorique() {
        historique.rafraichisHistorique();
    }

    public String conversionTexteTouches(String texte) {
        return touches.conversionEntree(texte);
    }

    public void creerHistorique() {
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

    public void changeSigne() {
        // A implementer
    }

}
