package com.atoudeft.vue;

import com.atoudeft.client.Client;
import com.atoudeft.controleur.EcouteurConnexion;
import com.atoudeft.controleur.EcouteurListeComptes;
import com.atoudeft.controleur.EcouteurOperationsCompte;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2024-11-01
 */
public class PanneauPrincipal extends JPanel {
    private Client client;
    private PanneauConnexion panneauConnexion;
    private JPanel panneauCompteClient;

    private PanneauOperationsCompte panneauOperationsCompte;

    private static CardLayout cardLayout;
    private static JPanel panneauComposants;
    private PanneauDepotRetrait panneauRetrait, panneauDepot;
    private PanneauTransfert panneauTransfert;
    private PanneauFacture panneauFacture;
    private PanneauHistorique panneauHistorique;

    private DefaultListModel<String> numerosComptes;
    private JList<String> jlNumerosComptes;
    private JSplitPane splitPane;

    public PanneauPrincipal(Client client) {
        this.client = client;

        panneauConnexion = new PanneauConnexion();
        panneauConnexion.setEcouteur(new EcouteurConnexion(client, panneauConnexion));

        panneauOperationsCompte = new PanneauOperationsCompte();
        panneauOperationsCompte.setEcouteur(new EcouteurOperationsCompte(client));

        cardLayout = new CardLayout();
        panneauComposants = new JPanel(cardLayout);

        panneauRetrait = new PanneauDepotRetrait("Retirer", client);
        panneauDepot = new PanneauDepotRetrait("Déposer", client);
        panneauTransfert = new PanneauTransfert(client);
        panneauFacture = new PanneauFacture(client);
        panneauHistorique = new PanneauHistorique(client);

        panneauComposants.add(panneauDepot, "DEPOT");
        panneauComposants.add(panneauRetrait, "RETRAIT");
        panneauComposants.add(panneauTransfert, "TRANSFER");
        panneauComposants.add(panneauFacture, "FACTURE");
        panneauComposants.add(panneauHistorique, "HIST");

        panneauCompteClient = new JPanel();
        panneauCompteClient.setLayout(new BorderLayout(10, 10));
        panneauCompteClient.setBackground(new Color(245, 245, 245));

        numerosComptes = new DefaultListModel<>();
        jlNumerosComptes = new JList<>(numerosComptes);
        jlNumerosComptes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlNumerosComptes.setBorder(BorderFactory.createTitledBorder("Comptes bancaires"));
        jlNumerosComptes.setBackground(Color.WHITE);
        jlNumerosComptes.setFixedCellHeight(30);
        jlNumerosComptes.setFont(new Font("Arial", Font.PLAIN, 14));
        jlNumerosComptes.setSelectionBackground(new Color(100, 149, 237)); // Highlight color
        jlNumerosComptes.setSelectionForeground(Color.WHITE);

        JScrollPane listScrollPane = new JScrollPane(jlNumerosComptes);
        listScrollPane.setPreferredSize(new Dimension(250, 500));
        listScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScrollPane, panneauComposants);
        splitPane.setDividerSize(8);
        splitPane.setResizeWeight(0.3);
        splitPane.setOneTouchExpandable(true);

        panneauCompteClient.add(panneauOperationsCompte, BorderLayout.NORTH);
        panneauCompteClient.add(splitPane, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(panneauConnexion, BorderLayout.NORTH);
        this.add(panneauCompteClient, BorderLayout.CENTER);

        panneauCompteClient.setVisible(false);

        jlNumerosComptes.addMouseListener(new EcouteurListeComptes(client));
    }

    public static void afficherPanneau(String action) {
        cardLayout.show(panneauComposants, action);
    }

    /**
     * Vide les éléments d'interface du panneauPrincipal.
     */
    public void vider() {
        this.numerosComptes.clear();
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

    public void recupererSolde(String solde) {
        panneauOperationsCompte.getSoldeCompteActuel(solde);
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

    public void ajouterMessageHistorique(String str) {
        panneauHistorique.ajouterHistorique(str);
    }
}
