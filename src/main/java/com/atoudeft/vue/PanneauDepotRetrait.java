package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauDepotRetrait extends JPanel {
    JTextField txtMontant;
    JButton btnConfirmer;

    public PanneauDepotRetrait(String operation, Client client) {
        this.setBackground(Color.RED);

        JLabel lblMontant = new JLabel("Montant :");

        txtMontant = new JTextField(10);
        btnConfirmer = new JButton(operation);

        this.add(lblMontant);
        this.add(txtMontant);
        this.add(btnConfirmer);

        if(operation.equals("Déposer"))
            btnConfirmer.addActionListener(e -> client.envoyer("DEPOT " + txtMontant.getText()));
        else
            btnConfirmer.addActionListener(e -> client.envoyer("RETRAIT " + txtMontant.getText()));
    }

}
