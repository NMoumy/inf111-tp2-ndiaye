package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauOperationsCompte extends JPanel {
    private JButton btnEpargne, btnDepot, btnRetrait, btnTransfert, btnFacture, btnHistorique;
    private JLabel lblSolde;
    private JPanel panneauBoutons;
    private static JPanel panneauComposants;
    private static CardLayout cardLayout; // Gère les composants de telle manière qu'un seul composant soit visible à la fois

    public PanneauOperationsCompte() {
        //panneauComposants = new PanneauComposantsOperations();

        // Creer les boutons
        btnEpargne = new JButton("Créer compte épargne");
        btnDepot = new JButton("Déposer");
        btnRetrait = new JButton("Retirer");
        btnTransfert = new JButton("Transferer");
        btnFacture = new JButton("Payer Facture");
        btnHistorique = new JButton("Historique du compte");
        lblSolde = new JLabel("Solde : ");

        // Initialisation des actions
        btnEpargne.setActionCommand("EPARGNE");
        btnDepot.setActionCommand("DEPOT");
        btnRetrait.setActionCommand("RETRAIT");
        btnTransfert.setActionCommand("TRANSFERT");
        btnFacture.setActionCommand("FACTURE");
        btnHistorique.setActionCommand("HIST");

        cardLayout = new CardLayout();
        panneauComposants = new JPanel(cardLayout);

        panneauComposants.add(PanneauDepotRetrait("Déposer"), "DEPOT");
        panneauComposants.add(PanneauDepotRetrait("Retirer"), "RETRAIT");
        panneauComposants.add(PanneauTransfert("transferer"), "TRANSFERT");
        panneauComposants.add(PanneauFacture("Régeler"), "FACTURE");

        //à compléter :
        this.setLayout(new BorderLayout());
        panneauBoutons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panneauBoutons.setBackground(Color.BLUE);
        panneauBoutons.add(lblSolde);
        panneauBoutons.add(btnEpargne);
        panneauBoutons.add(btnDepot);
        panneauBoutons.add(btnRetrait);
        panneauBoutons.add(btnTransfert);
        panneauBoutons.add(btnFacture);
        panneauBoutons.add(btnHistorique);

        this.add(panneauBoutons, BorderLayout.NORTH);
        this.add(panneauComposants, BorderLayout.CENTER);
    }

    private JPanel PanneauDepotRetrait(String operation) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        JLabel lblMontant = new JLabel("Montant:");
        JTextField txtMontant = new JTextField(10);
        JButton btnConfirmer = new JButton(operation);

        panel.add(lblMontant);
        panel.add(txtMontant);
        panel.add(btnConfirmer);
        return panel;
    }

    private JPanel PanneauFacture(String operation) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        JLabel lblMontant = new JLabel("Montant:");
        JTextField txtMontant = new JTextField(10);
        JLabel lblNumero = new JLabel("Numéro:");
        JTextField txtNumero = new JTextField(10);
        JLabel lblDescription = new JLabel("Description:");
        JTextField txtDescription = new JTextField(30);
        JButton btnConfirmer = new JButton("Envoyer");

        panel.add(lblMontant);
        panel.add(txtMontant);
        panel.add(lblNumero);
        panel.add(txtNumero);
        panel.add(lblDescription);
        panel.add(txtDescription);
        panel.add(btnConfirmer);
        return panel;
    }

    private JPanel PanneauTransfert(String operation) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        JLabel lblMontant = new JLabel("Montant:");
        JTextField txtMontant = new JTextField(10);
        JLabel lblDestinataire = new JLabel("Montant:");
        JTextField txtDestinataire = new JTextField(10);
        JButton btnConfirmer = new JButton("Envoyer");

        panel.add(lblMontant);
        panel.add(txtMontant);
        panel.add(lblDestinataire);
        panel.add(txtDestinataire);
        panel.add(btnConfirmer);
        return panel;
    }

    public static void afficherPanneau(String action) {
        cardLayout.show(panneauComposants, action);
    }

    public void setEcouteur(ActionListener ecouteur) {
        btnEpargne.addActionListener(ecouteur);
        btnDepot.addActionListener(ecouteur);
        btnRetrait.addActionListener(ecouteur);
        btnTransfert.addActionListener(ecouteur);
        btnFacture.addActionListener(ecouteur);
        btnHistorique.addActionListener(ecouteur);
    }

    //Compte selectionne "SELECT"
    public void informationsDuCompte(String numeroCompte, String typeCompte, String solde) {
        lblSolde.setText("Numero du Compte : " + numeroCompte + " (" + typeCompte + ") - Solde : " + solde + " $");
    }
}
