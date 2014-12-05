package view.frames;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import business.Employe;
import business.SessionManager;
import controleurs.ControleurPlanifierReunion;
import view.components.*;
import view.tablemodels.ListeMesParticipationsTableModel;
import view.tablemodels.ListeMesReunionsTableModel;
/**
 * @author Marie Desaulniers
 * Interface graphique principale du planificateur de réunion
 */
public class PlanificateurReunion extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L; 
	private JTabbedPane onglet;
	private JPanel panMesReunions, panMesInvitations;
	private Bouton btCreerReunion, btModifier,btAnnuler, btFermer1, btFermer2, btAccepter,btRefuser;
	private JTable tableauReunions,tableauParticipations;
	private ListeDeroulante listeReunion1, listeReunion2;
    private Employe employeConnecte;

	public PlanificateurReunion(){
		// Configuration de la fenêtre
		this.setTitle("Accueil");
		this.setSize(500, 250);
		this.setResizable(false);
		this.setLocationRelativeTo(null);               
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Création des composants
		panMesReunions = new JPanel();
		panMesInvitations = new JPanel();
		int btWidth = 150;	int btHeight = 25;
		btCreerReunion = new Bouton("Nouvelle réunion...", btWidth, btHeight);
		btModifier = new Bouton("Modifier réunion...", btWidth, btHeight);
		btAnnuler = new Bouton("Annuler réunion", btWidth, btHeight);
		btFermer1 = new Bouton("Fermer", btWidth, btHeight);
		btFermer2 = new Bouton("Fermer", btWidth, btHeight);
		btAccepter = new Bouton("Accepter", btWidth, btHeight);
		btRefuser = new Bouton("Refuser", btWidth, btHeight);

		// Configuration des onglets
		onglet = new JTabbedPane();
		onglet.addTab("Mes Réunions", panMesReunions);
		onglet.addTab("Mes invitations",panMesInvitations);
		this.getContentPane().add(onglet);

		//Construction des tableaux mes reunions et mes participations
		tableauReunions = getListeMesReunions();
        tableauParticipations = getListeMesParticipations();

		listeReunion1 = new ListeDeroulante(tableauReunions, 300, 150);
		listeReunion2 = new ListeDeroulante(tableauParticipations, 300, 150);
		
		// Onglet MesReunion
		panMesReunions.setLayout(new GridBagLayout());
		GridBagConstraints gc1 = new GridBagConstraints();
		
		// Positionnement des composants sur la grille (boutons et tableau)
		gc1.insets = new Insets(5, 5, 3, 3);
		gc1.gridx=1;	gc1.gridy=0;
		panMesReunions.add(btCreerReunion, gc1);
		gc1.gridx=1;	gc1.gridy=1;
		panMesReunions.add(btModifier, gc1);
		gc1.gridx=1;	gc1.gridy=2;
		panMesReunions.add(btAnnuler, gc1);
		gc1.gridx=1;	gc1.gridy=3;
		gc1.anchor = GridBagConstraints.PAGE_END;
		panMesReunions.add(btFermer1, gc1);
		gc1.gridx=0;	gc1.gridy=0;
		gc1.gridheight = 4;
		panMesReunions.add(listeReunion1,gc1);
		
		// Onglet MesInvitations
		panMesInvitations.setLayout(new GridBagLayout());
		GridBagConstraints gc2 = new GridBagConstraints();
		
		// Positionnement des composants sur la grille (boutons et tableau)
		gc2.insets = new Insets(5, 5, 3, 3);
		gc2.gridx=1;	gc2.gridy=0;
		panMesInvitations.add(btAccepter, gc2);
		gc2.gridx=1;	gc2.gridy=1;
		panMesInvitations.add(btRefuser, gc2);
		gc2.gridx=1;	gc2.gridy=3;
		gc2.anchor = GridBagConstraints.PAGE_END;
		panMesInvitations.add(btFermer2, gc2);
		gc2.gridx=0;	gc2.gridy=0;
		gc2.gridheight = 4;
		panMesInvitations.add(listeReunion2,gc2);
		
		this.setVisible(true);

        // listener boutons
	    btCreerReunion.addActionListener(this);
	    btModifier.addActionListener(this);
	    btAnnuler.addActionListener(this);
	    btFermer1.addActionListener(this);
	    btFermer2.addActionListener(this);
	    btAccepter.addActionListener(this);
	    btRefuser.addActionListener(this);
    }
	
	@Override
	public void actionPerformed(ActionEvent evt)
	{
		// TODO Auto-generated method stub
	    Object src = evt.getSource();
	    if (src == btCreerReunion)
	    {
            ControleurPlanifierReunion.getInstance().afficheCreerReunion();
	    } 
	    else if (src == btModifier)
	    {
	     	
	    } 
	    else if (src == btAnnuler)
	    {
	    	// ... perform action for btAnnuler
	    } 
	    else if ((src == btFermer1) || (src == btFermer2))
	    {
	    	this.setVisible(false);
	    } 
	    else if (src == btAccepter)
	    {
	    	// ... perform action for btAccepter
	    }
	    else if (src == btRefuser)
	    {
	    	FenetreMotifRefus fenMotif = new FenetreMotifRefus();
	    }
        else if (src == btFermer1 || src == btFermer2 )
        {
            // fermer le programme
        }
	}

    private JTable getListeMesParticipations()
    {
        JTable table = new JTable(SessionManager.getInstance().getListeMesParticipationsTableModel());
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);

        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(20);
        return table;
    }

    private JTable getListeMesReunions()
    {
        JTable table = new JTable(SessionManager.getInstance().getListeMesReunionsTableModel());
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);

        table.getColumnModel().getColumn(1).setPreferredWidth(180);
        return table;
    }
}