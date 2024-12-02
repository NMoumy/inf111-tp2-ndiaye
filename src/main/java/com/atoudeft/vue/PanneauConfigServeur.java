package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;

    public PanneauConfigServeur(String adr, int port) {
        this.txtAdrServeur = new JTextField(20);
        this.txtNumPort = new JTextField(20);

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel pTout = new JPanel(new GridLayout(2,1));

        JLabel lblAdr = new JLabel("Adresse IP : ");
        JLabel lblPort = new JLabel("Port : ");

        p1.add(lblAdr);
        p1.add(txtAdrServeur);

        p2.add(lblPort);
        p2.add(txtNumPort);

        pTout.add(p1);
        pTout.add(p2);
        this.add(pTout);
    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
