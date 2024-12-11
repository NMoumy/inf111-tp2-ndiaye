package com.atoudeft.vue;

import com.atoudeft.client.Client;
import com.atoudeft.controleur.EcouteurConnexion;
import com.atoudeft.controleur.EcouteurListeComptes;
import com.atoudeft.controleur.EcouteurOperationsCompte;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2024-11-01
 */
public class PanneauPrincipal  extends JPanel {
    private Client client;
    private PanneauConnexion panneauConnexion;
    private JPanel panneauCompteClient;

    private PanneauOperationsCompte panneauOperationsCompte;

    private static CardLayout cardLayout;
    private static JPanel panneauComposants;
    private PanneauDepotRetrait panneauRetrait, panneauDepot;
    private PanneauTransfert panneauTransfert;
    private PanneauFacture panneauFacture;

    private DefaultListModel<String> numerosComptes;
    private JList<String> jlNumerosComptes;
    private JDesktopPane bureau;


    public PanneauPrincipal(Client client) {
        this.client = client;

        panneauConnexion = new PanneauConnexion();
        panneauConnexion.setEcouteur(new EcouteurConnexion(client,panneauConnexion));

        panneauOperationsCompte = new PanneauOperationsCompte();
        panneauOperationsCompte.setEcouteur(new EcouteurOperationsCompte(client));

        cardLayout = new CardLayout();
        panneauComposants = new JPanel(cardLayout);

        panneauRetrait = new PanneauDepotRetrait("Retirer", client);
        panneauDepot = new PanneauDepotRetrait("Déposer", client);
        panneauTransfert = new PanneauTransfert(client);
        panneauFacture = new PanneauFacture(client);

        panneauComposants.add(panneauDepot, "DEPOT");
        panneauComposants.add(panneauRetrait, "RETRAIT");
        panneauComposants.add(panneauTransfert, "TRANSFERT");
        panneauComposants.add(panneauFacture, "FACTURE");

        panneauCompteClient = new JPanel();

        panneauCompteClient.setLayout(new BorderLayout());
        panneauCompteClient.setBackground(Color.WHITE);
        panneauOperationsCompte.setBackground(Color.WHITE);

        numerosComptes = new DefaultListModel<>();

        jlNumerosComptes = new JList<>(numerosComptes);
        jlNumerosComptes.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        jlNumerosComptes.setBorder(BorderFactory.createTitledBorder("Comptes bancaires"));
        jlNumerosComptes.setPreferredSize(new Dimension(250,500));


        panneauCompteClient.add(panneauOperationsCompte, BorderLayout.NORTH);
        panneauCompteClient.add(jlNumerosComptes, BorderLayout.WEST);
        panneauCompteClient.add(panneauComposants, BorderLayout.CENTER);

        //Enregistrement de l'écouteur de souris:
        jlNumerosComptes.addMouseListener(new EcouteurListeComptes(client));

        this.setLayout(new BorderLayout());

        this.add(panneauConnexion, BorderLayout.NORTH);
        this.add(panneauCompteClient, BorderLayout.CENTER);

        panneauCompteClient.setVisible(false);
    }

    public static void afficherPanneau(String action) {
        cardLayout.show(panneauComposants, action);
    }

    /**
     * Vide les éléments d'interface du panneauPrincipal.
     */
    public void vider() {
        this.numerosComptes.clear();
        this.bureau.removeAll();
    }
    public void cacherPanneauConnexion() {
        panneauConnexion.effacer();
        panneauConnexion.setVisible(false);
    }
    public void montrerPanneauConnexion() {
        panneauConnexion.setVisible(true);
    }
    public void cacherPanneauCompteClient() {
        panneauCompteClient.setVisible(false);
        this.numerosComptes.clear();
    }

    //Compte selectionne "SELECT"
    public void compteSelectionne(String numeroCompte, String typeCompte, String solde) {
        panneauOperationsCompte.informationsDuCompte(numeroCompte, typeCompte, solde);
    }

    public void montrerPanneauCompteClient() {
        panneauCompteClient.setVisible(true);
    }
    /**
     * Affiche un numéro de compte dans le JList des comptes.
     *
     * @param str chaine contenant le numéros de compte
     */
    public void ajouterCompte(String str) {
        numerosComptes.addElement(str);
    }
}