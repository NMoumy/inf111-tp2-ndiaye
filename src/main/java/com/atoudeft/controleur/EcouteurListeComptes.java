package com.atoudeft.controleur;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurListeComptes extends MouseAdapter {

    private Client client;
    public EcouteurListeComptes(Client client) {
        this.client = client;
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        //le double click
        if (evt.getClickCount() == 2) {
            //recuperer la liste de tous les comptes
            JList<?> liste = (JList<?>) evt.getSource();
            Object selectedValue = liste.getSelectedValue();
            //Si c'est pas null, tu envoies la commande SELECT au serveur
            if (selectedValue != null) {
                client.envoyer("SELECT " + selectedValue.toString());
            }
    }
    }
}
