package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanneauTransfert extends JPanel {
    JTextField txtMontant, txtDestinataire;
    JButton btnConfirmer;

    public PanneauTransfert(Client client) {
        this.setBackground(Color.YELLOW);

        JLabel lblMontant = new JLabel("Montant :");
        JLabel lblDestinataire = new JLabel("Destinataire :");

         txtMontant = new JTextField(10);
         txtDestinataire = new JTextField(10);

         btnConfirmer = new JButton("comfirmer");

        this.add(lblMontant);
        this.add(txtMontant);

        this.add(lblDestinataire);
        this.add(txtDestinataire);

        this.add(btnConfirmer);

        btnConfirmer.addActionListener(e -> client.envoyer("TRANSFER " + txtMontant.getText() + ":" + txtDestinataire.getText()));

    }
}
