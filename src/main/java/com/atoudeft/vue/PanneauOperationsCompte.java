package com.atoudeft.vue;

import com.atoudeft.controleur.EcouteurConnexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauOperationsCompte extends JPanel {
    private JButton btnEpargne, btnDepot, btnRetrait, btnTransfert, btnFacture, btnHistorique;
    private JLabel lblSolde;
    private JPanel panneauDuCentre, panneauBoutons;
    private CardLayout cardLayout; //represents a snapshot of an application that uses the CardLayout class to switch between two panel

    public PanneauOperationsCompte() {
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

        /*
        btnEpargne.addActionListener(this);
        btnDepot.addActionListener(this);
        btnRetrait.addActionListener(this);
        btnTransfert.addActionListener(this);
        btnFacture.addActionListener(this);
        btnHistorique.addActionListener(this);*/

        // Initialisation du layout du centre
        cardLayout = new CardLayout();
        panneauDuCentre = new JPanel(cardLayout);

        //à compléter :
        this.setLayout(new BorderLayout());
        panneauBoutons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panneauBoutons.add(lblSolde);
        panneauBoutons.add(btnEpargne);
        panneauBoutons.add(btnDepot);
        panneauBoutons.add(btnRetrait);
        panneauBoutons.add(btnTransfert);
        panneauBoutons.add(btnFacture);
        panneauBoutons.add(btnHistorique);

        // Ajout des panneaux d'opérations
        //panneauDuCentre.setUI();
        panneauDuCentre.add(PanneauDepotRetrait("Déposer"), "DEPOT");
        panneauDuCentre.add(PanneauDepotRetrait("Retirer"), "RETRAIT");
        panneauDuCentre.add(PanneauTransfert(), "TRANSFERT");
        panneauDuCentre.add(PanneauFacture(), "FACTURE");

        this.add(panneauBoutons, BorderLayout.NORTH);
        this.add(panneauDuCentre, BorderLayout.CENTER);
    }

    public void setEcouteur(ActionListener ecouteur) {
        btnEpargne.addActionListener(ecouteur);
        btnDepot.addActionListener(ecouteur);
        btnRetrait.addActionListener(ecouteur);
        btnTransfert.addActionListener(ecouteur);
        btnFacture.addActionListener(ecouteur);
        btnHistorique.addActionListener(ecouteur);
    }

    private JPanel PanneauDepotRetrait(String operation) {
        JPanel panel = new JPanel();
        JLabel lblMontant = new JLabel("Montant:");
        JTextField txtMontant = new JTextField(10);
        JButton btnConfirmer = new JButton(operation);

        panel.add(lblMontant);
        panel.add(txtMontant);
        panel.add(btnConfirmer);
        return panel;
    }

    private JPanel PanneauFacture() {
        JPanel panel = new JPanel();
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

    private JPanel PanneauTransfert() {
        JPanel panel = new JPanel();
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

    public void afficherPanneau(String action) {
        cardLayout.show(panneauDuCentre, action);
    }

    //Compte selectionne "SELECT"
    public void informationsDuCompte(String numeroCompte, String typeCompte, String solde) {
        lblSolde.setText("Numero du Compte : " + numeroCompte + " (" + typeCompte + ") - Solde : " + solde + " $");
    }
}
