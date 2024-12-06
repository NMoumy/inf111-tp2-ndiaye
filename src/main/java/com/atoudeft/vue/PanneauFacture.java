package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanneauFacture extends JPanel {
    JTextField txtMontant, txtNumero, txtDescription;
    JButton btnConfirmer;

    public PanneauFacture(Client client) {
        //this.setBackground(Color.GREEN);

        JLabel lblMontant = new JLabel("Montant :");
        JLabel lblNumero = new JLabel("Numéro :");
        JLabel lblDescription = new JLabel("Description :");

        txtMontant = new JTextField(10);
        txtNumero = new JTextField(10);
        txtDescription = new JTextField(30);

        btnConfirmer = new JButton("Confirmer");

        this.add(lblMontant);
        this.add(txtMontant);

        this.add(lblNumero);
        this.add(txtNumero);

        this.add(lblDescription);
        this.add(txtDescription);

        this.add(btnConfirmer);

        btnConfirmer.addActionListener(e -> client.envoyer("FACTURE " + txtMontant.getText()+ ":" + txtNumero.getText()+ ":" + txtDescription.getText()));

        // OU

        /*btnConfirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.envoyer("FACTURE " + txtMontant.getText()+ ":" + txtNumero.getText()+ ":" + txtDescription.getText());
            }
       });*/
    }

}
