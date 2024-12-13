package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;

public class PanneauHistorique extends JPanel {
    JTextArea zoneHistorique;

    public PanneauHistorique(Client client) {
        zoneHistorique = new JTextArea(20, 50);
        zoneHistorique.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(zoneHistorique);

        this.add(scrollPane);
    }

    public void ajouterHistorique(String historique) {
        zoneHistorique.setText(historique);
    }

}
