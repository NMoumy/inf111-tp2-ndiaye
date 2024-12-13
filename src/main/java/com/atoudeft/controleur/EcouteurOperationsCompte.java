package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.PanneauOperationsCompte;
import com.atoudeft.vue.PanneauPrincipal;

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

        PanneauPrincipal.afficherPanneau(action);

        if ("EPARGNE".equals(action)) {
            client.envoyer("EPARGNE");
        }
        if ("HIST".equals(action)) {
            client.envoyer("HIST");
        }

    }
}
