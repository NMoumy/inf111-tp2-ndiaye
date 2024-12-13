package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauOperationsCompte extends JPanel  {
    private JButton btnEpargne, btnDepot, btnRetrait, btnTransfert, btnFacture, btnHistorique;
    private JLabel lblSolde;
    //private JPanel panneauBoutons;

    public PanneauOperationsCompte() {
        // Creer les boutons
        btnEpargne = new JButton("Créer compte épargne");
        btnDepot = new JButton("Déposer");
        btnRetrait = new JButton("Retirer");
        btnTransfert = new JButton("Transferer");
        btnFacture = new JButton("Payer Facture");
        btnHistorique = new JButton("Historique du compte");
        lblSolde = new JLabel("Solde : 0$");

        // Initialisation des actions
        btnEpargne.setActionCommand("EPARGNE");
        btnDepot.setActionCommand("DEPOT");
        btnRetrait.setActionCommand("RETRAIT");
        btnTransfert.setActionCommand("TRANSFER");
        btnFacture.setActionCommand("FACTURE");
        btnHistorique.setActionCommand("HIST");

        //à compléter :
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.add(lblSolde);
        this.add(btnEpargne);
        this.add(btnDepot);
        this.add(btnRetrait);
        this.add(btnTransfert);
        this.add(btnFacture);
        this.add(btnHistorique);

        //this.add(panneauBoutons, BorderLayout.NORTH);
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
    public void getSoldeCompteActuel(String solde) {
        lblSolde.setText("Solde" + " : " + solde + "$");
    }
}
