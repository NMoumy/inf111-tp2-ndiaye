package com.atoudeft.controleur;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;

    public EcouteurOperationsCompte(Client client) {
        this.client = client;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //à compléter :
        Object source = e.getSource();
        String action = e.getActionCommand();


        if (source instanceof JButton) {
            action = ((JButton)source).getActionCommand();
            switch (action) {
                case "EPARGNE":
                    //client.envoyer("EPARGNE");
                    break;
                case "DEPOT":
                    //afficherPanneau("DEPOT");
                    //client.envoyer("DEPOT");
                    break;
                case "RETRAIT":
                    //afficherPanneau("RETRAIT");
                    //client.envoyer("RETRAIT");
                    break;
                case "TRANSFERT":
                    //afficherPanneau("TRANSFERT");
                    //client.envoyer("TRANSFERT");
                    break;
                case "FACTURE":
                    //afficherPanneau("FACTURE");
                    //client.envoyer("FACTURE");
                    break;
            }
        }
    }
}
