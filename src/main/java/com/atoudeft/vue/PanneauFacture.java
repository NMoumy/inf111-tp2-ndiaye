package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;

public class PanneauFacture extends JPanel {
    private JTextField txtMontant, txtNumero, txtDescription;
    private JButton btnConfirmer, btnAnnuler;

    public PanneauFacture(Client client) {
        this.setLayout(new BorderLayout(20, 20));
        this.setBackground(new Color(240, 240, 240));

        JLabel lblTitle = new JLabel("Saisie de Facture", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(60, 60, 60));
        this.add(lblTitle, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(250, 250, 250));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel lblMontant = new JLabel("Montant :");
        JLabel lblNumero = new JLabel("Numéro :");
        JLabel lblDescription = new JLabel("Description :");

        txtMontant = new JTextField(20);
        txtNumero = new JTextField(20);
        txtDescription = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(lblMontant, gbc);

        gbc.gridx = 1;
        inputPanel.add(txtMontant, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(lblNumero, gbc);

        gbc.gridx = 1;
        inputPanel.add(txtNumero, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(lblDescription, gbc);

        gbc.gridx = 1;
        inputPanel.add(txtDescription, gbc);

        this.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(250, 250, 250));

        btnConfirmer = new JButton("Confirmer");
        btnConfirmer.setBackground(new Color(70, 130, 180));
        btnConfirmer.setForeground(Color.WHITE);
        btnConfirmer.setFocusPainted(false);

        btnAnnuler = new JButton("Annuler");
        btnAnnuler.setBackground(new Color(200, 200, 200));
        btnAnnuler.setForeground(Color.BLACK);
        btnAnnuler.setFocusPainted(false);

        buttonPanel.add(btnAnnuler);
        buttonPanel.add(btnConfirmer);

        this.add(buttonPanel, BorderLayout.SOUTH);

        btnConfirmer.addActionListener(e -> client.envoyer("FACTURE " + txtMontant.getText() + " " + txtNumero.getText() + " " + txtDescription.getText()));
        btnAnnuler.addActionListener(e -> clearFields());
    }

    private void clearFields() {
        txtMontant.setText("");
        txtNumero.setText("");
        txtDescription.setText("");
    }
}
